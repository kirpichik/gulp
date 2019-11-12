package com.azul.gulp;

@FunctionalInterface
public interface PairProcessor<F, S> {
  void process(F first, S second);
}
