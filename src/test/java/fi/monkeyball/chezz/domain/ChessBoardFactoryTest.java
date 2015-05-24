package fi.monkeyball.chezz.domain;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
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

        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._1, ChessBoard.COLUMN.A, Piece.Color.WHITE);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._1, ChessBoard.COLUMN.B, Piece.Color.WHITE);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._1, ChessBoard.COLUMN.C, Piece.Color.WHITE);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._1, ChessBoard.COLUMN.D, Piece.Color.WHITE);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._1, ChessBoard.COLUMN.E, Piece.Color.WHITE);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._1, ChessBoard.COLUMN.F, Piece.Color.WHITE);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._1, ChessBoard.COLUMN.G, Piece.Color.WHITE);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._1, ChessBoard.COLUMN.H, Piece.Color.WHITE);

        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._1, ChessBoard.COLUMN.H, Piece.Color.WHITE);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._2, ChessBoard.COLUMN.A, Piece.Color.WHITE);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._3, ChessBoard.COLUMN.B, Piece.Color.WHITE);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._4, ChessBoard.COLUMN.C, Piece.Color.WHITE);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._5, ChessBoard.COLUMN.D, Piece.Color.WHITE);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._6, ChessBoard.COLUMN.E, Piece.Color.WHITE);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._7, ChessBoard.COLUMN.F, Piece.Color.WHITE);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._8, ChessBoard.COLUMN.G, Piece.Color.WHITE);


        assertRowIsEmpty(chessBoard, ChessBoard.ROW._3);
        assertRowIsEmpty(chessBoard, ChessBoard.ROW._4);
        assertRowIsEmpty(chessBoard, ChessBoard.ROW._5);
        assertRowIsEmpty(chessBoard, ChessBoard.ROW._6);

        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._1, ChessBoard.COLUMN.A, Piece.Color.BLACK);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._1, ChessBoard.COLUMN.B, Piece.Color.BLACK);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._1, ChessBoard.COLUMN.C, Piece.Color.BLACK);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._1, ChessBoard.COLUMN.D, Piece.Color.BLACK);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._1, ChessBoard.COLUMN.E, Piece.Color.BLACK);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._1, ChessBoard.COLUMN.F, Piece.Color.BLACK);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._1, ChessBoard.COLUMN.G, Piece.Color.BLACK);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._1, ChessBoard.COLUMN.H, Piece.Color.BLACK);

        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._1, ChessBoard.COLUMN.H, Piece.Color.BLACK);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._2, ChessBoard.COLUMN.A, Piece.Color.BLACK);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._3, ChessBoard.COLUMN.B, Piece.Color.BLACK);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._4, ChessBoard.COLUMN.C, Piece.Color.BLACK);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._5, ChessBoard.COLUMN.D, Piece.Color.BLACK);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._6, ChessBoard.COLUMN.E, Piece.Color.BLACK);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._7, ChessBoard.COLUMN.F, Piece.Color.BLACK);
        assertNotEmptyAndIsCorrectColor(chessBoard, ChessBoard.ROW._8, ChessBoard.COLUMN.G, Piece.Color.BLACK);

    }

    private void assertNotEmptyAndIsCorrectColor(ChessBoard chessBoard, ChessBoard.ROW row, ChessBoard.COLUMN a, Piece.Color white) {

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
