package com.azul.gulp;

@FunctionalInterface
public interface Processor<T> {
  void process(final T object) throws Exception;
}
