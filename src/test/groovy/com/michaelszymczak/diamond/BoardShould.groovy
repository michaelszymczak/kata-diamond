package com.michaelszymczak.diamond

import spock.lang.Specification

class BoardShould extends Specification {

  def "should print a symbol"() {
    expect: new Board([new Board.Cell(0,0,'Z' as char)]).toString() == "Z"
  }

  def "should print symbols respecting their positions"() {
    expect:
    new Board([
            new Board.Cell(0,0,'A' as char),
            new Board.Cell(0,1,'B' as char),
            new Board.Cell(1,0,'C' as char),
            new Board.Cell(1,1,'D' as char),
    ]).toString() == shapeOf("""
AB
CD
""")
  }

  def "should fill gaps with defined symbol "() {
    expect:
    new Board("_", [
            new Board.Cell(0,2,'A' as char),
            new Board.Cell(1,1,'B' as char),
            new Board.Cell(1,3,'B' as char),
            new Board.Cell(2,0,'C' as char),
            new Board.Cell(2,4,'C' as char),
            new Board.Cell(3,1,'B' as char),
            new Board.Cell(3,3,'B' as char),
            new Board.Cell(4,2,'A' as char),
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
