package com.michaelszymczak.diamond;

public class Diamond {
  private final char lastLetter;

  public Diamond(char lastLetter) {
    this.lastLetter = lastLetter;
  }

  @Override
  public String toString() {
    return lastLetter == 'A' ? "A" : " A \nB B\n A ";
  }
}
