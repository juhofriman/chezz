package fi.monkeyball.chezz.domain.game;

import fi.monkeyball.chezz.domain.ChessBoard;
import fi.monkeyball.chezz.domain.pieces.Piece;

/**
 * Created by juho on 30/05/15.
 */
public class BaseChessEventListener implements ChessEventListener {
    @Override
    public void onGiveup(Giveup giveup, ChessGameState gameState) {

    }

    @Override
    public void onMove(StandardMove move, ChessGameState gameState) {

    }

    @Override
    public void onCapture(Piece capturer, Piece capturee, StandardMove move, ChessGameState gameState) {

    }

    @Override
    public void onCheck(ChessBoard.Square kingOnCheck) {

    }

    @Override
    public void onCheckMate(ChessBoard.Square kingOnCheckMate) {

    }
}
