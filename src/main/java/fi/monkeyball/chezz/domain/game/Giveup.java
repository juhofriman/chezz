package fi.monkeyball.chezz.domain.game;

import fi.monkeyball.chezz.domain.pieces.Piece;

/**
 * Created by juho on 30/05/15.
 */
public class Giveup implements Move {
    public Giveup(Piece.Color playerWhoGaveUp) {
    }

    @Override
    public void accept(MoveVisitor moveVisitor) {
        moveVisitor.visit(this);
    }
}
