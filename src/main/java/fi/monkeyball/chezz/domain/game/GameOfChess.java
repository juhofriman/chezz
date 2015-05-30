package fi.monkeyball.chezz.domain.game;

import fi.monkeyball.chezz.domain.ChessBoard;
import fi.monkeyball.chezz.domain.ChessBoardFactory;
import fi.monkeyball.chezz.domain.pieces.Piece;

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
        this(factory.instance(), Piece.Color.WHITE);
    }

    public GameOfChess(ChessBoard preBuiltChessBoard, Piece.Color turn) {
        board = preBuiltChessBoard;
        chessGameState = new ChessGameState(turn);
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
            Piece fromPiece = move.getFrom().getPiece();
            Piece toPiece = move.getTo().getPiece();
            board.move(move.getFrom(), move.getTo());
            if(chessEventListener != null) {
                if(move.isCapture()) {
                    chessEventListener.onCapture(fromPiece, toPiece, move, chessGameState);
                } else {
                    chessEventListener.onMove(move, chessGameState);
                }
            }

        }
    }
}
