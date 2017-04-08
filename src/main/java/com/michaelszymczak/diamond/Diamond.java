package com.michaelszymczak.diamond;

import java.util.Arrays;

public class Diamond {
  private final char lastLetter;

  public Diamond(char lastLetter) {
    this.lastLetter = lastLetter;
  }

  @Override
  public String toString() {
    return lastLetter == 'A' ? new Board(Arrays.asList(new Board.Cell(0,0,'A'))).toString()
            : new Board(Arrays.asList(new Board.Cell(0,1,'A'), new Board.Cell(1,0,'B'), new Board.Cell(1,2,'B'), new Board.Cell(2,1,'A'))).toString();
  }
}
