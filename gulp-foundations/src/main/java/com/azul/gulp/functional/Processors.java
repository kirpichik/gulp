package com.azul.gulp.functional;

import java.util.Collection;
import java.util.Map;

import com.azul.gulp.Predicate;
import com.azul.gulp.Processor;
import com.azul.gulp.ThrowingFunction;
import com.azul.gulp.functional.inject.InjectionAwareProcessor;
import com.azul.gulp.inject.InjectionContext;

public final class Processors {
  private Processors() {}
  
  public static <T> Processor<T> filter(
      final Predicate<? super T> predicate,
      final Processor<? super T> processor)
  {
    return new InjectionAwareProcessor<T>() {
      @Override
      public void onInject(final InjectionContext ctx) {
        ctx.inject(predicate);
        ctx.inject(processor);
      }
      
      @Override
      public void process(final T object) throws Exception {
        if ( predicate.matches(object) ) {
          processor.process(object);
        }
      }
    };
  }
  
  public static <T, U> Processor<T> map(
      final ThrowingFunction<? super T, ? extends U> mappingFn,
      final Processor<? super U> processor)
  {
    return new InjectionAwareProcessor<T>() {
      @Override
      public void onInject(final InjectionContext ctx) {
        ctx.inject(mappingFn);
        ctx.inject(processor);
      }
      
      @Override
      public final void process(final T object) throws Exception {
        processor.process(mappingFn.apply(object));
      }
    };
  }
  
  public static <T> Processor<T> addTo(final Collection<? super T> collection) {
    return object -> collection.add(object);
  }
  
  public static <K, V> Processor<V> addToMap(
      final Map<? super K, ? super V> map,
      final ThrowingFunction<? super V, ? extends K> keyFn)
  {
    return object -> map.put(keyFn.apply(object), object);
  }
}
