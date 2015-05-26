package fi.monkeyball.chezz.domain;

import java.util.HashSet;

/**
 * Created by juho on 5/25/15.
 */
public class MoveSet extends HashSet<ChessBoard.Square> {

    public static final MoveSet EMPTY = new MoveSet(null);
    private Piece piece;

    public MoveSet(Piece piece) {
        this.piece = piece;
    }

    @Override
    public boolean add(ChessBoard.Square square) {
        return super.add(square);
    }

    public boolean addIfOnBoard(ChessBoard.Square square) {
        if(square != ChessBoard.OUT_OF_BOARD) {
            if(square.isEmpty()) {
                super.add(square);
            } else if(!square.getPiece().isFriendly(this.piece)) {
                super.add(square);
            }
            return !square.isEmpty();
        }
        return true;
    }
}
