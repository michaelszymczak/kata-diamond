package com.michaelszymczak.diamond;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.google.common.collect.ImmutableList.copyOf;
import static com.michaelszymczak.diamond.Letter.*;
import static java.util.Arrays.asList;

public class Alphabet {

  private static String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static List<Letter> LETTERS = copyOf(asList(A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z));

  public int positionOf(Letter letter) {
    return letters.indexOf(letter.toString());
  }

  public Letter letterAt(int position) {
    return LETTERS.get(position);
  }

  public List<OrderedLetter> sequenceUpTo(Letter lastLetter) {
    return IntStream.range(0, positionOf(lastLetter) + 1)
            .mapToObj(pos -> new OrderedLetter(letterAt(pos), pos))
            .collect(Collectors.toList());
  }
}
