package com.azul.gulp;

@FunctionalInterface
public interface IndexedProcessor<T> {
  void process(final int index, final T object);
}
