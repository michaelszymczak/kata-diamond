package com.michaelszymczak.diamond;

import java.util.Arrays;

import static com.michaelszymczak.diamond.Letter.A;
import static com.michaelszymczak.diamond.Letter.B;

public class Diamond {
  private final Letter lastLetter;

  public Diamond(char lastLetter) {
    this.lastLetter = new Letter(lastLetter);
  }
//
//  Collection<PositionedLetter> positioned(Letter highestLetter)
//  {
//    return null;
//  }

  @Override
  public String toString() {
    return Letter.A.equals(lastLetter) ? new Board(Arrays.asList(new PositionedLetter(Coordinates.ofYX(0,0), A))).toString()
            : new Board(Arrays.asList(
            new PositionedLetter(Coordinates.ofYX(0,1),A), new PositionedLetter(Coordinates.ofYX(1,0), B), new PositionedLetter(Coordinates.ofYX(1,2),B), new PositionedLetter(Coordinates.ofYX(2,1),A))).toString();
  }
}
