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
        ChessBoard.ROW originalRow = location.getRow();
        while(originalRow.north() != null) {
            moveSet.addIfOnBoard(chessBoard.squareAt(originalRow.north(), location.getColumn()));
            originalRow = originalRow.north();
        }
        originalRow = location.getRow();
        while(originalRow.south() != null) {
            moveSet.addIfOnBoard(chessBoard.squareAt(originalRow.south(), location.getColumn()));
            originalRow = originalRow.south();
        }

        ChessBoard.COLUMN originalColumn = location.getColumn();
        while(originalColumn.east() != null) {
            moveSet.addIfOnBoard(chessBoard.squareAt(location.getRow(), originalColumn.east()));
            originalColumn = originalColumn.east();
        }

        originalColumn = location.getColumn();
        while(originalColumn.west() != null) {
            moveSet.addIfOnBoard(chessBoard.squareAt(location.getRow(), originalColumn.west()));
            originalColumn = originalColumn.west();
        }
    }
}
