package com.chess.piece;

import com.chess.board.Board;
import com.chess.common.Location;
import com.chess.squares.Square;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class King extends Piece implements Move{

    private Move bishop;
    private Move rook;

    public King(PieceColor pieceColor){
        super(pieceColor);
        this.name = "King";
    }

    public King(PieceColor pieceColor, Move bishop, Move rook){
        super(pieceColor);
        this.bishop = bishop;
        this.rook = rook;
    }


    @Override
    public List<Location> getValidMoves(Board board) {
        List<Location> possibleMoves = Collections.emptyList();
        Location current = this.getCurrentSquare().getLocation();
        possibleMoves.addAll(bishop.getValidMoves(board, this.getCurrentSquare()));
        possibleMoves.addAll(rook.getValidMoves(board, this.getCurrentSquare()));
        return possibleMoves.stream().filter(candidate -> (
                Math.abs(candidate.getFile().ordinal() - current.getFile().ordinal()) == 1 &&
                        Math.abs(candidate.getRank() - current.getRank()) == 1))
                .collect(Collectors.toList());
    }

    @Override
    public List<Location> getValidMoves(Board board, Square square) {
        return null;
    }

    @Override
    public void makeMove(Square square) {

    }
}
