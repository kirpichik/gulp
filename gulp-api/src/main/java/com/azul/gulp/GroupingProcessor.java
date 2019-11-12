package com.azul.gulp;

@FunctionalInterface
public interface GroupingProcessor<K, E> {
  void process(
          GroupBuilder<K, E> groups,
          E element)
    throws Exception;
}
