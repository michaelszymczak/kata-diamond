package com.michaelszymczak.diamond

import spock.lang.Specification

class BoardShould extends Specification {

  def "should print a symbol"() {
    expect: new Board([new Board.Cell(0,0,Letter.B)]).toString() == "B"
  }

  def "should print symbols respecting their positions"() {
    expect:
    new Board([
            new Board.Cell(0,0,Letter.A),
            new Board.Cell(0,1,Letter.B),
            new Board.Cell(1,0,Letter.C),
            new Board.Cell(1,1,Letter.D),
    ]).toString() == shapeOf("""
AB
CD
""")
  }

  def "should fill gaps with defined symbol "() {
    expect:
    new Board(new Letter("_"), [
            new Board.Cell(0,2,Letter.A),
            new Board.Cell(1,1,Letter.B),
            new Board.Cell(1,3,Letter.B),
            new Board.Cell(2,0,Letter.C),
            new Board.Cell(2,4,Letter.C),
            new Board.Cell(3,1,Letter.B),
            new Board.Cell(3,3,Letter.B),
            new Board.Cell(4,2,Letter.A),
    ]).toString() == shapeOf("""
__A__
_B_B_
C___C
_B_B_
__A__
""")
  }
  private static String shapeOf(String shape) {
    shape.replaceAll("^\n", "").replaceAll("\n\$", "")
  }
}
