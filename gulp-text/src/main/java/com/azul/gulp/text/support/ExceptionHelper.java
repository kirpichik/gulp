package com.azul.gulp.text.support;

import java.io.IOException;

final class ExceptionHelper {
  public interface Statement {
    void execute();
  }
  
  public static void rethrowIO(Statement stmt)
    throws IOException
  {
    ExceptionHelper exHelper = new ExceptionHelper();
    exHelper.tryExecute(stmt);
    exHelper.rethrowIO();
  }
  
  public static void rethrowRuntime(Statement stmt)
    throws RuntimeException
  {
    ExceptionHelper exHelper = new ExceptionHelper();
    exHelper.tryExecute(stmt);
    exHelper.rethrowRuntime();
  }
  
  public static void rethrowIllegal(Statement stmt)
    throws RuntimeException
  {
    ExceptionHelper exHelper = new ExceptionHelper();
    exHelper.tryExecute(stmt);
    exHelper.rethrowIllegal();
  }
  
  private Exception capturedEx = null;
  
  public ExceptionHelper() {}
  
  public void tryExecute(Statement stmt) {
    if ( this.capturedEx != null ) return;
    
    try {
      stmt.execute();
    } catch ( Exception e ) {
      this.recordException(e);
    }
  }
  
  public void recordException(final Exception e) {
    this.capturedEx = e;
  }
  
  public void rethrow() throws Exception {
    if ( this.capturedEx != null ) throw this.capturedEx;
  }
  
  public void rethrowRuntime() throws RuntimeException {
    if ( this.capturedEx instanceof RuntimeException ) {
      throw (RuntimeException)this.capturedEx;
    } else if ( this.capturedEx != null ) {
      throw new RuntimeException(this.capturedEx);
    }
  }
  
  public void rethrowIO() throws IOException {
    if ( this.capturedEx instanceof IOException ) {
      throw (IOException)this.capturedEx;
    } else if ( this.capturedEx != null ) {
      throw new IOException(this.capturedEx);
    }
  }
  
  public void rethrowIllegal() throws IllegalStateException {
    if ( this.capturedEx instanceof IllegalStateException ) {
      throw (IllegalStateException)this.capturedEx;
    } else if ( this.capturedEx != null ) {
      throw new IllegalStateException(this.capturedEx);
    }
  }
}
