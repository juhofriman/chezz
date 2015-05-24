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

        assertFalse(chessBoard.squareAt(ChessBoard.ROW._1, ChessBoard.COLUMN.A).isEmpty());
        assertFalse(chessBoard.squareAt(ChessBoard.ROW._1, ChessBoard.COLUMN.B).isEmpty());
        assertFalse(chessBoard.squareAt(ChessBoard.ROW._1, ChessBoard.COLUMN.C).isEmpty());
        assertFalse(chessBoard.squareAt(ChessBoard.ROW._1, ChessBoard.COLUMN.D).isEmpty());
        assertFalse(chessBoard.squareAt(ChessBoard.ROW._1, ChessBoard.COLUMN.E).isEmpty());
        assertFalse(chessBoard.squareAt(ChessBoard.ROW._1, ChessBoard.COLUMN.F).isEmpty());
        assertFalse(chessBoard.squareAt(ChessBoard.ROW._1, ChessBoard.COLUMN.G).isEmpty());
        assertFalse(chessBoard.squareAt(ChessBoard.ROW._1, ChessBoard.COLUMN.H).isEmpty());

        assertFalse(chessBoard.squareAt(ChessBoard.ROW._2, ChessBoard.COLUMN.A).isEmpty());
        assertFalse(chessBoard.squareAt(ChessBoard.ROW._2, ChessBoard.COLUMN.B).isEmpty());
        assertFalse(chessBoard.squareAt(ChessBoard.ROW._2, ChessBoard.COLUMN.C).isEmpty());
        assertFalse(chessBoard.squareAt(ChessBoard.ROW._2, ChessBoard.COLUMN.D).isEmpty());
        assertFalse(chessBoard.squareAt(ChessBoard.ROW._2, ChessBoard.COLUMN.E).isEmpty());
        assertFalse(chessBoard.squareAt(ChessBoard.ROW._2, ChessBoard.COLUMN.F).isEmpty());
        assertFalse(chessBoard.squareAt(ChessBoard.ROW._2, ChessBoard.COLUMN.G).isEmpty());
        assertFalse(chessBoard.squareAt(ChessBoard.ROW._2, ChessBoard.COLUMN.H).isEmpty());

        assertRowIsEmpty(chessBoard, ChessBoard.ROW._3);
        assertRowIsEmpty(chessBoard, ChessBoard.ROW._4);
        assertRowIsEmpty(chessBoard, ChessBoard.ROW._5);
        assertRowIsEmpty(chessBoard, ChessBoard.ROW._6);

        assertFalse(chessBoard.squareAt(ChessBoard.ROW._8, ChessBoard.COLUMN.A).isEmpty());
        assertFalse(chessBoard.squareAt(ChessBoard.ROW._8, ChessBoard.COLUMN.B).isEmpty());
        assertFalse(chessBoard.squareAt(ChessBoard.ROW._8, ChessBoard.COLUMN.C).isEmpty());
        assertFalse(chessBoard.squareAt(ChessBoard.ROW._8, ChessBoard.COLUMN.D).isEmpty());
        assertFalse(chessBoard.squareAt(ChessBoard.ROW._8, ChessBoard.COLUMN.E).isEmpty());
        assertFalse(chessBoard.squareAt(ChessBoard.ROW._8, ChessBoard.COLUMN.F).isEmpty());
        assertFalse(chessBoard.squareAt(ChessBoard.ROW._8, ChessBoard.COLUMN.G).isEmpty());
        assertFalse(chessBoard.squareAt(ChessBoard.ROW._8, ChessBoard.COLUMN.H).isEmpty());

        assertFalse(chessBoard.squareAt(ChessBoard.ROW._8, ChessBoard.COLUMN.A).isEmpty());
        assertFalse(chessBoard.squareAt(ChessBoard.ROW._8, ChessBoard.COLUMN.B).isEmpty());
        assertFalse(chessBoard.squareAt(ChessBoard.ROW._8, ChessBoard.COLUMN.C).isEmpty());
        assertFalse(chessBoard.squareAt(ChessBoard.ROW._8, ChessBoard.COLUMN.D).isEmpty());
        assertFalse(chessBoard.squareAt(ChessBoard.ROW._8, ChessBoard.COLUMN.E).isEmpty());
        assertFalse(chessBoard.squareAt(ChessBoard.ROW._8, ChessBoard.COLUMN.F).isEmpty());
        assertFalse(chessBoard.squareAt(ChessBoard.ROW._8, ChessBoard.COLUMN.G).isEmpty());
        assertFalse(chessBoard.squareAt(ChessBoard.ROW._8, ChessBoard.COLUMN.H).isEmpty());

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
