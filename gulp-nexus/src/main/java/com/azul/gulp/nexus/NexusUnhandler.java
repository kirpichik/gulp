package com.azul.gulp.nexus;

public interface NexusUnhandler<T> extends NexusConfigurable {
  void unhandle(final T value) throws Exception;
  
  default void finish() {}
}
