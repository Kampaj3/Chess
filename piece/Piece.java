package com.chess.piece;

import com.chess.squares.Square;

public class Piece {
    protected String name;
    protected PieceColor pieceColor;
    protected Square currentSquare;

    public Piece(PieceColor pieceColor){
        this.pieceColor = pieceColor;
    }

    public String getName() {
        return name;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public Square getCurrentSquare() {
        return currentSquare;
    }

    public void setCurrentSquare(Square currentSquare) {
        this.currentSquare = currentSquare;
    }

    @Override
    public String toString() {
        return "Piece{" +
                "name='" + name + '\'' +
                ", pieceColor=" + pieceColor +
                ", currentSquare=" + currentSquare +
                '}';
    }
}
