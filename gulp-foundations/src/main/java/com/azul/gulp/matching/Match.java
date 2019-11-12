package com.azul.gulp.matching;

import java.util.List;

public interface Match {
  <T> T get(final int index);
  
  <T> List<T> list(final int index);
}
