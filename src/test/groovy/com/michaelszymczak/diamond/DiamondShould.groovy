package com.michaelszymczak.diamond

import spock.lang.Specification

class DiamondShould extends Specification {

  def "contain the provided letter"() {
    expect:
    diamondWith("A") == "A"
  }

  private static String diamondWith(String letter) {
    new Diamond(letter as char).toString()
  }
}
