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

    public void addIfOnBoard(ChessBoard.Square square) {
        if(square != null) {
            if(square.isEmpty()) {
                super.add(square);
            } else if(!square.getPiece().getColor().equals(this.piece.getColor())) {
                super.add(square);
            }
        }
    }
}
