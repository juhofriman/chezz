package fi.monkeyball.chezz.domain;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by juho on 5/24/15.
 */
public class ChessBoardTest {

    @Test
    public void chessBoardCanBeIteratedAndSizeIs8x8() {
        ChessBoard chessBoard = new ChessBoard();
        int rows = 0;
        int squares = 0;
        for(ChessBoard.Row row : chessBoard) {
            rows++;
            int columns = 0;
            for(ChessBoard.Square square : row) {
                columns++;
                squares++;
            }
            assertEquals("This chessboard is broken. It does not have correct count of squares at row: " + (rows),
                    8, columns);
        }
        assertEquals("This chessboard is broken. It does not have correct value of rows.", 8, rows);
        assertEquals("Wut? DId not count correct total count of squares", 64, squares);
    }

    @Test
    public void whenBuiltCanBeEmpty() {
        ChessBoard chessBoard = new ChessBoard();
        for(ChessBoard.Row row : chessBoard) {
            for(ChessBoard.Square square : row) {
                assertTrue(square.isEmpty());
            }
        }
    }

    @Test
    public void butLuckilyWeHaveFactoryForInitialStateOfChessGame() {
        ChessBoard chessBoard = ChessBoardFactory.initialState();

        // TODO: this test should be in ChessBoardFactoryTest

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
