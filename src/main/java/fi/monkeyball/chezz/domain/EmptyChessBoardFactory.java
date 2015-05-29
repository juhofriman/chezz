package fi.monkeyball.chezz.domain;

/**
 * Created by juho on 5/24/15.
 */
public class EmptyChessBoardFactory implements ChessBoardFactory {

    @Override
    public ChessBoard instance() {
        return new ChessBoard();
    }
}
