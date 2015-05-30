package fi.monkeyball.chezz.domain.game;

import fi.monkeyball.chezz.domain.pieces.Piece;

/**
 * Created by juho on 30/05/15.
 */
public interface ChessEventListener {

    void onGiveup(Giveup giveup, ChessGameState gameState);
    void onMove(StandardMove move, ChessGameState gameState);
    void onCapture(Piece capturer, Piece capturee, StandardMove move, ChessGameState gameState);


}
