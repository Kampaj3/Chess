package com.chess.board;

import java.util.HashMap;
import java.util.Map;

import com.chess.common.File;
import com.chess.common.Location;
import com.chess.piece.Piece;
import com.chess.piece.PieceMaker;
import com.chess.squares.Square;
import com.chess.squares.SquareColor;

public class Board {

    private static final Integer BOARD_LENGTH = 8;
    private final Map<Location, Square> boardMap;

    Square[][] boardSquares = new Square[BOARD_LENGTH][BOARD_LENGTH];



    public Board() {
        boardMap = new HashMap<>();
        Map<Location, Piece> pieces = PieceMaker.getPieces();
        for(int i = 0; i < boardSquares.length; i++) {
            int column = 0;
            SquareColor currentColor = (i % 2 == 0) ? SquareColor.LIGHT : SquareColor.DARK;
            for(File file : File.values()) {
                Square newSquare = new Square(currentColor, new Location(file,  BOARD_LENGTH - i));
                if (pieces.containsKey(newSquare.getLocation())) {
                    Piece piece = pieces.get(newSquare.getLocation());
                    newSquare.setCurrentPiece(piece);
                    newSquare.setOccupied(true);
                    piece.setCurrentSquare(newSquare);
                }
                boardSquares[i][column] = newSquare;
                boardMap.put(newSquare.getLocation(), newSquare);
                currentColor = (currentColor == SquareColor.DARK) ? SquareColor.LIGHT : SquareColor.DARK;
                column++;
            }
        }
    }

    public Map<Location, Square> getBoardMap() {
        return boardMap;
    }


    public void printBoard() {
        for(int i = 0; i < boardSquares.length; i++) {
            System.out.print(BOARD_LENGTH - i + " ");
            for(int j = 0; j < boardSquares[i].length; j++) {
                if (boardSquares[i][j].isOccupied()) {
                    Piece piece = boardSquares[i][j].getCurrentPiece();
                    System.out.print(piece.getName().charAt(0) + " ");
                } else {
                    // empty square
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
        System.out.print("  ");
        for(File file : File.values()) {
            System.out.print(file.name() + " ");
        }
        System.out.println();
    }

}
