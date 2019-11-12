package com.azul.gulp;

@FunctionalInterface
public interface Enricher<T, V> {
  V enrichment(final T element);
}
