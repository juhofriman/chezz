package fi.monkeyball.chezz.domain.game;

import fi.monkeyball.chezz.domain.ChessBoard;
import fi.monkeyball.chezz.domain.ChessBoardBuilder;
import fi.monkeyball.chezz.domain.pieces.Bishop;
import fi.monkeyball.chezz.domain.pieces.King;
import fi.monkeyball.chezz.domain.pieces.Piece;
import fi.monkeyball.chezz.domain.pieces.Rook;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by juho on 30/05/15.
 */
public class ChessGameStateTest {

    @Test
    public void testIsNotChess() {
        ChessGameState chessGameState = new ChessGameState(Piece.Color.BLACK);

        assertFalse(chessGameState.isCheck(new ChessBoardBuilder()
                .place(Piece.Color.BLACK, King.class, ChessBoard.COLUMN.C, ChessBoard.ROW._1)
                .place(Piece.Color.WHITE, Rook.class, ChessBoard.COLUMN.A, ChessBoard.ROW._5)
                .build()));

    }

    @Test
    public void testIsChess() {
        ChessGameState chessGameState = new ChessGameState(Piece.Color.BLACK);

        assertTrue(chessGameState.isCheck(new ChessBoardBuilder()
                .place(Piece.Color.BLACK, King.class, ChessBoard.COLUMN.A, ChessBoard.ROW._1)
                .place(Piece.Color.WHITE, Rook.class, ChessBoard.COLUMN.A, ChessBoard.ROW._8)
                .build()));

    }

    @Test
    public void testIsNotCheckMate() {
        ChessGameState chessGameState = new ChessGameState(Piece.Color.BLACK);

        assertFalse(chessGameState.isCheckMate(new ChessBoardBuilder()
                .place(Piece.Color.BLACK, King.class, ChessBoard.COLUMN.A, ChessBoard.ROW._1)
                .place(Piece.Color.WHITE, Rook.class, ChessBoard.COLUMN.A, ChessBoard.ROW._8)
                .place(Piece.Color.WHITE, Rook.class, ChessBoard.COLUMN.H, ChessBoard.ROW._1)
                .build()));

    }

    @Test
    public void testIsCheckMate() {
        ChessGameState chessGameState = new ChessGameState(Piece.Color.BLACK);

        assertTrue(chessGameState.isCheckMate(new ChessBoardBuilder()
                .place(Piece.Color.BLACK, King.class, ChessBoard.COLUMN.A, ChessBoard.ROW._1)
                .place(Piece.Color.WHITE, Rook.class, ChessBoard.COLUMN.A, ChessBoard.ROW._8)
                .place(Piece.Color.WHITE, Rook.class, ChessBoard.COLUMN.H, ChessBoard.ROW._1)
                .place(Piece.Color.WHITE, Bishop.class, ChessBoard.COLUMN.H, ChessBoard.ROW._8)
                .build()));

    }
}
