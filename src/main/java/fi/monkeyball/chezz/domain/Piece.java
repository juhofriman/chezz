package fi.monkeyball.chezz.domain;

import java.util.Collections;
import java.util.Set;

/**
 * Created by juho on 5/24/15.
 */
public interface Piece {

    public Set<ChessBoard.Square> movesFrom(ChessBoard chessBoard, ChessBoard.Square location);
}
