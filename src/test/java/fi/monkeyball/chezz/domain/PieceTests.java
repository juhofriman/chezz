package fi.monkeyball.chezz.domain;

import org.junit.Before;

import java.util.Set;

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
        assertTrue("Moveset did not contain expected square " + square, moveSet.contains(square));
    }
}
