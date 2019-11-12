package com.azul.gulp.inject;

public interface InjectionContext {
  <T> T create(final Class<T> type);
  
  // public abstract <T> T create(final Class<T> rawType, final Class<?>... typeParams);
  
  <T> T get(final Class<T> type);
  
  <T> T get(final Class<T> rawType, final Class<?>... typeParams);
  
  void inject(final Object obj);
}
