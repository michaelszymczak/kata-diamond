package com.michaelszymczak.diamond

import spock.lang.Specification

class DiamondAcceptanceTest extends Specification {

  def "should contain the provided letter"() {
    expect:
    diamondWith("A") == shapeOf("A")
  }

  def "should build a diamond shape containing the preceding and the provided letter"() {
    expect:
    diamondWith("B") == shapeOf("""
 A -
B B-
 A -
""")
  }

  private static String diamondWith(String letter) {
    new Diamond(letter as char).toString()
  }

  private static String shapeOf(String shape) {
    shape.replaceAll("^\n", "").replaceAll("\n\$", "").replaceAll('-', "")
  }

//  def A = """
//A
//"""
//  def B = """
// A
//B B
// A
//"""
//
//  def C = """
//  A
// B B
//C   C
// B B
//  A
//"""
//  def D = """
//   A
//  B B
// C   C
//D     D
// C   C
//  B B
//   A
//"""
}

