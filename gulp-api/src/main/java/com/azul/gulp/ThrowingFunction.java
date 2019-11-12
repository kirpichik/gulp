package com.azul.gulp;

@FunctionalInterface
public interface ThrowingFunction<I, O> {
  O apply(I input) throws Exception;
}
