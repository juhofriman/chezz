package fi.monkeyball.chezz.domain.pieces;

import fi.monkeyball.chezz.domain.ChessBoard;

/**
 * Created by juho on 5/26/15.
 */
public class Bishop extends Piece {

    public Bishop(Color color) {
        super(color);
    }

    @Override
    protected void registerMovesOfThisPiece(MoveSet moveSet, ChessBoard chessBoard, ChessBoard.Square location) {
        registerBishopMoves(moveSet, chessBoard, location);
    }

}
