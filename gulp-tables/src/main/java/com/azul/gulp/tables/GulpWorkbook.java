package com.azul.gulp.tables;

public interface GulpWorkbook {
  GulpSheet sheetByName(final String name);

  GulpSheet sheetAt(final int index);
  
  Iterable<GulpSheet> sheets();

  GulpSheet curSheet();
}
