package com.chess.piece;

import com.chess.board.Board;
import com.chess.common.Location;
import com.chess.common.Locator;
import com.chess.squares.Square;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Pawn extends Piece implements Move{

    private boolean isFirstMove = true;

    public Pawn(PieceColor pieceColor){
        super(pieceColor);
        this.name = "Pawn";
    }

    @Override
    public List<Location> getValidMoves(Board board) {
        List<Location> possibleMoves = Collections.emptyList();
        Location current = this.getCurrentSquare().getLocation();

        possibleMoves.add(Locator.build(current, 0, 1));
        if(isFirstMove) {
            possibleMoves.add(Locator.build(current, 0, 2));
            return possibleMoves;
        }

        possibleMoves.add(Locator.build(current, 1, 1));
        possibleMoves.add(Locator.build(current, -1, 1));
        List<Location> validMoves = possibleMoves.stream().filter((candidate) -> (board.getBoardMap().containsKey(candidate))).collect(Collectors.toList());

        return validMoves.stream().filter((candidate) -> {
            if(candidate.getFile().equals(this.getCurrentSquare().getLocation().getFile()) && board.getBoardMap().get(candidate).isOccupied()) {
                return false;
            }
            return board.getBoardMap().get(candidate).getCurrentPiece().pieceColor.equals(this.getPieceColor());
        }).collect(Collectors.toList());
    }

    @Override
    public List<Location> getValidMoves(Board board, Square square) {
        return null;
    }

    @Override
    public void makeMove(Square square) {

    }
}