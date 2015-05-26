package fi.monkeyball.chezz.domain;

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
