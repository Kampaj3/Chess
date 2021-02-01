package com.chess.piece;

import com.chess.board.Board;
import com.chess.common.Location;
import com.chess.common.Locator;
import com.chess.squares.Square;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Rook extends Piece implements Move{
    public Rook(PieceColor pieceColor){
        super(pieceColor);
        this.name = "Rook";
    }

    @Override
    public List<Location> getValidMoves(Board board) {
        List<Location> possibleMoves = Collections.emptyList();
        Location current = this.getCurrentSquare().getLocation();
        getFileCandidates(possibleMoves, board.getBoardMap(), current, -1);
        getFileCandidates(possibleMoves, board.getBoardMap(), current, 1);
        getRankCandidates(possibleMoves, board.getBoardMap(), current, 1);
        getRankCandidates(possibleMoves, board.getBoardMap(), current, -1);
        return possibleMoves;
    }

    private void getRankCandidates(List<Location> possibleMoves, Map<Location, Square> boardMap, Location current, int offset){
        Location next = Locator.build(current, current.getFile().ordinal(), offset);
        while(boardMap.containsKey(next)){
            if(boardMap.get(next).isOccupied()){
                if(boardMap.get(next).getCurrentPiece().pieceColor.equals(this.pieceColor)){
                    break;
                }
                possibleMoves.add(next);
                break;
            }
            possibleMoves.add(next);
            next = Locator.build(next, next.getFile().ordinal(), offset);
        }
    }

    private void getFileCandidates(List<Location> possibleMoves, Map<Location, Square> boardMap, Location current, int offset){
        Location next = Locator.build(current, offset, 0);
        while(boardMap.containsKey(next)){
            if(boardMap.get(next).isOccupied()){
                if(boardMap.get(next).getCurrentPiece().pieceColor.equals(this.pieceColor)){
                    break;
                }
                possibleMoves.add(next);
                break;
            }
            possibleMoves.add(next);
            next = Locator.build(next, offset, 0);
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