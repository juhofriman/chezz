package fi.monkeyball.chezz.domain;

/**
 * Created by juho on 27/05/15.
 */
public class Move {
    public static final Move GIVEUP = new Move(null, null) {
    };
    private final ChessBoard.Square from;
    private final ChessBoard.Square to;

    public Move(ChessBoard.Square from, ChessBoard.Square to) {
        this.from = from;
        this.to = to;
    }

    public ChessBoard.Square from() {
        return from;
    }

    public ChessBoard.Square to() {
        return to;
    }
}
