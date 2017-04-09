package com.michaelszymczak.diamond

import spock.lang.Specification

class OrderedLetterShould extends Specification {

  def "keep the letter"() {
    expect:
    new OrderedLetter(Letter.C, 0).positionedAgainstHighest(new OrderedLetter(Letter.B, 1))
            .collect { it.letterAsString() } as Set == ["C"] as Set
  }

  def "position itself as the only letter if only one exists"() {
    expect:
    new OrderedLetter(Letter.A, 0).positionedAgainstHighest(new OrderedLetter(Letter.A, 0)) == [
            new PositionedLetter(Coordinates.ofYX(0,0), Letter.A)
    ] as Set
  }

  def "position itself on top and bottom if first of two letters"() {
    expect:
    new OrderedLetter(Letter.A, 0).positionedAgainstHighest(new OrderedLetter(Letter.B, 1)) == [
            new PositionedLetter(Coordinates.ofYX(0,1), Letter.A),
            new PositionedLetter(Coordinates.ofYX(2,1), Letter.A)
    ] as Set
  }

  def "position itself left and right if second of two letters"() {
    expect:
    new OrderedLetter(Letter.B, 1).positionedAgainstHighest(new OrderedLetter(Letter.B, 1)) == [
            new PositionedLetter(Coordinates.ofYX(1,0), Letter.B),
            new PositionedLetter(Coordinates.ofYX(1,2), Letter.B)
    ] as Set
  }

  def "position second out of three letters around the centre"() {
    expect:
    new OrderedLetter(Letter.B, 1).positionedAgainstHighest(new OrderedLetter(Letter.C, 2)) == [
            new PositionedLetter(Coordinates.ofYX(1,1), Letter.B),
            new PositionedLetter(Coordinates.ofYX(1,3), Letter.B),
            new PositionedLetter(Coordinates.ofYX(3,1), Letter.B),
            new PositionedLetter(Coordinates.ofYX(3,3), Letter.B)
    ] as Set
  }

  def "form diamond shape"() {
    given:
    def highestLetter = new OrderedLetter(Letter.C, 2)

    expect:
    new OrderedLetter(Letter.A, 0).positionedAgainstHighest(highestLetter) == [
            new PositionedLetter(Coordinates.ofYX(0,2), Letter.A),
            new PositionedLetter(Coordinates.ofYX(4,2), Letter.A)
    ] as Set
    new OrderedLetter(Letter.B, 1).positionedAgainstHighest(highestLetter) == [
            new PositionedLetter(Coordinates.ofYX(1,1), Letter.B),
            new PositionedLetter(Coordinates.ofYX(1,3), Letter.B),
            new PositionedLetter(Coordinates.ofYX(3,1), Letter.B),
            new PositionedLetter(Coordinates.ofYX(3,3), Letter.B)
    ] as Set
    new OrderedLetter(Letter.C, 2).positionedAgainstHighest(highestLetter) == [
            new PositionedLetter(Coordinates.ofYX(2,0), Letter.C),
            new PositionedLetter(Coordinates.ofYX(2,4), Letter.C)
    ] as Set
  }
}
