package com.azul.gulp.nexus;

public interface NexusHandler<T> extends NexusConfigurable {
  void handle(final T value) throws Exception;
  
  default void finish() throws Exception {}
}
