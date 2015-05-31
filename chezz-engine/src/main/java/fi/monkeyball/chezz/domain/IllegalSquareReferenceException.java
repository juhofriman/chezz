package fi.monkeyball.chezz.domain;

/**
 * Created by juho on 5/26/15.
 */
public class IllegalSquareReferenceException extends ChessBoardException {
    public IllegalSquareReferenceException(String message) {
        super(message);
    }
}
