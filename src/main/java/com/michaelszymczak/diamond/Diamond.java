package com.michaelszymczak.diamond;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class Diamond {

  private final Alphabet alphabet;
  private final OrderedLetter lastLetter;

  public Diamond(char lastLetter) {
    this.alphabet = new Alphabet();
    this.lastLetter = new OrderedLetter(new Letter(lastLetter), alphabet.positionOf(new Letter(lastLetter)));
  }

  @Override
  public String toString() {
    return new Board(orderedLetters()).toString();
  }

  private Set<PositionedLetter> orderedLetters() {
    return alphabet
            .sequenceUpTo(lastLetter.getLetter()).stream()
            .flatMap(orderedLetter -> orderedLetter.positionedAgainstHighest(lastLetter).stream())
            .collect(toSet());
  }
}
