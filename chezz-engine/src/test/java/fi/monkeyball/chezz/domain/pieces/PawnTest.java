package fi.monkeyball.chezz.domain.pieces;

import fi.monkeyball.chezz.domain.ChessBoard;
import fi.monkeyball.chezz.domain.EmptyChessBoardFactory;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertTrue;

/**
 * Created by juho on 5/25/15.
 */
public class PawnTest extends PieceTests {

    @Override
    protected String getActor() {
        return "pawn";
    }

    @Test
    public void testWhitePawnStartMoves() {
        ChessBoard chessBoard = new EmptyChessBoardFactory().instance();
        chessBoard.placePiece(new Pawn(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._2, ChessBoard.COLUMN.A));

        Set<ChessBoard.Square> pawnMoveSet = chessBoard.moveSet(chessBoard.squareAt(ChessBoard.ROW._2, ChessBoard.COLUMN.A));
        assertDoesNotContainFriendlies(pawnMoveSet, Piece.Color.WHITE);

        containsSquare(pawnMoveSet, chessBoard.squareAt(ChessBoard.ROW._3, ChessBoard.COLUMN.A));
        containsSquare(pawnMoveSet, chessBoard.squareAt(ChessBoard.ROW._4, ChessBoard.COLUMN.A));
    }

    @Test
    public void testWhitePawnMovesAfterStart() {
        ChessBoard chessBoard = new EmptyChessBoardFactory().instance();
        chessBoard.placePiece(new Pawn(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._4, ChessBoard.COLUMN.A));

        Set<ChessBoard.Square> pawnMoveSet = chessBoard.moveSet(chessBoard.squareAt(ChessBoard.ROW._4, ChessBoard.COLUMN.A));
        assertDoesNotContainFriendlies(pawnMoveSet, Piece.Color.WHITE);

        containsSquare(pawnMoveSet, chessBoard.squareAt(ChessBoard.ROW._5, ChessBoard.COLUMN.A));
        doesNotContainSquare(pawnMoveSet, chessBoard.squareAt(ChessBoard.ROW._6, ChessBoard.COLUMN.A));
    }

    @Test
    public void testBlackPawnStartMoves() {
        ChessBoard chessBoard = new EmptyChessBoardFactory().instance();
        chessBoard.placePiece(new Pawn(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.ROW._7, ChessBoard.COLUMN.A));

        Set<ChessBoard.Square> pawnMoveSet = chessBoard.moveSet(chessBoard.squareAt(ChessBoard.ROW._7, ChessBoard.COLUMN.A));
        assertDoesNotContainFriendlies(pawnMoveSet, Piece.Color.BLACK);

        containsSquare(pawnMoveSet, chessBoard.squareAt(ChessBoard.ROW._6, ChessBoard.COLUMN.A));
        containsSquare(pawnMoveSet, chessBoard.squareAt(ChessBoard.ROW._5, ChessBoard.COLUMN.A));
    }

    @Test
    public void testBlackPawnMovesAfterStart() {
        ChessBoard chessBoard = new EmptyChessBoardFactory().instance();
        chessBoard.placePiece(new Pawn(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.ROW._4, ChessBoard.COLUMN.A));

        Set<ChessBoard.Square> pawnMoveSet = chessBoard.moveSet(chessBoard.squareAt(ChessBoard.ROW._4, ChessBoard.COLUMN.A));
        assertDoesNotContainFriendlies(pawnMoveSet, Piece.Color.BLACK);

        containsSquare(pawnMoveSet, chessBoard.squareAt(ChessBoard.ROW._3, ChessBoard.COLUMN.A));
        doesNotContainSquare(pawnMoveSet, chessBoard.squareAt(ChessBoard.ROW._2, ChessBoard.COLUMN.A));
    }

