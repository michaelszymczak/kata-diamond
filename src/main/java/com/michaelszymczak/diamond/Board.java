package com.michaelszymczak.diamond;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class Board {

  private final Cell[][] board;
  private final String emptyCellSymbol;

  public Board(Collection<Cell> cells) {
    this(" ", cells);
  }

  public Board(String emptyCellSymbol, Collection<Cell> cells) {
    this.emptyCellSymbol = emptyCellSymbol;
    board = boardWith(cells);
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
            .map(cell -> (cell != null) ? cell.symbol() : emptyCellSymbol)
            .collect(Collectors.joining());
  }

  public static class Cell
  {
    private final int x;
    private final int y;
    private final char symbol;

    public Cell(int y, int x, char symbol) {
      this.x = x;
      this.y = y;
      this.symbol = symbol;
    }

    public int maxXorY()
    {
      return x > y ? x : y;
    }

    public String symbol()
    {
      return String.valueOf(symbol);
    }
  }
}
