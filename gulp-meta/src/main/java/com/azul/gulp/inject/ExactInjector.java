package com.azul.gulp.inject;

import java.lang.reflect.Type;
import java.util.Set;

public interface ExactInjector {
  Set<Type> requires();
  
  void inject(final Type type, final Object value);
}
