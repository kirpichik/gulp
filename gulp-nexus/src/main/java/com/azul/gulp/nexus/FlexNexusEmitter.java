package com.azul.gulp.nexus;

public interface FlexNexusEmitter {
  <T> void fire(final Class<T> type, final T value);
}
