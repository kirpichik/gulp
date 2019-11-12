package com.azul.gulp.tables;

import com.azul.gulp.GulpStream;
import com.azul.gulp.Normalizer;
import com.azul.gulp.Predicate;
import com.azul.gulp.foundations.GulpLogExtension;

public interface GulpSheet extends GulpLogExtension<GulpSheet> {
  GulpSheet subsheet(final int startIndexInclusive);
  
  GulpSheet subsheet(
          final int startIndexInclusive,
          final int endIndexExclusive);
  
  default GulpSheet skipHeader() {
    return this.subsheet(1);
  }
  
  default GulpStream<GulpRow> rows() {
    return this.select(GulpRow.class);
  }
  
  default GulpStream<GulpRow> rows(int startIndexInclusive) {
    return this.subsheet(startIndexInclusive).rows();
  }
  
  default GulpStream<GulpRow> rows(
          final int startIndexInclusive,
          final int endIndexExclusive)
  {
    return this.subsheet(startIndexInclusive, endIndexExclusive).rows();
  }
  
  default GulpSheet normalize(final Normalizer<GulpRow> rowNormalizer) {
    return this.normalize(GulpRow.class, rowNormalizer);
  }
  
  default GulpSheet filter(final Predicate<? super GulpRow> predicateFn) {
    return this.normalize(row -> predicateFn.matches(row) ? row : null);
  }
  
  default GulpSheet filterOut(final Predicate<? super GulpRow> predicateFn) {
    return this.normalize(row -> predicateFn.matches(row) ? null : row);
  }
}
