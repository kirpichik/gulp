package com.azul.gulp.text;

import com.azul.gulp.Normalizer;
import com.azul.gulp.inject.InjectionContext;
import com.azul.gulp.text.support.InjectableNormalizer;

public final class LineNormalizers {
  private LineNormalizers() {}
  
  public static LineNormalizer stripLeading(final char ch) {
    return line -> {
      for ( int i = 0; i < line.length(); ++i ) {
        if ( line.charAt(i) != ch ) {
          return line.substring(i);
        }
      }
      // emtpy line?
      return line;
    };
  }
  
  public static LineNormalizer stripLeading(final int numChars) {
    return line -> {
      if ( line.length() < numChars ) {
        return line;
      } else {
        return line.substring(numChars);
      }
    };
  }
  
  public static Normalizer<Line> toGenericNormalizer(final LineNormalizer lineNormalizer) {
    return new InjectableNormalizer<Line>() {
      @Override
      public final void onInject(final InjectionContext ctx) {
        ctx.inject(lineNormalizer);
      }
      
      @Override
      public final Line normalize(final Line in) throws Exception {
        String normalizedContents = lineNormalizer.normalize(in.contents);
        
        return new Line(in.num, normalizedContents, in.originalContents);
      }
    };
  }
}
