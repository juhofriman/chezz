package fi.monkeyball.chezz.domain;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by juho on 5/24/15.
 */
public class KingTest extends PieceTests {

    @Override
    protected String getActor() {
        return "King";
    }

    @Test
    public void testMovesWhenEverywhereIsFreedom() {
        ChessBoard chessBoard = ChessBoardFactory.emptyBoard();
        chessBoard.placePiece(new King(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._4, ChessBoard.COLUMN.B));

        MoveSet kingMoveSet = chessBoard.moveSet(chessBoard.squareAt(ChessBoard.ROW._4, ChessBoard.COLUMN.B));

        assertDoesNotContainFriendlies(kingMoveSet, Piece.Color.WHITE);
        containsSquare(kingMoveSet, chessBoard.squareAt(ChessBoard.ROW._3, ChessBoard.COLUMN.B));
        containsSquare(kingMoveSet, chessBoard.squareAt(ChessBoard.ROW._3, ChessBoard.COLUMN.A));
        containsSquare(kingMoveSet, chessBoard.squareAt(ChessBoard.ROW._3, ChessBoard.COLUMN.C));
        containsSquare(kingMoveSet, chessBoard.squareAt(ChessBoard.ROW._4, ChessBoard.COLUMN.A));
        containsSquare(kingMoveSet, chessBoard.squareAt(ChessBoard.ROW._4, ChessBoard.COLUMN.C));
        containsSquare(kingMoveSet, chessBoard.squareAt(ChessBoard.ROW._5, ChessBoard.COLUMN.A));
        containsSquare(kingMoveSet, chessBoard.squareAt(ChessBoard.ROW._5, ChessBoard.COLUMN.B));
        containsSquare(kingMoveSet, chessBoard.squareAt(ChessBoard.ROW._5, ChessBoard.COLUMN.C));

    }

    @Test
    public void testOnCorner() {
        ChessBoard chessBoard = ChessBoardFactory.emptyBoard();
        chessBoard.placePiece(new King(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._1, ChessBoard.COLUMN.A));

        MoveSet kingMoveSet = chessBoard.moveSet(chessBoard.squareAt(ChessBoard.ROW._1, ChessBoard.COLUMN.A));

        assertDoesNotContainFriendlies(kingMoveSet, Piece.Color.WHITE);
        containsSquare(kingMoveSet, chessBoard.squareAt(ChessBoard.ROW._1, ChessBoard.COLUMN.B));
        containsSquare(kingMoveSet, chessBoard.squareAt(ChessBoard.ROW._2, ChessBoard.COLUMN.A));
        containsSquare(kingMoveSet, chessBoard.squareAt(ChessBoard.ROW._2, ChessBoard.COLUMN.B));
    }

    @Test
    public void testRemovesFriendlySquares() {
        ChessBoard chessBoard = ChessBoardFactory.emptyBoard();
        chessBoard.placePiece(new King(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._1, ChessBoard.COLUMN.A));
        chessBoard.placePiece(new Pawn(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._1, ChessBoard.COLUMN.B));

        MoveSet kingMoveSet = chessBoard.moveSet(chessBoard.squareAt(ChessBoard.ROW._1, ChessBoard.COLUMN.A));

        assertDoesNotContainFriendlies(kingMoveSet, Piece.Color.WHITE);
        containsSquare(kingMoveSet, chessBoard.squareAt(ChessBoard.ROW._2, ChessBoard.COLUMN.A));
        containsSquare(kingMoveSet, chessBoard.squareAt(ChessBoard.ROW._2, ChessBoard.COLUMN.B));
    }
}
