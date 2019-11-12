package com.azul.gulp;

public interface Group<K, E> extends Iterable<E> {
  K key();
  
  int size();
}
