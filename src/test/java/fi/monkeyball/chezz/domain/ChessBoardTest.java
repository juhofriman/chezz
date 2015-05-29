package fi.monkeyball.chezz.domain;

import fi.monkeyball.chezz.domain.pieces.Pawn;
import fi.monkeyball.chezz.domain.pieces.Piece;
import fi.monkeyball.chezz.domain.pieces.Rook;
import org.junit.Test;

import java.util.Iterator;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNull;

/**
 * Created by juho on 5/24/15.
 */
public class ChessBoardTest {

    @Test
    public void chessBoardCanBeIteratedAndSizeIs8x8() {
        ChessBoard chessBoard = new EmptyChessBoardFactory().instance();
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
        ChessBoard chessBoard = new EmptyChessBoardFactory().instance();
        for(ChessBoard.RowContainer rowContainer : chessBoard) {
            for(ChessBoard.Square square : rowContainer) {
                assertTrue(square.isEmpty());
            }
        }
    }

    @Test
    public void coordinatesAreAsExpectedInChessBoard() {
        ChessBoard chessBoard = new EmptyChessBoardFactory().instance();
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
        ChessBoard chessBoard = new EmptyChessBoardFactory().instance();
        for (ChessBoard.RowContainer squares : chessBoard) {
            for (ChessBoard.Square square : squares) {
                // TODO: this could return Empty Piece which does not move and is friendly to everyone
                assertNull(chessBoard.squareAt(square.getColumn(), square.getRow()).getPiece());
                assertTrue(chessBoard.moveSet(chessBoard.squareAt(square.getColumn(), square.getRow())).isEmpty());
            }
        }
    }

    @Test
    public void piecesCanMove() {
        ChessBoard chessBoard = new EmptyChessBoardFactory().instance();
        chessBoard.placePiece(new Rook(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._1));

        chessBoard.move(chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._1),
                chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._8));

        assertTrue("Found piece at original place after move",
                chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._1).isEmpty());
        assertFalse("Did not found piece at expected place after move",
                chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._8).isEmpty());
    }

    @Test(expected = ChessBoardException.class)
    public void pieceCantMoveIfNotInMoveSet() {
        ChessBoard chessBoard = new EmptyChessBoardFactory().instance();
        chessBoard.placePiece(new Rook(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._1));

        // This is not how Rook moves
        chessBoard.move(chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._1),
                chessBoard.squareAt(ChessBoard.COLUMN.C, ChessBoard.ROW._4));
    }

    @Test(expected = ChessBoardException.class)
    public void cantMoveEmptySquare() {
        ChessBoard chessBoard = new EmptyChessBoardFactory().instance();

        // It's empty board
        chessBoard.move(chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._1),
                chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._4));
    }

    @Test(expected = IllegalSquareReferenceException.class)
    public void throwsIfAccessingSquareFromAnotherChessBoardSquareAt() {
        ChessBoard chessBoard1 = new EmptyChessBoardFactory().instance();
        ChessBoard chessBoard2 = new EmptyChessBoardFactory().instance();
        chessBoard2.moveSet(chessBoard1.squareAt(ChessBoard.COLUMN.F, ChessBoard.ROW._4));
    }

    @Test(expected = IllegalSquareReferenceException.class)
    public void throwsIfAccessingSquareFromAnotherChessBoardPlacePiece() {
        ChessBoard chessBoard1 = new EmptyChessBoardFactory().instance();
        ChessBoard chessBoard2 = new EmptyChessBoardFactory().instance();
        chessBoard2.placePiece(new Pawn(Piece.Color.WHITE),
                chessBoard1.squareAt(ChessBoard.COLUMN.F, ChessBoard.ROW._4));
    }

    @Test(expected = IllegalSquareReferenceException.class)
    public void throwsIfAccessingSquareFromAnotherChessBoardMoveFromWrong() {
        ChessBoard chessBoard1 = new EmptyChessBoardFactory().instance();
        ChessBoard chessBoard2 = new EmptyChessBoardFactory().instance();
        chessBoard2.move(chessBoard1.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._1),
                chessBoard2.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._2));
    }

    @Test(expected = IllegalSquareReferenceException.class)
    public void throwsIfAccessingSquareFromAnotherChessBoardMoveToWrong() {
        ChessBoard chessBoard1 = new EmptyChessBoardFactory().instance();
        ChessBoard chessBoard2 = new EmptyChessBoardFactory().instance();
        chessBoard2.move(chessBoard2.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._1),
                chessBoard1.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._2));
    }
}
