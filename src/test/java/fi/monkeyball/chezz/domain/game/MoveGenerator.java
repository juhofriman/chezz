package fi.monkeyball.chezz.domain.game;

import fi.monkeyball.chezz.domain.ChessBoard;
import fi.monkeyball.chezz.domain.pieces.Piece;

/**
 * Created by juho on 29/05/15.
 */
public interface MoveGenerator {

    Move getMove(Piece.Color turn, ChessBoard chessBoard);
}
