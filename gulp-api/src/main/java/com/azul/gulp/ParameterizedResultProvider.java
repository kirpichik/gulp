package com.azul.gulp;

@Deprecated
public interface ParameterizedResultProvider<P, V> {
  V get(P param);
}
