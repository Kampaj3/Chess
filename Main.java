package com.chess.runner;

import com.chess.board.Board;
import com.chess.piece.*;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.printBoard();

        PieceColor color = PieceColor.DARK;
        Pawn pawn = new Pawn(color);
        Move queen = new Queen(color);
        printPiece(pawn);
        printPiece(queen);

    }

    public static void printPiece(Move piece){
        System.out.println(piece.toString());
        //piece.getValidMoves(null);
    }
}
