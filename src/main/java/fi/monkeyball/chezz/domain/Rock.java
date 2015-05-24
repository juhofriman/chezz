package fi.monkeyball.chezz.domain;

import java.util.Collections;
import java.util.Set;

/**
 * Created by juho on 5/24/15.
 */
public class Rock implements Piece {

    // This is temp piece which is used as a placeholder until all pieces are implemented

    @Override
    public Set<ChessBoard.Square> movesFrom(ChessBoard chessBoard, ChessBoard.Square location) {
        return Collections.emptySet();
    }
}
