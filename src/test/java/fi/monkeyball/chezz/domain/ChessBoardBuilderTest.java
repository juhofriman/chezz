package fi.monkeyball.chezz.domain;

import fi.monkeyball.chezz.domain.pieces.King;
import fi.monkeyball.chezz.domain.pieces.Pawn;
import fi.monkeyball.chezz.domain.pieces.Piece;
import fi.monkeyball.chezz.domain.pieces.Queen;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by juho on 30/05/15.
 */
public class ChessBoardBuilderTest {

    @Test
    public void testBuilderCreatesEmptyBoard() {
        ChessBoard chessBoard = new ChessBoardBuilder().build();
        for (ChessBoard.RowContainer squares : chessBoard) {
            for (ChessBoard.Square square : squares) {
                assertTrue(square.isEmpty());
            }
        }
    }

    @Test
    public void testBuilderPlacingSinglePiece() {
        ChessBoard chessBoard = new ChessBoardBuilder()
                .place(Piece.Color.WHITE, Pawn.class, ChessBoard.COLUMN.A, ChessBoard.ROW._1)
                .build();
        for (ChessBoard.RowContainer squares : chessBoard) {
            for (ChessBoard.Square square : squares) {
                if(square != chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._1)) {
                    assertTrue(square.isEmpty());
                } else {
                    assertFalse(square.isEmpty());
                    assertEquals(Pawn.class, square.getPiece().getClass());
                }
            }
        }
    }

    @Test
    public void testChainingOfBuilder() {
        ChessBoard chessBoard = new ChessBoardBuilder()
                .place(Piece.Color.WHITE, King.class, ChessBoard.COLUMN.A, ChessBoard.ROW._1)
                .place(Piece.Color.BLACK, Queen.class, ChessBoard.COLUMN.D, ChessBoard.ROW._5)
                .build();
        for (ChessBoard.RowContainer squares : chessBoard) {
            for (ChessBoard.Square square : squares) {
                if(square == chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._1)) {
                    assertFalse(square.isEmpty());
                    assertEquals(King.class, square.getPiece().getClass());
                    assertEquals(Piece.Color.WHITE, square.getPiece().getColor());
                } else if(square == chessBoard.squareAt(ChessBoard.COLUMN.D, ChessBoard.ROW._5)) {
                    assertFalse(square.isEmpty());
                    assertEquals(Queen.class, square.getPiece().getClass());
                    assertEquals(Piece.Color.BLACK, square.getPiece().getColor());
                } else {
                    assertTrue(square.isEmpty());
                }
            }
        }
    }
}
