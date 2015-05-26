package fi.monkeyball.chezz.domain;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by juho on 5/26/15.
 */
public class MoveSetTest {

    @Test
    public void testContains() {
        ChessBoard chessBoard = ChessBoardFactory.emptyBoard();
        chessBoard.placePiece(new Rock(Piece.Color.WHITE), ChessBoard.ROW._1, ChessBoard.COLUMN.A);
        MoveSet squares = new MoveSet(chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._1).getPiece());
        squares.addIfOnBoard(chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._2));

        assertTrue(squares.contains(chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._2)));
    }
}
