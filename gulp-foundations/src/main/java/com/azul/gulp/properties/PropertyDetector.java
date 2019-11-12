package com.azul.gulp.properties;

import java.util.Map;

public interface PropertyDetector {
  Map<String, Property> getProperties(final Class<?> aClass);
}
