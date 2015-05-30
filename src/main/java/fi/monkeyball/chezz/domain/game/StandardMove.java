package fi.monkeyball.chezz.domain.game;

import fi.monkeyball.chezz.domain.ChessBoard;


/**
 * Created by juho on 30/05/15.
 */
public class StandardMove implements Move {

    private final ChessBoard.Square from;
    private final ChessBoard.Square to;
    private final boolean isCapture;

    public StandardMove(ChessBoard.Square from, ChessBoard.Square to) {
        this.from = from;
        this.to = to;
        this.isCapture = !to.isEmpty();
    }

    @Override
    public void accept(MoveVisitor moveVisitor) {
        moveVisitor.visit(this);
    }

    public ChessBoard.Square getFrom() {
        return from;
    }

    public ChessBoard.Square getTo() {
        return to;
    }

    public boolean isCapture() {
        return isCapture;
    }
}
