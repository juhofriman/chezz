package fi.monkeyball.chezz.domain;

import fi.monkeyball.chezz.domain.pieces.*;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by juho on 5/24/15.
 */
public class ChessBoardFactoryTest {

    @Test
    public void testEmptyGame() {
        ChessBoard chessBoard = ChessBoardFactory.emptyBoard();

        assertRowIsEmpty(chessBoard, ChessBoard.ROW._1);
        assertRowIsEmpty(chessBoard, ChessBoard.ROW._2);
        assertRowIsEmpty(chessBoard, ChessBoard.ROW._3);
        assertRowIsEmpty(chessBoard, ChessBoard.ROW._4);
        assertRowIsEmpty(chessBoard, ChessBoard.ROW._5);
        assertRowIsEmpty(chessBoard, ChessBoard.ROW._6);
        assertRowIsEmpty(chessBoard, ChessBoard.ROW._7);
        assertRowIsEmpty(chessBoard, ChessBoard.ROW._8);
    }

    @Test
    public void testGameStart() {
        ChessBoard chessBoard = ChessBoardFactory.gameStart();

        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._1, ChessBoard.COLUMN.A, Piece.Color.WHITE, Rook.class);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._1, ChessBoard.COLUMN.B, Piece.Color.WHITE, Knight.class);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._1, ChessBoard.COLUMN.C, Piece.Color.WHITE, Bishop.class);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._1, ChessBoard.COLUMN.D, Piece.Color.WHITE, King.class);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._1, ChessBoard.COLUMN.E, Piece.Color.WHITE, Queen.class);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._1, ChessBoard.COLUMN.F, Piece.Color.WHITE, Bishop.class);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._1, ChessBoard.COLUMN.G, Piece.Color.WHITE, Knight.class);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._1, ChessBoard.COLUMN.H, Piece.Color.WHITE, Rook.class);

        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._2, ChessBoard.COLUMN.A, Piece.Color.WHITE, Pawn.class);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._2, ChessBoard.COLUMN.B, Piece.Color.WHITE, Pawn.class);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._2, ChessBoard.COLUMN.C, Piece.Color.WHITE, Pawn.class);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._2, ChessBoard.COLUMN.D, Piece.Color.WHITE, Pawn.class);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._2, ChessBoard.COLUMN.E, Piece.Color.WHITE, Pawn.class);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._2, ChessBoard.COLUMN.F, Piece.Color.WHITE, Pawn.class);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._2, ChessBoard.COLUMN.G, Piece.Color.WHITE, Pawn.class);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._2, ChessBoard.COLUMN.H, Piece.Color.WHITE, Pawn.class);


        assertRowIsEmpty(chessBoard, ChessBoard.ROW._3);
        assertRowIsEmpty(chessBoard, ChessBoard.ROW._4);
        assertRowIsEmpty(chessBoard, ChessBoard.ROW._5);
        assertRowIsEmpty(chessBoard, ChessBoard.ROW._6);

        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._7, ChessBoard.COLUMN.A, Piece.Color.BLACK, Pawn.class);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._7, ChessBoard.COLUMN.B, Piece.Color.BLACK, Pawn.class);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._7, ChessBoard.COLUMN.C, Piece.Color.BLACK, Pawn.class);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._7, ChessBoard.COLUMN.D, Piece.Color.BLACK, Pawn.class);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._7, ChessBoard.COLUMN.E, Piece.Color.BLACK, Pawn.class);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._7, ChessBoard.COLUMN.F, Piece.Color.BLACK, Pawn.class);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._7, ChessBoard.COLUMN.G, Piece.Color.BLACK, Pawn.class);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._7, ChessBoard.COLUMN.H, Piece.Color.BLACK, Pawn.class);


        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._8, ChessBoard.COLUMN.A, Piece.Color.BLACK, Rook.class);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._8, ChessBoard.COLUMN.B, Piece.Color.BLACK, Knight.class);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._8, ChessBoard.COLUMN.C, Piece.Color.BLACK, Bishop.class);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._8, ChessBoard.COLUMN.D, Piece.Color.BLACK, King.class);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._8, ChessBoard.COLUMN.E, Piece.Color.BLACK, Queen.class);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._8, ChessBoard.COLUMN.F, Piece.Color.BLACK, Bishop.class);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._8, ChessBoard.COLUMN.G, Piece.Color.BLACK, Knight.class);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._8, ChessBoard.COLUMN.H, Piece.Color.BLACK, Rook.class);

    }

    private void assertNotEmptyAndIsCorrectColor(ChessBoard chessBoard, ChessBoard.ROW row, ChessBoard.COLUMN column, Piece.Color color, Class<? extends Piece> pieceClass) {
        assertEquals(color, chessBoard.squareAt(row, column).getPiece().getColor());
        assertEquals("Unexpected piece at " + column + " " + row, pieceClass, chessBoard.squareAt(row, column).getPiece().getClass());
    }

    private void assertRowIsEmpty(ChessBoard chessBoard, ChessBoard.ROW row) {
        assertTrue(chessBoard.squareAt(row, ChessBoard.COLUMN.A).isEmpty());
        assertTrue(chessBoard.squareAt(row, ChessBoard.COLUMN.B).isEmpty());
        assertTrue(chessBoard.squareAt(row, ChessBoard.COLUMN.C).isEmpty());
        assertTrue(chessBoard.squareAt(row, ChessBoard.COLUMN.D).isEmpty());
        assertTrue(chessBoard.squareAt(row, ChessBoard.COLUMN.E).isEmpty());
        assertTrue(chessBoard.squareAt(row, ChessBoard.COLUMN.F).isEmpty());
        assertTrue(chessBoard.squareAt(row, ChessBoard.COLUMN.G).isEmpty());
        assertTrue(chessBoard.squareAt(row, ChessBoard.COLUMN.H).isEmpty());
    }


}
