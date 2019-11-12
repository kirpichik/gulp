package com.azul.gulp.matching;

public class Patterns {
  public static PatternBuilder builder() {
    return new PatternBuilder();
  }
  
  public static Pattern one(final Class<?> type) {
    return builder().one(type).make();
  }
  
  public static Pattern many(final Class<?> type) {
    return builder().many(type).make();
  }
}
