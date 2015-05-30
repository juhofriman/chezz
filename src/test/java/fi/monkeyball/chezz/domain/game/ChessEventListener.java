package fi.monkeyball.chezz.domain.game;

/**
 * Created by juho on 30/05/15.
 */
public interface ChessEventListener {

    void onGiveup(Giveup giveup, ChessGameState gameState);
    void onMove(StandardMove move, ChessGameState gameState);

}
