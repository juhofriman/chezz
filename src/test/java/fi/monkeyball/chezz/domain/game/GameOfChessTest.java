package fi.monkeyball.chezz.domain.game;

import fi.monkeyball.chezz.domain.ChessBoard;
import fi.monkeyball.chezz.domain.ChessBoardFactory;
import fi.monkeyball.chezz.domain.EmptyChessBoardFactory;
import fi.monkeyball.chezz.domain.StandardStartPositionChessboardFactory;
import fi.monkeyball.chezz.domain.pieces.Piece;
import org.junit.Before;
import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import static org.junit.Assert.*;

/**
 * Created by juho on 29/05/15.
 */
public class GameOfChessTest {

    private CallCountRegisteringEventListener callCountRegisteringEventListener;

    @Before
    public void resetCallcountRegisteringEventListener() {
        callCountRegisteringEventListener = new CallCountRegisteringEventListener();
    }

    @Test
    public void mustInitWithFactoryAndCanIterate() {
        GameOfChess gameOfChess = createBoard(new EmptyChessBoardFactory());
        for (ChessBoard.RowContainer squares : gameOfChess.getBoard()) {
            for (ChessBoard.Square square : squares) {
                assertTrue(square.isEmpty());
            }
        }
    }

    private GameOfChess createBoard(ChessBoardFactory factory) {
        GameOfChess gameOfChess = new GameOfChess(factory);
        gameOfChess.setChessEventListener(this.callCountRegisteringEventListener);
        return gameOfChess;
    }

    @Test
    public void testSimplestPossibleGame() {
        GameOfChess gameOfChess = createBoard(new EmptyChessBoardFactory());
        gameOfChess.setChessEventListener(this.callCountRegisteringEventListener);
        gameOfChess.setMoveGenerator(new MoveGenerator() {
            @Override
            public Move getMove(Piece.Color turn, ChessBoard chessBoard) {
                return new Giveup(turn);
            }
        });
        assertFalse(gameOfChess.getState().isFinished());
        gameOfChess.turn();
        assertEquals(1, this.callCountRegisteringEventListener.giveUpCalled);
        assertTrue(gameOfChess.getState().isFinished());
        assertEquals(Piece.Color.BLACK, gameOfChess.getState().getWinner());
    }

    @Test
    public void testTurnsChangeAndStardardMoveMutatesState() {
        GameOfChess gameOfChess = createBoard(new StandardStartPositionChessboardFactory());

        final Queue<Move> moves = new ArrayBlockingQueue<Move>(4);
        moves.add(new StandardMove(gameOfChess.getBoard().squareAt(ChessBoard.COLUMN.B, ChessBoard.ROW._2),
                gameOfChess.getBoard().squareAt(ChessBoard.COLUMN.B, ChessBoard.ROW._3)));
        moves.add(new StandardMove(gameOfChess.getBoard().squareAt(ChessBoard.COLUMN.F, ChessBoard.ROW._7),
                gameOfChess.getBoard().squareAt(ChessBoard.COLUMN.F, ChessBoard.ROW._6)));
        moves.add(new StandardMove(gameOfChess.getBoard().squareAt(ChessBoard.COLUMN.D, ChessBoard.ROW._2),
                gameOfChess.getBoard().squareAt(ChessBoard.COLUMN.D, ChessBoard.ROW._4)));
        moves.add(new StandardMove(gameOfChess.getBoard().squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._7),
                gameOfChess.getBoard().squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._5)));

        gameOfChess.setMoveGenerator(new MoveGenerator() {
            @Override
            public Move getMove(Piece.Color turn, ChessBoard chessBoard) {
                return moves.remove();
            }
        });

        assertFalse(gameOfChess.getState().isFinished());
        assertEquals(Piece.Color.WHITE, gameOfChess.getState().getCurrentTurn());
        assertTrue(gameOfChess.getBoard().squareAt(ChessBoard.COLUMN.B, ChessBoard.ROW._3).isEmpty());
        gameOfChess.turn();
        assertEquals(1, this.callCountRegisteringEventListener.onMoveCalled);
        assertFalse("Expecting turn to mutate state",
                gameOfChess.getBoard().squareAt(ChessBoard.COLUMN.B, ChessBoard.ROW._3).isEmpty());

        assertFalse(gameOfChess.getState().isFinished());
        assertEquals(Piece.Color.BLACK, gameOfChess.getState().getCurrentTurn());
        assertTrue(gameOfChess.getBoard().squareAt(ChessBoard.COLUMN.F, ChessBoard.ROW._6).isEmpty());
        gameOfChess.turn();
        assertEquals(2, this.callCountRegisteringEventListener.onMoveCalled);
        assertFalse("Expecting turn to mutate state",
                gameOfChess.getBoard().squareAt(ChessBoard.COLUMN.F, ChessBoard.ROW._6).isEmpty());

        assertFalse(gameOfChess.getState().isFinished());
        assertEquals(Piece.Color.WHITE, gameOfChess.getState().getCurrentTurn());
        assertTrue(gameOfChess.getBoard().squareAt(ChessBoard.COLUMN.D, ChessBoard.ROW._4).isEmpty());
        gameOfChess.turn();
        assertEquals(3, this.callCountRegisteringEventListener.onMoveCalled);
        assertFalse("Expecting turn to mutate state",
                gameOfChess.getBoard().squareAt(ChessBoard.COLUMN.D, ChessBoard.ROW._4).isEmpty());

        assertFalse(gameOfChess.getState().isFinished());
        assertEquals(Piece.Color.BLACK, gameOfChess.getState().getCurrentTurn());
        assertTrue(gameOfChess.getBoard().squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._5).isEmpty());
        gameOfChess.turn();
        assertEquals(4, this.callCountRegisteringEventListener.onMoveCalled);
        assertFalse("Expecting turn to mutate state",
                gameOfChess.getBoard().squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._5).isEmpty());
    }

    public static class CallCountRegisteringEventListener implements ChessEventListener {

        private int giveUpCalled = 0;
        private int onMoveCalled = 0;

        @Override
        public void onGiveup(Giveup giveup, ChessGameState gameState) {
            this.giveUpCalled++;
        }

        @Override
        public void onMove(StandardMove move, ChessGameState gameState) {
            this.onMoveCalled++;
        }
    }
}
