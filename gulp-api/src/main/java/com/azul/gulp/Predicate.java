package com.azul.gulp;

@FunctionalInterface
public interface Predicate<T> {
  boolean matches(final T value);
}
