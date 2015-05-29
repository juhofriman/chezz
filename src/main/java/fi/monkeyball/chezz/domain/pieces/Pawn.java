package fi.monkeyball.chezz.domain.pieces;

import fi.monkeyball.chezz.domain.ChessBoard;

/**
 * Created by juho on 5/25/15.
 */
public class Pawn extends Piece {

    public Pawn(Color color) {
        super(color);
    }

    @Override
    protected void registerMovesOfThisPiece(MoveSet moveSet, ChessBoard chessBoard, ChessBoard.Square location) {
        if(this.getColor().equals(Color.WHITE)) {
            // Pawn can move forward if square is empty
            if(chessBoard.squareAt(location.getRow().north(), location.getColumn()).isEmpty()) {
                moveSet.addIfOnBoard(chessBoard.squareAt(location.getRow().north(), location.getColumn()));
            }
            // If it's on starting location it can move two squares if no obstacles
            if (this.atStartingLocation(location) && chessBoard.squareAt(location.getRow().north(), location.getColumn()).isEmpty()) {
                moveSet.addIfOnBoard(chessBoard.squareAt(location.getRow().north().north(), location.getColumn()));
            }
            // Pawn can capture to north-east
            if(atTableAndContainsEnemy(chessBoard.squareAt(location.getRow().north(), location.getColumn().east()))) {
                moveSet.addIfOnBoard(chessBoard.squareAt(location.getRow().north(), location.getColumn().east()));
            }
            // Pawn can capture to north-west
            if(atTableAndContainsEnemy(chessBoard.squareAt(location.getRow().north(), location.getColumn().west()))) {
                moveSet.addIfOnBoard(chessBoard.squareAt(location.getRow().north(), location.getColumn().west()));
            }
        } else {
            // Pawn can move forward if square is empty
            if(chessBoard.squareAt(location.getRow().south(), location.getColumn()).isEmpty()) {
                moveSet.addIfOnBoard(chessBoard.squareAt(location.getRow().south(), location.getColumn()));
            }
            // If it's on starting location it can move two squares if no obstacles
            if (this.atStartingLocation(location) && chessBoard.squareAt(location.getRow().south(), location.getColumn()).isEmpty()) {
                moveSet.addIfOnBoard(chessBoard.squareAt(location.getRow().south().south(), location.getColumn()));
            }
            // Pawn can capture to south-east
            if(atTableAndContainsEnemy(chessBoard.squareAt(location.getRow().south(), location.getColumn().east()))) {
                moveSet.addIfOnBoard(chessBoard.squareAt(location.getRow().south(), location.getColumn().east()));
            }
            // Pawn can capture to south-west
            if(atTableAndContainsEnemy(chessBoard.squareAt(location.getRow().south(), location.getColumn().west()))) {
                moveSet.addIfOnBoard(chessBoard.squareAt(location.getRow().south(), location.getColumn().west()));
            }
        }
    }

    private boolean atTableAndContainsEnemy(ChessBoard.Square square) {
        if(square == null || square.isEmpty()) {
            return false;
        }
        return !square.getPiece().getColor().equals(this.getColor());
    }

    private boolean atStartingLocation(ChessBoard.Square location) {
        // TODO: we need "service" for retrieving moves? It could be mocked at tests.
        return getColor().equals(Color.WHITE) ?
                location.getRow().equals(ChessBoard.ROW._2) :
                location.getRow().equals(ChessBoard.ROW._7);
    }
}
