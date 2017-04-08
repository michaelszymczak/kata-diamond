package com.michaelszymczak.diamond

import spock.lang.Specification

class DiamondShould extends Specification {

  def "contain the provided letter"() {
    expect:
    diamondWith("A") == shapeOf("A")
  }

  def "build a diamond shape containing the preceding and the provided letter"() {
    expect:
    diamondWith("B") == shapeOf("""
 A
B B
 A
""")
  }

  private static String diamondWith(String letter) {
    new Diamond(letter as char).toString()
  }

  private static String shapeOf(String shape) {
    shape.replaceAll("^\n", "").replaceAll("\n\$", "")
  }
}
