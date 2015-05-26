package fi.monkeyball.chezz.domain;

import org.junit.Test;

/**
 * Created by juho on 26/05/15.
 */
public class RookTest extends PieceTests {

    @Override
    protected String getActor() {
        return "rook";
    }

    @Test
    public void testRookMovesFromCorner() {
        ChessBoard chessBoard = ChessBoardFactory.emptyBoard();
        chessBoard.placePiece(new Rook(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._1));

        MoveSet rookMoveSet = chessBoard.moveSet(chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._1));
        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._2));
        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._3));
        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._4));
        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._5));
        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._6));
        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._7));
        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._8));

        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.B, ChessBoard.ROW._1));
        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.C, ChessBoard.ROW._1));
        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.D, ChessBoard.ROW._1));
        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.E, ChessBoard.ROW._1));
        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.F, ChessBoard.ROW._1));
        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.G, ChessBoard.ROW._1));
        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.H, ChessBoard.ROW._1));

    }

    @Test
    public void testRookMovesFromAnotherCorner() {
        ChessBoard chessBoard = ChessBoardFactory.emptyBoard();
        chessBoard.placePiece(new Rook(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.COLUMN.H, ChessBoard.ROW._8));

        MoveSet rookMoveSet = chessBoard.moveSet(chessBoard.squareAt(ChessBoard.COLUMN.H, ChessBoard.ROW._8));
        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.H, ChessBoard.ROW._1));
        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.H, ChessBoard.ROW._2));
        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.H, ChessBoard.ROW._3));
        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.H, ChessBoard.ROW._4));
        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.H, ChessBoard.ROW._5));
        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.H, ChessBoard.ROW._6));
        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.H, ChessBoard.ROW._7));

        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._8));
        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.B, ChessBoard.ROW._8));
        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.C, ChessBoard.ROW._8));
        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.D, ChessBoard.ROW._8));
        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.E, ChessBoard.ROW._8));
        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.F, ChessBoard.ROW._8));
        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.G, ChessBoard.ROW._8));

    }

    @Test
    public void testRookMovesFromCenter() {
        ChessBoard chessBoard = ChessBoardFactory.emptyBoard();
        chessBoard.placePiece(new Rook(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.COLUMN.B, ChessBoard.ROW._4));

        MoveSet rookMoveSet = chessBoard.moveSet(chessBoard.squareAt(ChessBoard.COLUMN.B, ChessBoard.ROW._4));

        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.B, ChessBoard.ROW._1));
        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.B, ChessBoard.ROW._2));
        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.B, ChessBoard.ROW._3));
        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.B, ChessBoard.ROW._5));
        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.B, ChessBoard.ROW._6));
        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.B, ChessBoard.ROW._7));
        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.B, ChessBoard.ROW._8));

        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._4));
        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.C, ChessBoard.ROW._4));
        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.D, ChessBoard.ROW._4));
        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.E, ChessBoard.ROW._4));
        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.F, ChessBoard.ROW._4));
        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.G, ChessBoard.ROW._4));
        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.H, ChessBoard.ROW._4));
    }

    @Test
    public void testRookCantPassPiece() {
        ChessBoard chessBoard = ChessBoardFactory.emptyBoard();
        chessBoard.placePiece(new Rook(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._1));
        chessBoard.placePiece(new Rock(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._5));
        chessBoard.placePiece(new Rock(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.COLUMN.C, ChessBoard.ROW._1));

        MoveSet rookMoveSet = chessBoard.moveSet(chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._1));

        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._2));
        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._3));
        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._4));
        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._5));
        doesNotContainSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._6));
        doesNotContainSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._7));
        doesNotContainSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._8));

        containsSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.B, ChessBoard.ROW._1));
        doesNotContainSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.C, ChessBoard.ROW._1));
        doesNotContainSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.D, ChessBoard.ROW._1));
        doesNotContainSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.E, ChessBoard.ROW._1));
        doesNotContainSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.F, ChessBoard.ROW._1));
        doesNotContainSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.G, ChessBoard.ROW._1));
        doesNotContainSquare(rookMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.H, ChessBoard.ROW._1));

        // TODO: you should assert this south and west as well
    }
}