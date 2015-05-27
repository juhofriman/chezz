package fi.monkeyball.chezz.domain;


/**
 * Created by juho on 27/05/15.
 */
public interface ChessEventHandler {

    public void onGiveup(Piece.Color loser);

    public void onMove(Piece moved, Move move);

    void onCapture(Piece capturer, Piece captured, Move move);
}
