package fi.monkeyball.chezz.domain;

/**
 * Created by juho on 26/05/15.
 */
public class Rook extends Piece {
    public Rook(Color color) {
        super(color);
    }

    @Override
    protected void registerMovesOfThisPiece(MoveSet moveSet, ChessBoard chessBoard, ChessBoard.Square location) {
        registerRookMoves(moveSet, chessBoard, location);
    }

}
