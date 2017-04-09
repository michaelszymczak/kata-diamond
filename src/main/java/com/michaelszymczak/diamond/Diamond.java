package com.michaelszymczak.diamond;

import com.google.common.collect.ImmutableSet;

import java.util.Set;

public class Diamond {
  private final Letter lastLetter;

  public Diamond(char lastLetter) {
    this.lastLetter = new Letter(lastLetter);
  }

  @Override
  public String toString() {
    return new Board(orderedLetters()).toString();
  }

  private Set<PositionedLetter> orderedLetters() {
    return Letter.A.equals(lastLetter) ? new OrderedLetter(Letter.A, 0).positionedAgainstHighest(new OrderedLetter(Letter.A, 0)) :
            new ImmutableSet.Builder<PositionedLetter>()
                    .addAll(new OrderedLetter(Letter.A, 0).positionedAgainstHighest(new OrderedLetter(Letter.B, 1)))
                    .addAll(new OrderedLetter(Letter.B, 1).positionedAgainstHighest(new OrderedLetter(Letter.B, 1)))
                    .build();
  }
}
