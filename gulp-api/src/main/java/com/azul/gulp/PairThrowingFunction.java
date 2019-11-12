package com.azul.gulp;

@FunctionalInterface
public interface PairThrowingFunction<F, S, R> {
  R apply(F first, S second);
}
