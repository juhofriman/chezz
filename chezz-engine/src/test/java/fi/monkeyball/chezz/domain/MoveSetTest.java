package fi.monkeyball.chezz.domain;

import fi.monkeyball.chezz.domain.pieces.MoveSet;
import fi.monkeyball.chezz.domain.pieces.Pawn;
import fi.monkeyball.chezz.domain.pieces.Piece;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by juho on 5/26/15.
 */
public class MoveSetTest {

    @Test
    public void testContains() {
        ChessBoard chessBoard = new EmptyChessBoardFactory().instance();
        chessBoard.placePiece(new Pawn(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._1, ChessBoard.COLUMN.A));
        MoveSet squares = new MoveSet(chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._1).getPiece());
        squares.addIfOnBoard(chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._2));

        assertTrue(squares.contains(chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._2)));
    }
}
