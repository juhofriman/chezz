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
        ChessBoard.ROW row = location.getRow();
        boolean blocks = false;
        while(!blocks) {
            blocks = moveSet.addIfOnBoard(chessBoard.squareAt(row.north(), location.getColumn()));
            row = row.north();
        }

        row = location.getRow();
        blocks = false;
        while(!blocks) {
            blocks = moveSet.addIfOnBoard(chessBoard.squareAt(row.south(), location.getColumn()));
            row = row.south();
        }

        ChessBoard.COLUMN column = location.getColumn();
        blocks = false;
        while(!blocks) {
            blocks = moveSet.addIfOnBoard(chessBoard.squareAt(location.getRow(), column.east()));
            column = column.east();
        }

        column = location.getColumn();
        blocks = false;
        while(!blocks) {
            blocks = moveSet.addIfOnBoard(chessBoard.squareAt(location.getRow(), column.west()));
            column = column.west();
        }
    }
}
