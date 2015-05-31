package fi.monkeyball.chezz.domain.game;

import fi.monkeyball.chezz.domain.*;
import fi.monkeyball.chezz.domain.pieces.Bishop;
import fi.monkeyball.chezz.domain.pieces.King;
import fi.monkeyball.chezz.domain.pieces.Piece;
import fi.monkeyball.chezz.domain.pieces.Rook;
import org.junit.Before;
import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

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

    @Test
    public void canAlsoGivePreInitializedBoardToChessGame() {
        GameOfChess gameOfChess = new GameOfChess(new ChessBoardBuilder() {{
            place(Piece.Color.WHITE, King.class, ChessBoard.COLUMN.A, ChessBoard.ROW._1);
            place(Piece.Color.BLACK, King.class, ChessBoard.COLUMN.A, ChessBoard.ROW._1);
        }}.build(), Piece.Color.WHITE);
        assertFalse(gameOfChess.getState().isFinished());
    }

    @Test
    public void testCapturingFiresOnCaptureEvent() {
        GameOfChess gameOfChess = new GameOfChess(new ChessBoardBuilder() {{
            place(Piece.Color.WHITE, Rook.class, ChessBoard.COLUMN.A, ChessBoard.ROW._1);
            place(Piece.Color.BLACK, Rook.class, ChessBoard.COLUMN.A, ChessBoard.ROW._7);
        }}.build(), Piece.Color.WHITE);

        gameOfChess.setMoveGenerator(new MoveGenerator() {
            @Override
            public Move getMove(Piece.Color turn, ChessBoard chessBoard) {
                return new StandardMove(chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._1),
                        chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._7));
            }
        });

        final Piece expectedCapturer = gameOfChess.getBoard().squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._1).getPiece();
        final Piece expectedCapturee = gameOfChess.getBoard().squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._7).getPiece();

        final AtomicBoolean onMoveCalled = new AtomicBoolean(false);
        final AtomicBoolean onCaptureCalled = new AtomicBoolean(false);
        gameOfChess.setChessEventListener(new BaseChessEventListener() {

            @Override
            public void onMove(StandardMove move, ChessGameState gameState) {
                onMoveCalled.set(true);
            }

            @Override
            public void onCapture(Piece capturer, Piece capturee, StandardMove move, ChessGameState gameState) {
                assertEquals("Expected captuter was wrong", expectedCapturer, capturer);
                assertEquals("Expected captuter was wrong", expectedCapturee, capturee);
                onCaptureCalled.set(true);
            }
        });

        gameOfChess.turn();

        assertFalse("Expecting onMove not called but it was", onMoveCalled.get());
        assertTrue("Expecting onCapture called but it was not", onCaptureCalled.get());
    }

    @Test
    public void testOnCheckEventIsInvokedWhenTurnIsChangedToChessPosition() {
        GameOfChess gameOfChess = new GameOfChess(new ChessBoardBuilder() {{
            place(Piece.Color.WHITE, Rook.class, ChessBoard.COLUMN.A, ChessBoard.ROW._2);
            place(Piece.Color.BLACK, King.class, ChessBoard.COLUMN.A, ChessBoard.ROW._8);
        }}.build(), Piece.Color.WHITE);
        gameOfChess.setChessEventListener(this.callCountRegisteringEventListener);

        gameOfChess.setMoveGenerator(new MoveGenerator() {
            @Override
            public Move getMove(Piece.Color turn, ChessBoard chessBoard) {
                return new StandardMove(chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._2),
                        chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._1));
            }
        });

        gameOfChess.turn();
        assertEquals(1, this.callCountRegisteringEventListener.onMoveCalled);
        assertEquals(1, this.callCountRegisteringEventListener.onCheckCalled);
    }

    @Test
    public void testOnCheckMateEventIsFired() {
        GameOfChess gameOfChess = new GameOfChess(new ChessBoardBuilder() {{
            place(Piece.Color.WHITE, Rook.class, ChessBoard.COLUMN.A, ChessBoard.ROW._8);
            place(Piece.Color.WHITE, Rook.class, ChessBoard.COLUMN.G, ChessBoard.ROW._2);
            place(Piece.Color.WHITE, Bishop.class, ChessBoard.COLUMN.H, ChessBoard.ROW._8);
            place(Piece.Color.BLACK, King.class, ChessBoard.COLUMN.A, ChessBoard.ROW._1);
        }}.build(), Piece.Color.WHITE);
        gameOfChess.setChessEventListener(this.callCountRegisteringEventListener);

        gameOfChess.setMoveGenerator(new MoveGenerator() {
            @Override
            public Move getMove(Piece.Color turn, ChessBoard chessBoard) {
                return new StandardMove(chessBoard.squareAt(ChessBoard.COLUMN.G, ChessBoard.ROW._2),
                        chessBoard.squareAt(ChessBoard.COLUMN.G, ChessBoard.ROW._1));
            }
        });

        gameOfChess.turn();
        assertEquals(1, this.callCountRegisteringEventListener.onMoveCalled);
        assertEquals(1, this.callCountRegisteringEventListener.onCheckCalled);
        assertEquals(1, this.callCountRegisteringEventListener.onCheckMateCalled);
    }

    @Test(expected = MoveCausesChessException.class)
    public void testCantMoveKingToChessPosition() {
        GameOfChess gameOfChess = new GameOfChess(new ChessBoardBuilder() {{
            place(Piece.Color.WHITE, Rook.class, ChessBoard.COLUMN.A, ChessBoard.ROW._8);
            place(Piece.Color.BLACK, King.class, ChessBoard.COLUMN.B, ChessBoard.ROW._1);
        }}.build(), Piece.Color.BLACK);
        gameOfChess.setChessEventListener(this.callCountRegisteringEventListener);

        gameOfChess.setMoveGenerator(new MoveGenerator() {
            @Override
            public Move getMove(Piece.Color turn, ChessBoard chessBoard) {
                return new StandardMove(chessBoard.squareAt(ChessBoard.COLUMN.B, ChessBoard.ROW._1),
                        chessBoard.squareAt(ChessBoard.COLUMN.A, ChessBoard.ROW._1));
            }
        });

        gameOfChess.turn();
    }



    public static class CallCountRegisteringEventListener implements ChessEventListener {

        private int giveUpCalled = 0;
        private int onMoveCalled = 0;
        private int onCaptureCalled = 0;
        private int onCheckCalled = 0;
        private int onCheckMateCalled = 0;

        @Override
        public void onGiveup(Giveup giveup, ChessGameState gameState) {
            this.giveUpCalled++;
        }

        @Override
        public void onMove(StandardMove move, ChessGameState gameState) {
            this.onMoveCalled++;
        }

        @Override
        public void onCapture(Piece capturer, Piece capturee, StandardMove move, ChessGameState gameState) {
            this.onCaptureCalled++;
        }

        @Override
        public void onCheck(ChessBoard.Square kingOnCheck) {
            this.onCheckCalled++;
        }

        @Override
        public void onCheckMate(ChessBoard.Square kingOnCheckMate) {
            this.onCheckMateCalled++;
        }
    }
}
