package com.azul.gulp;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import com.azul.gulp.foundations.GulpStreamPlain;
import com.azul.gulp.foundations.StreamCore;

public final class GulpCollections {
  private GulpCollections() {}
  
  public static <K, V> GulpPairStream<K, V> gulpify(final Map<K, V> map) {
    return gulpify(map.entrySet()).map(Map.Entry::getKey, Map.Entry::getValue);
  }
  
  public static GulpStream<Boolean> gulpify(final boolean... elements) {
    return new GulpStreamPlain<>(new StreamCore<Boolean>() {
      @Override
      protected final void processImpl(final Processor<? super Boolean> processor) throws StreamProcessingException {
        try {
          for (boolean element : elements) {
            processor.process(element);
          }
        } catch (Exception e) {
          throw new StreamProcessingException(e);
        }
      }
    });
  }
  public static void forEach(final boolean[] elements, final Processor<? super Boolean> proc) {
    gulpify(elements).forEach(proc);
  }
  
  public static GulpStream<Integer> gulpify(final int... elements) {
    return new GulpStreamPlain<>(new StreamCore<Integer>() {
      @Override
      protected final void processImpl(final Processor<? super Integer> processor) throws StreamProcessingException {
        try {
          for (int element : elements) {
            processor.process(element);
          }
        } catch (Exception e) {
          throw new StreamProcessingException(e);
        }
      }
    });
  }
  
  public static void forEach(final int[] elements, final Processor<? super Integer> proc) {
    gulpify(elements).forEach(proc);
  }
  
  public static GulpStream<Long> gulpify(final long... elements) {
    return new GulpStreamPlain<>(new StreamCore<Long>() {
      @Override
      protected final void processImpl(final Processor<? super Long> processor) throws StreamProcessingException {
        try {
          for (long element : elements) {
            processor.process(element);
          }
        } catch (Exception e) {
          throw new StreamProcessingException(e);
        }
      }
    });
  }
  
  public static void forEach(final long[] elements, final Processor<? super Long> proc) {
    gulpify(elements).forEach(proc);
  }
  
  public static GulpStream<Float> gulpify(final float... elements) {
    return new GulpStreamPlain<>(new StreamCore<Float>() {
      @Override
      protected final void processImpl(final Processor<? super Float> processor) throws StreamProcessingException {
        try {
          for (float element : elements) {
            processor.process(element);
          }
        } catch (Exception e) {
          throw new StreamProcessingException(e);
        }
      }
    });
  }
  
  public static void forEach(final float[] elements, final Processor<? super Float> proc) {
    gulpify(elements).forEach(proc);
  }
  
  public static GulpStream<Double> gulpify(final double... elements) {
    return new GulpStreamPlain<>(new StreamCore<Double>() {
      @Override
      protected final void processImpl(final Processor<? super Double> processor) throws StreamProcessingException {
        try {
          for (double element : elements) {
            processor.process(element);
          }
        } catch (Exception e) {
          throw new StreamProcessingException(e);
        }
      }
    });
  }
  
  public static void forEach(final double[] elements, final Processor<? super Double> proc) {
    gulpify(elements).forEach(proc);
  }
  
  @SafeVarargs
  public static <T> GulpStream<T> gulpify(final T... elements) {
    return new GulpStreamPlain<>(new StreamCore<T>() {
      @Override
      protected final void processImpl(final Processor<? super T> processor) throws StreamProcessingException {
        try {
          for (T element : elements) {
            processor.process(element);
          }
        } catch (Exception e) {
          throw new StreamProcessingException(e);
        }
      }
    });
  }
  
  public static <T> void forEach(final T[] elements, final Processor<? super T> proc) {
    gulpify(elements).forEach(proc);
  }
  
  public static <T> GulpStream<T> gulpify(final Collection<? extends T> collection) {
    return new GulpStreamPlain<>(new StreamCore<T>() {
      @Override
      protected final void processImpl(final Processor<? super T> processor) throws StreamProcessingException {
        collection.forEach(t -> {
          try {
            processor.process(t);
          } catch (Exception e) {
            throw new StreamProcessingException(e);
          }
        });
      }
    });
  }
  
  public static <T> void forEach(final Collection<? extends T> elements, final Processor<? super T> proc) {
    gulpify(elements).forEach(proc);
  }
  
  public static <T> GulpStream<T> gulpify(final Iterable<? extends T> iterable) {
    return new GulpStreamPlain<>(new StreamCore<T>() {
      @Override
      protected final void processImpl(final Processor<? super T> processor) throws StreamProcessingException {
        iterable.forEach(t -> {
          try {
            processor.process(t);
          } catch (Exception e) {
            throw new StreamProcessingException(e);
          }
        });
      }
    });
  }
  
  public static <T> void forEach(final Iterable<? extends T> elements, final Processor<? super T> proc) {
    gulpify(elements).forEach(proc);
  }
  
  public static <T> GulpStream<T> gulpify(final Stream<? extends T> stream) {
    return new GulpStreamPlain<>(new StreamCore<T>() {
      @Override
      protected final void processImpl(final Processor<? super T> processor) throws StreamProcessingException {
        stream.forEach(t -> {
          try {
            processor.process(t);
          } catch (Exception e) {
            throw new StreamProcessingException(e);
          }
        });
      }
    });
  }
  
  public static <T> void forEach(final Stream<? extends T> elements, final Processor<? super T> proc) {
    gulpify(elements).forEach(proc);
  }
  
  public static <T> Set<T> toSet(final Iterable<T> iterable) {
    return gulpify(iterable).toSet();
  }
  
  public static <T> Set<T> toSet(final Stream<T> stream) {
    return gulpify(stream).toSet();
  }

  public static <T> List<T> toList(final Iterable<T> iterable) {
    return gulpify(iterable).toList();
  }
  
  public static <T> List<T> toList(final Stream<T> stream) {
    return gulpify(stream).toList();
  }
  
  public static void print(final Map<?, ?> map) {
    gulpify(map).print();
  }
  
  public static void print(final Collection<?> collection) {
    gulpify(collection).print();
  }

  public static void print(final Iterable<?> iterable) {
    gulpify(iterable).print();
  }
  
  public static void print(final Stream<?> stream) {
    gulpify(stream).print();
  }
  
  public static <T> GulpLog logify(
    final Class<T> type,
    final Collection<? extends T> collection)
  {
    return new CollectionBackedGulpLog<>(type, collection);
  }
}
