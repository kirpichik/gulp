package com.azul.gulp.properties;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public interface Property {
  String name();
  
  Class<?> targetType();
  
  Class<?> type();
  
  Type genericType();
  
  Object get(Object target);
  
  <T extends Annotation> T annotation(final Class<T> annoClass);
}
