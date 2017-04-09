package com.michaelszymczak.diamond;

public class Letter {

  public static final Letter A = new Letter("A");
  public static final Letter B = new Letter("B");
  public static final Letter C = new Letter("C");
  public static final Letter D = new Letter("D");
  public static final Letter E = new Letter("E");
  public static final Letter F = new Letter("F");
  public static final Letter G = new Letter("G");
  public static final Letter H = new Letter("H");
  public static final Letter I = new Letter("I");
  public static final Letter J = new Letter("J");
  public static final Letter K = new Letter("K");
  public static final Letter L = new Letter("L");
  public static final Letter M = new Letter("M");
  public static final Letter N = new Letter("N");
  public static final Letter O = new Letter("O");
  public static final Letter P = new Letter("P");
  public static final Letter Q = new Letter("Q");
  public static final Letter R = new Letter("R");
  public static final Letter S = new Letter("S");
  public static final Letter T = new Letter("T");
  public static final Letter U = new Letter("U");
  public static final Letter V = new Letter("V");
  public static final Letter W = new Letter("W");
  public static final Letter X = new Letter("X");
  public static final Letter Y = new Letter("Y");
  public static final Letter Z = new Letter("Z");

  private final String value;

  public Letter(char value) {
    this(String.valueOf(value));
  }

  public Letter(String value) {
    assert value.length() == 1;
    this.value = value;
  }



  @Override
  public String toString() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Letter letter = (Letter) o;

    return value != null ? value.equals(letter.value) : letter.value == null;

  }

  @Override
  public int hashCode() {
    return value != null ? value.hashCode() : 0;
  }
}
