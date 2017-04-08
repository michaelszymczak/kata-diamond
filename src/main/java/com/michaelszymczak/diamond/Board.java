package com.michaelszymczak.diamond;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class Board {

  private final Cell[][] board;
  private final Letter emptyCellLetter;

  public Board(Collection<Cell> cells) {
    this(new Letter(" "), cells);
  }

  public Board(Letter emptyCellLetter, Collection<Cell> cells) {
    this.emptyCellLetter = emptyCellLetter;
    this.board = boardWith(cells);
  }


  private static Cell[][] boardWith(Collection<Cell> cells) {
    int maxCellPosition = cells.stream()
            .mapToInt(Cell::maxXorY)
            .max()
            .orElse(0);
    Cell[][] board = new Cell[maxCellPosition+1][maxCellPosition+1];
    cells.forEach(cell -> board[cell.y][cell.x] = cell);

    return board;
  }

  @Override
  public String toString() {
    return Arrays.stream(board)
            .map(this::rendered)
            .collect(Collectors.joining("\n"));
  }

  private String rendered(Cell[] row) {
    return Arrays.stream(row)
            .map(cell -> (cell != null) ? cell.letterAsString() : emptyCellLetter.toString())
            .collect(Collectors.joining());
  }

  public static class Cell
  {
    private final int x;
    private final int y;
    private final Letter letter;

    public Cell(int y, int x, Letter letter) {
      this.x = x;
      this.y = y;
      this.letter = letter;
    }

    public int maxXorY()
    {
      return x > y ? x : y;
    }

    public String letterAsString()
    {
      return letter.toString();
    }
  }
}
