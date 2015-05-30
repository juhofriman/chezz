package fi.monkeyball.chezz.domain.game;

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
}
