package com.michaelszymczak.diamond;

public class Letter {

  public static final Letter A = new Letter("A");
  public static final Letter B = new Letter("B");
  public static final Letter C = new Letter("C");
  public static final Letter D = new Letter("D");

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
