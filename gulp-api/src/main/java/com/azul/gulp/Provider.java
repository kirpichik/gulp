package com.azul.gulp;

@FunctionalInterface
public interface Provider<T> {
  T get();
}
