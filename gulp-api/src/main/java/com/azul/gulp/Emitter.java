package com.azul.gulp;

@FunctionalInterface
public interface Emitter<O> {
  void fire(final O value);
}
