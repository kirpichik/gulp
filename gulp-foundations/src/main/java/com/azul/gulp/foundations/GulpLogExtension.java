package com.azul.gulp.foundations;

import com.azul.gulp.Enricher;
import com.azul.gulp.GulpLog;
import com.azul.gulp.Normalizer;

public interface GulpLogExtension<E extends GulpLogExtension<E>> extends GulpLog {
  E prefetch();
  
  <T> E normalize(
          final Class<T> type,
          final Normalizer<T> normalizer);
  
  <T, V> E enrich(
          final Class<T> inputType,
          final Class<V> enrichmentType,
          final Enricher<? super T, ? extends V> enricher);
}
