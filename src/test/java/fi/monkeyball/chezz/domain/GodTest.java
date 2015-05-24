package fi.monkeyball.chezz.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by juho on 5/24/15.
 */
public class GodTest {

    @Test
    public void testGodMoves() {
        ChessBoard chessBoard = ChessBoardFactory.emptyBoard();
        chessBoard.placePiece(new God(), ChessBoard.ROW._1, ChessBoard.COLUMN.F);
        assertFalse("God can move ANYTIME", chessBoard.moveSet(ChessBoard.ROW._1, ChessBoard.COLUMN.F).isEmpty());
        assertEquals("God can move ANYWHERE", 63, chessBoard.moveSet(ChessBoard.ROW._1, ChessBoard.COLUMN.F).size());
    }
}
