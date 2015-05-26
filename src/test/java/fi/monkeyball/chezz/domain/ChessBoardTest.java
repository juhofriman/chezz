package fi.monkeyball.chezz.domain;

import org.junit.Test;

import java.util.Iterator;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by juho on 5/24/15.
 */
public class ChessBoardTest {

    @Test
    public void chessBoardCanBeIteratedAndSizeIs8x8() {
        ChessBoard chessBoard = ChessBoardFactory.emptyBoard();
        int rows = 0;
        int squares = 0;
        for(ChessBoard.RowContainer rowContainer : chessBoard) {
            rows++;
            int columns = 0;
            for(ChessBoard.Square square : rowContainer) {
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
    public void useChessBoardFactoryForInitialChessBoards() {
        ChessBoard chessBoard = ChessBoardFactory.emptyBoard();
        for(ChessBoard.RowContainer rowContainer : chessBoard) {
            for(ChessBoard.Square square : rowContainer) {
                assertTrue(square.isEmpty());
            }
        }
    }

    @Test
    public void coordinatesAreAsExpectedInChessBoard() {
        ChessBoard chessBoard = ChessBoardFactory.emptyBoard();
        Iterator<ChessBoard.RowContainer> iterator = chessBoard.iterator();
        checkRowIsAsExpected(iterator.next(), ChessBoard.ROW._1);
        checkRowIsAsExpected(iterator.next(), ChessBoard.ROW._2);
        checkRowIsAsExpected(iterator.next(), ChessBoard.ROW._3);
        checkRowIsAsExpected(iterator.next(), ChessBoard.ROW._4);
        checkRowIsAsExpected(iterator.next(), ChessBoard.ROW._5);
        checkRowIsAsExpected(iterator.next(), ChessBoard.ROW._6);
        checkRowIsAsExpected(iterator.next(), ChessBoard.ROW._7);
        checkRowIsAsExpected(iterator.next(), ChessBoard.ROW._8);

    }

    private void checkRowIsAsExpected(ChessBoard.RowContainer rowContainer, ChessBoard.ROW expected) {
        assertEquals(expected, rowContainer.getRow());

        Iterator<ChessBoard.Square> iterator = rowContainer.iterator();
        assertEquals(ChessBoard.COLUMN.A, iterator.next().getColumn());
        assertEquals(ChessBoard.COLUMN.B, iterator.next().getColumn());
        assertEquals(ChessBoard.COLUMN.C, iterator.next().getColumn());
        assertEquals(ChessBoard.COLUMN.D, iterator.next().getColumn());
        assertEquals(ChessBoard.COLUMN.E, iterator.next().getColumn());
        assertEquals(ChessBoard.COLUMN.F, iterator.next().getColumn());
        assertEquals(ChessBoard.COLUMN.G, iterator.next().getColumn());
        assertEquals(ChessBoard.COLUMN.H, iterator.next().getColumn());
    }


    @Test
    public void whenLegalMovesSetIsRequestedEmptySquareMustReturnEmptySet() {
        ChessBoard chessBoard = ChessBoardFactory.emptyBoard();
        assertTrue(chessBoard.moveSet(ChessBoard.ROW._1, ChessBoard.COLUMN.A).isEmpty());
    }
}
