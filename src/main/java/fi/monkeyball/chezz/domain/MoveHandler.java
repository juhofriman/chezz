package fi.monkeyball.chezz.domain;

/**
 * Created by juho on 27/05/15.
 */
public interface MoveHandler {

    Move handleState(ChessBoard chessBoard);
}
