package com.azul.gulp;

@FunctionalInterface
public interface PairPredicate<F, S> {
  boolean matches(final F first, final S second);
}
