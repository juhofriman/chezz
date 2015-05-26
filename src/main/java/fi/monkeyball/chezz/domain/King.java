package fi.monkeyball.chezz.domain;

/**
 * Created by juho on 5/24/15.
 */
public class King extends Piece {

    public King(Color color) {
        super(color);
    }

    @Override
    protected void registerMovesOfThisPiece(MoveSet moveSet, ChessBoard chessBoard, ChessBoard.Square location) {
        moveSet.addIfOnBoard(chessBoard.squareAt(location.getRow(), location.getColumn().east()));
        moveSet.addIfOnBoard(chessBoard.squareAt(location.getRow(), location.getColumn().west()));
        moveSet.addIfOnBoard(chessBoard.squareAt(location.getRow().north(), location.getColumn()));
        moveSet.addIfOnBoard(chessBoard.squareAt(location.getRow().north(), location.getColumn().east()));
        moveSet.addIfOnBoard(chessBoard.squareAt(location.getRow().north(), location.getColumn().west()));
        moveSet.addIfOnBoard(chessBoard.squareAt(location.getRow().east(), location.getColumn()));
        moveSet.addIfOnBoard(chessBoard.squareAt(location.getRow().east(), location.getColumn().east()));
        moveSet.addIfOnBoard(chessBoard.squareAt(location.getRow().east(), location.getColumn().west()));

    }

}
