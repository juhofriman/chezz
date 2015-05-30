package fi.monkeyball.chezz.domain;

/**
 * Created by juho on 30/05/15.
 */
public class ChessBoardBuilderException extends RuntimeException {
    public ChessBoardBuilderException(String message, Exception cause) {
        super(message, cause);
    }
}
