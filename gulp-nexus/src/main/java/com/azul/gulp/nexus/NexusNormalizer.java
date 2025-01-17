package com.azul.gulp.nexus;

public interface NexusNormalizer<T> extends NexusConfigurable {
  T normalize(final T value) throws Exception;
}
