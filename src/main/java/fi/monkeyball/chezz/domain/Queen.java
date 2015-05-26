package fi.monkeyball.chezz.domain;

/**
 * Created by juho on 5/26/15.
 */
public class Queen extends Piece {

    public Queen(Color color) {
        super(color);
    }

    @Override
    protected void registerMovesOfThisPiece(MoveSet moveSet, ChessBoard chessBoard, ChessBoard.Square location) {
        registerBishopMoves(moveSet, chessBoard, location);
        registerRookMoves(moveSet, chessBoard, location);
    }
}