    @Test
    public void whitePawnCapturesSideWaysToNorth() {
        ChessBoard chessBoard = new EmptyChessBoardFactory().instance();
        chessBoard.placePiece(new Pawn(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._4, ChessBoard.COLUMN.B));
        chessBoard.placePiece(new Pawn(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.ROW._5, ChessBoard.COLUMN.C));
        chessBoard.placePiece(new Pawn(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.ROW._5, ChessBoard.COLUMN.A));

        Set<ChessBoard.Square> pawnMoveSet = chessBoard.moveSet(chessBoard.squareAt(ChessBoard.ROW._4, ChessBoard.COLUMN.B));
        assertDoesNotContainFriendlies(pawnMoveSet, Piece.Color.WHITE);

        // Can move forward
        containsSquare(pawnMoveSet, chessBoard.squareAt(ChessBoard.ROW._5, ChessBoard.COLUMN.C));
        // Can capture left
        containsSquare(pawnMoveSet, chessBoard.squareAt(ChessBoard.ROW._5, ChessBoard.COLUMN.A));
        // Can capture right
        containsSquare(pawnMoveSet, chessBoard.squareAt(ChessBoard.ROW._5, ChessBoard.COLUMN.C));
    }

    @Test
    public void blackPawnCapturesSideWaysToEast() {
        ChessBoard chessBoard = new EmptyChessBoardFactory().instance();
        chessBoard.placePiece(new Pawn(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.ROW._4, ChessBoard.COLUMN.B));
        chessBoard.placePiece(new Pawn(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._3, ChessBoard.COLUMN.C));
        chessBoard.placePiece(new Pawn(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._3, ChessBoard.COLUMN.A));

        Set<ChessBoard.Square> pawnMoveSet = chessBoard.moveSet(chessBoard.squareAt(ChessBoard.ROW._4, ChessBoard.COLUMN.B));
        assertDoesNotContainFriendlies(pawnMoveSet, Piece.Color.BLACK);

        // Can move forward (to south)
        containsSquare(pawnMoveSet, chessBoard.squareAt(ChessBoard.ROW._3, ChessBoard.COLUMN.C));
        // Can capture left
        containsSquare(pawnMoveSet, chessBoard.squareAt(ChessBoard.ROW._3, ChessBoard.COLUMN.A));
        // Can capture right
        containsSquare(pawnMoveSet, chessBoard.squareAt(ChessBoard.ROW._3, ChessBoard.COLUMN.C));
    }

    @Test
    public void pawnDoesNotAttackFriendly() {
        ChessBoard chessBoard = new EmptyChessBoardFactory().instance();
        chessBoard.placePiece(new Pawn(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._4, ChessBoard.COLUMN.B));
        chessBoard.placePiece(new Pawn(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._5, ChessBoard.COLUMN.B));

        assertTrue(chessBoard.moveSet(chessBoard.squareAt(ChessBoard.ROW._4, ChessBoard.COLUMN.B)).isEmpty());
    }

    @Test
    public void pawnCantJumpOverPiece() {
        ChessBoard chessBoard = new EmptyChessBoardFactory().instance();
        chessBoard.placePiece(new Pawn(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._2, ChessBoard.COLUMN.A));
        chessBoard.placePiece(new Pawn(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._3, ChessBoard.COLUMN.A));

        chessBoard.placePiece(new Pawn(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.ROW._7, ChessBoard.COLUMN.A));
        chessBoard.placePiece(new Pawn(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.ROW._6, ChessBoard.COLUMN.A));

        assertMoveSetIsEmpty(chessBoard.moveSet(chessBoard.squareAt(ChessBoard.ROW._2, ChessBoard.COLUMN.A)));
        assertMoveSetIsEmpty(chessBoard.moveSet(chessBoard.squareAt(ChessBoard.ROW._7, ChessBoard.COLUMN.A)));
    }

    @Test
    public void pawnCantCaptureForward() {
        ChessBoard chessBoard = new EmptyChessBoardFactory().instance();
        chessBoard.placePiece(new Pawn(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._2, ChessBoard.COLUMN.A));
        chessBoard.placePiece(new Pawn(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.ROW._3, ChessBoard.COLUMN.A));

        chessBoard.placePiece(new Pawn(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.ROW._7, ChessBoard.COLUMN.A));
        chessBoard.placePiece(new Pawn(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._6, ChessBoard.COLUMN.A));

        assertMoveSetIsEmpty(chessBoard.moveSet(chessBoard.squareAt(ChessBoard.ROW._2, ChessBoard.COLUMN.A)));
        assertMoveSetIsEmpty(chessBoard.moveSet(chessBoard.squareAt(ChessBoard.ROW._7, ChessBoard.COLUMN.A)));
    }

    private void assertMoveSetIsEmpty(MoveSet moveSet) {
        assertTrue("Expecting " + moveSet + " to be empty", moveSet.isEmpty());
    }
}
