package fi.monkeyball.chezz.domain.game;

import fi.monkeyball.chezz.domain.ChessBoard;
import fi.monkeyball.chezz.domain.pieces.King;
import fi.monkeyball.chezz.domain.pieces.Piece;

/**
 * Created by juho on 30/05/15.
 */
public class ChessGameState {

    private Piece.Color winner;
    private Piece.Color currentTurn;

    public ChessGameState(Piece.Color turn) {
        this.currentTurn = turn;
    }

    public boolean isFinished() {
        return this.winner != null;
    }

    public Piece.Color getWinner() {
        return winner;
    }

    public void setWinner(Piece.Color winner) {
        this.winner = winner;
    }

    public Piece.Color getCurrentTurn() {
        return currentTurn;
    }

    public void switchTurn() {
        this.currentTurn = currentTurn.compliment();
    }

    public boolean isCheck(ChessBoard chessBoard) {
        // Kludge: tests can contain situation where no king exists on board
        if(chessBoard.getPieces(King.class, getCurrentTurn()).isEmpty()) {
            return false;
        }
        ChessBoard.Square kingsSquare = chessBoard.getPieces(King.class, getCurrentTurn()).iterator().next();
        for (ChessBoard.Square square : chessBoard.getPopulatedSquares(getCurrentTurn().compliment())) {
            if(chessBoard.moveSet(square).contains(kingsSquare)) {
                return true;
            }
        }
        return false;
    }

    public boolean isCheckMate(ChessBoard chessBoard) {
        if(isCheck(chessBoard)) {
            ChessBoard.Square kingsSquare = chessBoard.getPieces(King.class, getCurrentTurn()).iterator().next();
            for (ChessBoard.Square square : chessBoard.moveSet(kingsSquare)) {
                if(!isCheck(chessBoard.future(kingsSquare, square))) {
                    return false;
                }
            }
            return true;

        }
        return false;
    }
}
