package fi.monkeyball.chezz.domain;

/**
 * Created by juho on 5/26/15.
 */
public class Knight extends Piece {
    public Knight(Color color) {
        super(color);
    }

    @Override
    protected void registerMovesOfThisPiece(MoveSet moveSet, ChessBoard chessBoard, ChessBoard.Square location) {
        moveSet.addIfOnBoard(chessBoard.squareAt(location.getRow().north().north(), location.getColumn().east()));
        moveSet.addIfOnBoard(chessBoard.squareAt(location.getRow().north().north(), location.getColumn().west()));

        moveSet.addIfOnBoard(chessBoard.squareAt(location.getRow().north(), location.getColumn().east().east()));
        moveSet.addIfOnBoard(chessBoard.squareAt(location.getRow().south(), location.getColumn().east().east()));

        moveSet.addIfOnBoard(chessBoard.squareAt(location.getRow().south().south(), location.getColumn().east()));
        moveSet.addIfOnBoard(chessBoard.squareAt(location.getRow().south().south(), location.getColumn().west()));

        moveSet.addIfOnBoard(chessBoard.squareAt(location.getRow().south(), location.getColumn().east().east()));
        moveSet.addIfOnBoard(chessBoard.squareAt(location.getRow().south(), location.getColumn().west().west()));
        moveSet.addIfOnBoard(chessBoard.squareAt(location.getRow().north(), location.getColumn().west().west()));
    }
}
