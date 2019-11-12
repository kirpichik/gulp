package com.azul.gulp.text;

@FunctionalInterface
public interface LineNormalizer {
  String normalize(final String line);
}
