package fi.monkeyball.chezz.domain.game;

import fi.monkeyball.chezz.domain.ChessBoard;
import fi.monkeyball.chezz.domain.ChessBoardFactory;

/**
 * Created by juho on 29/05/15.
 */
public class GameOfChess {

    private final ChessBoard board;
    private MoveGenerator moveGenerator;
    private ChessGameState chessGameState;
    private MoveVisitor chessRules = new ChessRules();
    private ChessEventListener chessEventListener;

    public GameOfChess(ChessBoardFactory factory) {
        this(factory.instance());
    }

    public GameOfChess(ChessBoard preBuiltChessBoard) {
        board = preBuiltChessBoard;
        chessGameState = new ChessGameState();
    }

    public ChessBoard getBoard() {
        return board;
    }

    public void setMoveGenerator(MoveGenerator moveGenerator) {
        this.moveGenerator = moveGenerator;
    }

    public void turn() {
        Move move = moveGenerator.getMove(chessGameState.getCurrentTurn(), this.board);
        move.accept(this.chessRules);
        chessGameState.switchTurn();
    }

    public ChessGameState getState() {
        return chessGameState;
    }

    public void setChessEventListener(ChessEventListener chessEventListener) {
        this.chessEventListener = chessEventListener;
    }

    private class ChessRules implements MoveVisitor {

        @Override
        public void visit(Giveup giveup) {
            chessGameState.setWinner(chessGameState.getCurrentTurn().compliment());
            if(chessEventListener != null) {
                chessEventListener.onGiveup(giveup, chessGameState);
            }
        }

        @Override
        public void visit(StandardMove move) {
            board.move(move.getFrom(), move.getTo());
            if(chessEventListener != null) {
                chessEventListener.onMove(move, chessGameState);
            }
        }
    }
}
