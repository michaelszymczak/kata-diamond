package com.michaelszymczak.diamond;

public class Coordinates {

  private final int y;
  private final int x;

  public static Coordinates ofYX(int y, int x)
  {
    return new Coordinates(y, x);
  }

  private Coordinates(int y, int x) {
    this.y = y;
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public int getX() {
    return x;
  }

  public int maxXorY() {
    return x > y ? x : y;
  }

  @Override
  public String toString() {
    return "Coordinates{" +
            "y=" + y +
            ", x=" + x +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Coordinates that = (Coordinates) o;

    if (y != that.y) return false;
    return x == that.x;

  }

  @Override
  public int hashCode() {
    int result = y;
    result = 31 * result + x;
    return result;
  }
}
