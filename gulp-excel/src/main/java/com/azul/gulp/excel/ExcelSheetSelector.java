package com.azul.gulp.excel;

public interface ExcelSheetSelector {
  boolean matches(final int index, final String name);
}
