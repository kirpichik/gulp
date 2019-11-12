package com.azul.gulp.inject;

import java.util.Set;

public interface Injector {
  Set<Class<?>> requires();
  
  <T> void inject(final Class<T> type, final T value);
}
