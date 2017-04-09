package com.michaelszymczak.diamond

import spock.lang.Specification

class AlphabetShould extends Specification {
  def "know letters zero-based position"() {
    expect:
    new Alphabet().positionOf(Letter.A) == 0
    new Alphabet().positionOf(Letter.B) == 1
    new Alphabet().positionOf(Letter.K) == 10
    new Alphabet().positionOf(Letter.K) == 10
    new Alphabet().positionOf(Letter.Z) == 25
  }

  def "generate sequence of letters up to the specified one"() {
    given:
    def alphabet = new Alphabet()

    expect:
    alphabet.sequenceUpTo(Letter.A) == [new OrderedLetter(Letter.A, 0)]
    alphabet.sequenceUpTo(Letter.C) == [new OrderedLetter(Letter.A, 0), new OrderedLetter(Letter.B, 1), new OrderedLetter(Letter.C, 2)]
    alphabet.sequenceUpTo(Letter.Z).size() == alphabet.positionOf(Letter.Z) + 1
  }
}
