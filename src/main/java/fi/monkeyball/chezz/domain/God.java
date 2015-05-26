package fi.monkeyball.chezz.domain;

/**
 * Created by juho on 5/24/15.
 */
public class God extends Piece {

    public God(Color color) {
        super(color);
    }

    @Override
    protected void registerMovesOfThisPiece(MoveSet moveSet, ChessBoard chessBoard, ChessBoard.Square location) {
        for (ChessBoard.RowContainer rowContainer : chessBoard) {
            for (ChessBoard.Square square : rowContainer) {
                if(square != location) {
                    moveSet.addIfOnBoard(square);
                }
            }
        }
    }
}
