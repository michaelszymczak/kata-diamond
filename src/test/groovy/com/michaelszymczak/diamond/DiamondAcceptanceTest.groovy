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

  def "should build a complex diamond"() {
    expect:
    diamondWith("Z") == shapeOf("""
                         A                         -
                        B B                        -
                       C   C                       -
                      D     D                      -
                     E       E                     -
                    F         F                    -
                   G           G                   -
                  H             H                  -
                 I               I                 -
                J                 J                -
               K                   K               -
              L                     L              -
             M                       M             -
            N                         N            -
           O                           O           -
          P                             P          -
         Q                               Q         -
        R                                 R        -
       S                                   S       -
      T                                     T      -
     U                                       U     -
    V                                         V    -
   W                                           W   -
  X                                             X  -
 Y                                               Y -
Z                                                 Z-
 Y                                               Y -
  X                                             X  -
   W                                           W   -
    V                                         V    -
     U                                       U     -
      T                                     T      -
       S                                   S       -
        R                                 R        -
         Q                               Q         -
          P                             P          -
           O                           O           -
            N                         N            -
             M                       M             -
              L                     L              -
               K                   K               -
                J                 J                -
                 I               I                 -
                  H             H                  -
                   G           G                   -
                    F         F                    -
                     E       E                     -
                      D     D                      -
                       C   C                       -
                        B B                        -
                         A                         -
""")
  }

  private static String diamondWith(String letter) {
    new Diamond(letter as char).toString()
  }

  private static String shapeOf(String shape) {
    shape.replaceAll("^\n", "").replaceAll("\n\$", "").replaceAll('-', "")
  }
}

