package fi.monkeyball.chezz.domain.pieces;

import fi.monkeyball.chezz.domain.ChessBoard;
import fi.monkeyball.chezz.domain.ChessBoardFactory;
import org.junit.Test;

/**
 * Created by juho on 5/26/15.
 */
public class KnightTest extends PieceTests {

    @Override
    protected String getActor() {
        return "Knight";
    }

    @Test
    public void knightCanJumpOver() {
        ChessBoard chessBoard = ChessBoardFactory.emptyBoard();
        chessBoard.placePiece(new Knight(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.COLUMN.D, ChessBoard.ROW._1));
        chessBoard.placePiece(new Pawn(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._2));
        chessBoard.placePiece(new Pawn(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.COLUMN.B, ChessBoard.ROW._2));
        chessBoard.placePiece(new Pawn(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.COLUMN.C, ChessBoard.ROW._2));
        chessBoard.placePiece(new Pawn(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.COLUMN.D, ChessBoard.ROW._2));
        chessBoard.placePiece(new Pawn(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.COLUMN.E, ChessBoard.ROW._2));
        chessBoard.placePiece(new Pawn(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.COLUMN.F, ChessBoard.ROW._2));
        chessBoard.placePiece(new Pawn(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.COLUMN.G, ChessBoard.ROW._2));
        chessBoard.placePiece(new Pawn(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.COLUMN.H, ChessBoard.ROW._2));

        MoveSet knightMoveSet = chessBoard.moveSet(chessBoard.squareAt(ChessBoard.COLUMN.D, ChessBoard.ROW._1));
        containsSquare(knightMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.B, ChessBoard.ROW._2));
        containsSquare(knightMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.F, ChessBoard.ROW._2));
        containsSquare(knightMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.C, ChessBoard.ROW._3));
        containsSquare(knightMoveSet, chessBoard.squareAt(ChessBoard.COLUMN.E, ChessBoard.ROW._3));
    }
}
