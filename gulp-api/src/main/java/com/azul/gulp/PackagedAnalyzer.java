package com.azul.gulp;

@FunctionalInterface
public interface PackagedAnalyzer<R> extends ResultProvider<R> {
  R analyze(final GulpLog log);
}
