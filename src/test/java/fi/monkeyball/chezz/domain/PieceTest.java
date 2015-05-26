package fi.monkeyball.chezz.domain;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by juho on 26/05/15.
 */
public class PieceTest {

    @Test
    public void testIsFriendlyForEnemies() {
        Piece white = getDummyPiece(Piece.Color.WHITE);
        Piece black = getDummyPiece(Piece.Color.BLACK);
        assertFalse(white.isFriendly(black));
        assertFalse(black.isFriendly(white));
    }

    @Test
    public void testIsFriendlyForFriends() {
        Piece white  = getDummyPiece(Piece.Color.WHITE);
        Piece anotherWhite  = getDummyPiece(Piece.Color.WHITE);
        assertTrue(white.isFriendly(anotherWhite));
        assertTrue(anotherWhite.isFriendly(white));

        Piece black  = getDummyPiece(Piece.Color.BLACK);
        Piece anotherBlack  = getDummyPiece(Piece.Color.BLACK);
        assertTrue(black.isFriendly(anotherBlack));
        assertTrue(anotherBlack.isFriendly(black));
    }

    private Piece getDummyPiece(final Piece.Color color) {
        return new Piece(color) {
            @Override
            protected void registerMovesOfThisPiece(MoveSet moveSet, ChessBoard chessBoard, ChessBoard.Square location) {

            }
        };
    }
}
