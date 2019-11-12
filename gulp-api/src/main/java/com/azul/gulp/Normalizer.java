package com.azul.gulp;

@FunctionalInterface
public interface Normalizer<T> {
  T normalize(final T value) throws Exception;
}
