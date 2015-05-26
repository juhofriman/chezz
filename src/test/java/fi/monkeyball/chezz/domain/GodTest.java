package fi.monkeyball.chezz.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by juho on 5/24/15.
 */
public class GodTest {

    @Test
    public void testGodMoves() {
        ChessBoard chessBoard = ChessBoardFactory.emptyBoard();
        chessBoard.placePiece(new God(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._1, ChessBoard.COLUMN.F));
        assertFalse("God can move ANYTIME", chessBoard.moveSet(chessBoard.squareAt(ChessBoard.ROW._1, ChessBoard.COLUMN.F)).isEmpty());
        assertEquals("God can move ANYWHERE", 63, chessBoard.moveSet(chessBoard.squareAt(ChessBoard.ROW._1, ChessBoard.COLUMN.F)).size());
    }

    @Test
    public void testGodWhenOnlyFriendlyOnBoard() {
        ChessBoard chessBoard = ChessBoardFactory.emptyBoard();
        chessBoard.placePiece(new God(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._1, ChessBoard.COLUMN.F));
        chessBoard.placePiece(new God(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._4, ChessBoard.COLUMN.F));

        assertEquals("God can move ANYWHERE BUT IS SO SUBLIME DOES NOT CAPTURE IT'S OWN",
                62, chessBoard.moveSet(chessBoard.squareAt(ChessBoard.ROW._1, ChessBoard.COLUMN.F)).size());
    }

    @Test
    public void testGodWhenOnlyEnemyOnBoard() {
        ChessBoard chessBoard = ChessBoardFactory.emptyBoard();
        chessBoard.placePiece(new God(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._1, ChessBoard.COLUMN.F));
        chessBoard.placePiece(new God(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.ROW._4, ChessBoard.COLUMN.F));

        assertEquals("God can move ANYWHERE AND CAPTURES ENEMIES UNMERCIFULLY",
                63, chessBoard.moveSet(chessBoard.squareAt(ChessBoard.ROW._1, ChessBoard.COLUMN.F)).size());
    }
}
