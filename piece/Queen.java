package com.chess.piece;

import com.chess.board.Board;
import com.chess.common.Location;
import com.chess.squares.Square;

import java.util.Collections;
import java.util.List;

public class Queen extends Piece implements Move{

    private Move bishop;
    private Move rook;

    public Queen(PieceColor pieceColor){
        super(pieceColor);
        this.name = "Queen";
    }

    public Queen(PieceColor pieceColor, Move bishop, Move rook){
        super(pieceColor);
        this.bishop = bishop;
        this.rook = rook;
    }

    @Override
    public List<Location> getValidMoves(Board board) {
        List<Location> possibleMoves = Collections.emptyList();
        possibleMoves.addAll(bishop.getValidMoves(board, this.getCurrentSquare()));
        possibleMoves.addAll(rook.getValidMoves(board, this.getCurrentSquare()));
        return possibleMoves;
    }

    @Override
    public List<Location> getValidMoves(Board board, Square square) {
        return null;
    }

    @Override
    public void makeMove(Square square) {
        Square current = this.getCurrentSquare();
        this.setCurrentSquare(square);
        current.reset();
    }
}