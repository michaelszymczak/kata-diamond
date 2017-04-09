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
            new PositionedLetter(Coordinates.ofYX(ordinalNumber,highestOrderedLetter.getOrdinalNumber() - ordinalNumber), letter),
            new PositionedLetter(Coordinates.ofYX(ordinalNumber,highestOrderedLetter.getOrdinalNumber() + ordinalNumber), letter),
            new PositionedLetter(Coordinates.ofYX(highestOrderedLetter.getOrdinalNumber() * 2 - ordinalNumber,highestOrderedLetter.getOrdinalNumber() - ordinalNumber), letter),
            new PositionedLetter(Coordinates.ofYX(highestOrderedLetter.getOrdinalNumber() * 2 - ordinalNumber,highestOrderedLetter.getOrdinalNumber() + ordinalNumber), letter)
    );
  }

  @Override
  public String toString() {
    return "OrderedLetter{" +
            "letter=" + letter +
            ", ordinalNumber=" + ordinalNumber +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    OrderedLetter that = (OrderedLetter) o;

    if (ordinalNumber != that.ordinalNumber) return false;
    return letter != null ? letter.equals(that.letter) : that.letter == null;

  }

  @Override
  public int hashCode() {
    int result = letter != null ? letter.hashCode() : 0;
    result = 31 * result + ordinalNumber;
    return result;
  }
}
