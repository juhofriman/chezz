package fi.monkeyball.chezz.domain.pieces;

import fi.monkeyball.chezz.domain.ChessBoard;
import fi.monkeyball.chezz.domain.pieces.Piece;
import org.junit.Before;

import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


/**
 * Created by juho on 5/24/15.
 */
public abstract class PieceTests {

    private String actor;

    @Before
    public void setUp() {
        this.actor = getActor();
    }

    protected abstract String getActor();

    protected void assertDoesNotContainFriendlies(Set<ChessBoard.Square> kingMoveSet, Piece.Color friendly) {
        for (ChessBoard.Square square : kingMoveSet) {
            if(!square.isEmpty() && square.getPiece().getColor().equals(friendly)) {
                fail("A good " + actor + " does not eat its owns! " + square + " in move set");
            }
        }

    }

    protected void containsSquare(Set<ChessBoard.Square> moveSet, ChessBoard.Square square) {
        assertTrue("Moveset for '" + actor + "' " + moveSet + " did not contain expected square " + square,
                moveSet.contains(square));
    }

    protected void doesNotContainSquare(Set<ChessBoard.Square> moveSet, ChessBoard.Square square) {
        assertFalse("Moveset for '" + actor + "' " + moveSet + " did contain unexpected square " + square,
                moveSet.contains(square));
    }

}
