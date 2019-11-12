package com.azul.gulp;

@FunctionalInterface
public interface Function<I, O> extends ThrowingFunction<I, O> {
  O apply(I in);
}
