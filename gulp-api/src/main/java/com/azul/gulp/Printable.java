package com.azul.gulp;

import java.io.PrintStream;

public interface Printable {
  default String toPrintString() {
    return this.toString();
  }
  
  default void print() {
    this.printTo(System.out);
  }
  
  default void printTo(final PrintStream printStream) {
    printStream.println(this.toPrintString());
  }
}
