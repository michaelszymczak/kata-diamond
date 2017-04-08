package com.michaelszymczak.diamond;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class Board {

  private final PositionedLetter[][] board;
  private final Letter emptyCellLetter;

  public Board(Collection<PositionedLetter> cells) {
    this(new Letter(" "), cells);
  }

  public Board(Letter emptyCellLetter, Collection<PositionedLetter> cells) {
    this.emptyCellLetter = emptyCellLetter;
    this.board = boardWith(cells);
  }


  private static PositionedLetter[][] boardWith(Collection<PositionedLetter> cells) {
    int maxCellPosition = cells.stream()
            .mapToInt(PositionedLetter::maxXorY)
            .max()
            .orElse(0);
    PositionedLetter[][] board = new PositionedLetter[maxCellPosition+1][maxCellPosition+1];
    cells.forEach(cell -> board[cell.getY()][cell.getX()] = cell);

    return board;
  }

  @Override
  public String toString() {
    return Arrays.stream(board)
            .map(this::rendered)
            .collect(Collectors.joining("\n"));
  }

  private String rendered(PositionedLetter[] row) {
    return Arrays.stream(row)
            .map(cell -> (cell != null) ? cell.letterAsString() : emptyCellLetter.toString())
            .collect(Collectors.joining());
  }

}
