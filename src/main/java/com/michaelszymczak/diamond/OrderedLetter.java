package com.michaelszymczak.diamond;

import com.google.common.collect.ImmutableSet;

import java.util.Set;

public class OrderedLetter {
  private final Letter letter;
  private final int ordinalNumber;

  public OrderedLetter(Letter letter, int ordinalNumber) {
    this.letter = letter;
    this.ordinalNumber = ordinalNumber;
  }

  public Letter getLetter() {
    return letter;
  }

  public int getOrdinalNumber() {
    return ordinalNumber;
  }

  public Set<PositionedLetter> positionedAgainstHighest(OrderedLetter highestOrderedLetter) {
    return ImmutableSet.of(
            new PositionedLetter(Coordinates.ofYX(ordinalNumber,highestOrderedLetter.getOrdinalNumber() + ordinalNumber), letter),
            new PositionedLetter(Coordinates.ofYX(highestOrderedLetter.getOrdinalNumber() * 2 - ordinalNumber,highestOrderedLetter.getOrdinalNumber() - ordinalNumber), letter)
    );
  }
}
