package fi.monkeyball.chezz.domain;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;

import java.util.Collections;
import java.util.Set;

public abstract class Piece {

    public enum Color {
        WHITE, BLACK
    }

    private Color color;

    public Piece(Color color) {
        this.color = color;
    }

    public final Set<ChessBoard.Square> movesFrom(ChessBoard chessBoard, ChessBoard.Square location) {
        return Sets.filter(allMovesOfThisPiece(chessBoard, location), new Predicate<ChessBoard.Square>() {
            @Override
            public boolean apply(ChessBoard.Square square) {
                if(square.isEmpty()) {
                    return true;
                }
                return !square.getPiece().getColor().equals(getColor());
            }
        });
    }

    /**
     * This must return all possible moves for piece. Friendlies are removed at superclass
     *
     * @param chessBoard
     * @param location
     * @return
     */
    protected abstract Set<ChessBoard.Square> allMovesOfThisPiece(ChessBoard chessBoard, ChessBoard.Square location);

    public Color getColor() {
        return color;
    }
}
