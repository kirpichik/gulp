package com.azul.gulp;

import java.util.Set;

public interface GulpStreamExtension<E extends GulpStreamExtension<E, T>, T> 
  extends GulpStream<T>
{
  E filter(Predicate<? super T> predicate);
  
  E filter(Set<? super T> set);
  
  @SuppressWarnings("unchecked")
  E filter(T... set);
  
  E filterOut(Predicate<? super T> predicate);
  
  E filterOut(Set<? super T> set);
  
  @SuppressWarnings("unchecked")
  E filterOut(T... set);
  
  E unique();
  
  E unique(final ThrowingFunction<? super T, ?> identityFn);

}
