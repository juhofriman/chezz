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

    public final MoveSet movesFrom(ChessBoard chessBoard, ChessBoard.Square location) {
        MoveSet squares = new MoveSet(this);
        registerMovesOfThisPiece(squares, chessBoard, location);
        return squares;
    }

    protected abstract void registerMovesOfThisPiece(MoveSet moveSet, ChessBoard chessBoard, ChessBoard.Square location);

    public Color getColor() {
        return color;
    }
}
