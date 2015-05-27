package fi.monkeyball.chezz.domain;


/**
 * Created by juho on 27/05/15.
 */
public interface ChessEventHandler {

    public void onGiveup(Piece.Color loser);
}
