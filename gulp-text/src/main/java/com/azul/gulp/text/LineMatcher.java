package com.azul.gulp.text;

import com.azul.gulp.Emitter;

public interface LineMatcher<T> {
  void process(final Line line, final Emitter<T> emitter) throws Exception;
}
