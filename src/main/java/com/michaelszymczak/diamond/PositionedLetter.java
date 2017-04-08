package com.michaelszymczak.diamond;

public class PositionedLetter {
  private final Coordinates coordinates;
  private final Letter letter;

  public PositionedLetter(Coordinates coordinates, Letter letter) {
    this.coordinates = coordinates;
    this.letter = letter;
  }

  public int maxXorY() {
    return coordinates.maxXorY();
  }

  public String letterAsString() {
    return letter.toString();
  }

  public int getX() {
    return coordinates.getX();
  }

  public int getY() {
    return coordinates.getY();
  }

  @Override
  public String toString() {
    return "PositionedLetter{" +
            "coordinates=" + coordinates +
            ", letter=" + letter +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    PositionedLetter that = (PositionedLetter) o;

    if (coordinates != null ? !coordinates.equals(that.coordinates) : that.coordinates != null) return false;
    return letter != null ? letter.equals(that.letter) : that.letter == null;

  }

  @Override
  public int hashCode() {
    int result = coordinates != null ? coordinates.hashCode() : 0;
    result = 31 * result + (letter != null ? letter.hashCode() : 0);
    return result;
  }
}
