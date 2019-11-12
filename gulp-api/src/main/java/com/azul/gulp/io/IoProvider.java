package com.azul.gulp.io;

import java.io.IOException;

@FunctionalInterface
public interface IoProvider<T> {
  T open() throws IOException;
}