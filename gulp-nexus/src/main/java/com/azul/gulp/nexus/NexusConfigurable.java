package com.azul.gulp.nexus;

public interface NexusConfigurable {
  default void init(final Nexus engine) {}
}
