package com.chess.piece;

import com.chess.board.Board;
import com.chess.common.Location;
import com.chess.common.Locator;
import com.chess.squares.Square;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Knight extends Piece implements Move{
    public Knight(PieceColor pieceColor){
        super(pieceColor);
        this.name = "Knight";
    }

    @Override
    public List<Location> getValidMoves(Board board) {

        List<Location> possibleMoves = Collections.emptyList();
        Location current = this.getCurrentSquare().getLocation();
        getMoves(possibleMoves,board.getBoardMap(), current, 2, 1);
        getMoves(possibleMoves,board.getBoardMap(), current, 2, -1);
        getMoves(possibleMoves,board.getBoardMap(), current, -2, 1);
        getMoves(possibleMoves,board.getBoardMap(), current, -2, -1);
        getMoves(possibleMoves,board.getBoardMap(), current, 1, 2);
        getMoves(possibleMoves,board.getBoardMap(), current, 1, -2);
        getMoves(possibleMoves,board.getBoardMap(), current, -1, 2);
        getMoves(possibleMoves,board.getBoardMap(), current, -1, -2);
        return possibleMoves;
    }

    private void getMoves(List<Location> possibleMoves, Map<Location, Square> boardMap, Location current, int fileOffset, int rankOffset){
        Location next = Locator.build(current, fileOffset, rankOffset);
        while(boardMap.containsKey(next)){
            if(boardMap.get(next).isOccupied()){
                if(boardMap.get(next).getCurrentPiece().pieceColor.equals(this.pieceColor)){
                    break;
                }
                possibleMoves.add(next);
            }
            possibleMoves.add(next);
            next = Locator.build(next, fileOffset, rankOffset);
        }
    }

    @Override
    public List<Location> getValidMoves(Board board, Square square) {
        return null;
    }

    @Override
    public void makeMove(Square square) {

    }
}
