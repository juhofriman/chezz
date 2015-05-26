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
        ChessBoard.ROW row = location.getRow();
        ChessBoard.COLUMN column = location.getColumn();
        boolean blocks = false;
        while(!blocks) {
            blocks = moveSet.addIfOnBoard(chessBoard.squareAt(row.north(), column.east()));
            row = row.north();
            column = column.east();
        }

        row = location.getRow();
        column = location.getColumn();
        blocks = false;
        while(!blocks) {
            blocks = moveSet.addIfOnBoard(chessBoard.squareAt(row.north(), column.west()));
            row = row.north();
            column = column.west();
        }

        row = location.getRow();
        column = location.getColumn();
        blocks = false;
        while(!blocks) {
            blocks = moveSet.addIfOnBoard(chessBoard.squareAt(row.south(), column.east()));
            row = row.south();
            column = column.east();
        }

        row = location.getRow();
        column = location.getColumn();
        blocks = false;
        while(!blocks) {
            blocks = moveSet.addIfOnBoard(chessBoard.squareAt(row.south(), column.west()));
            row = row.south();
            column = column.west();
        }
    }
}
