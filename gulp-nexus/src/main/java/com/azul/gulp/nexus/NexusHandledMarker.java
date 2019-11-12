package com.azul.gulp.nexus;

public interface NexusHandledMarker<T> extends NexusConfigurable {
  boolean isActivated();
  
  void mark(final T value);
}
