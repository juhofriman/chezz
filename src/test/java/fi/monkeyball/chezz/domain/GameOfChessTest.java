package fi.monkeyball.chezz.domain;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/**
 * Created by juho on 27/05/15.
 */
public class GameOfChessTest {

    @Test
    public void assertNewGameContainsBoard() {
        GameOfChess gameOfChess = new GameOfChess();
        assertNotNull(gameOfChess.board());
    }

    @Test
    public void assertStartingMoveIsWhite() {
        GameOfChess gameOfChess = new GameOfChess();
        assertEquals(Piece.Color.WHITE, gameOfChess.nextMove());
        gameOfChess.move();
        assertEquals(Piece.Color.BLACK, gameOfChess.nextMove());
        gameOfChess.move();
        assertEquals(Piece.Color.WHITE, gameOfChess.nextMove());
    }

    @Test
    public void testCanAddMoveHandler() {
        GameOfChess gameOfChess = new GameOfChess();
        final AtomicBoolean onGiveUpCalled = new AtomicBoolean(false);
        gameOfChess.addEventHandler(new ChessEventHandler() {
            @Override
            public void onGiveup(Piece.Color loser) {
                if(loser != Piece.Color.WHITE) {
                    fail("Expecting losert to be white");
                }
                onGiveUpCalled.set(true);
            }

            @Override
            public void onMove(Piece moved, Move move) {

            }

            @Override
            public void onCapture(Piece captured, Piece capture, Move move) {

            }
        });
        gameOfChess.addMoveHandler(new MoveHandler() {
            @Override
            public Move handleState(ChessBoard chessBoard) {
                return Move.GIVEUP;
            }
        });
        gameOfChess.move();
        assertTrue("Expecting onGiveUp to be called after first move", onGiveUpCalled.get());
    }

    @Test
    public void testMovHandlerMutatesState() {
        GameOfChess gameOfChess = new GameOfChess(ChessBoardFactory.emptyBoard());
        gameOfChess.board().placePiece(new Rook(Piece.Color.WHITE), gameOfChess.board().squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._1));
        gameOfChess.addEventHandler(new ChessEventHandler() {
            @Override
            public void onGiveup(Piece.Color loser) {
            }

            @Override
            public void onMove(Piece moved, Move move) {

            }

            @Override
            public void onCapture(Piece captured, Piece capture, Move move) {

            }
        });
        gameOfChess.addMoveHandler(new MoveHandler() {
            @Override
            public Move handleState(ChessBoard chessBoard) {
                return new Move(chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._1),
                        chessBoard.squareAt(ChessBoard.COLUMN.D, ChessBoard.ROW._1));
            }
        });
        gameOfChess.move();
        assertTrue("MoveHandler did not mutate state", gameOfChess.board().squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._1).isEmpty());
        assertFalse("MoveHandler did not mutate state", gameOfChess.board().squareAt(ChessBoard.COLUMN.D, ChessBoard.ROW._1).isEmpty());

    }
}
