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
        ChessBoard chessBoard = ChessBoardFactory.emptyBoard();
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
    public void useChessBoardFactoryForInitialChessBords() {
        ChessBoard chessBoard = ChessBoardFactory.emptyBoard();
        for(ChessBoard.Row row : chessBoard) {
            for(ChessBoard.Square square : row) {
                assertTrue(square.isEmpty());
            }
        }
    }
}
