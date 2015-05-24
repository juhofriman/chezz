package fi.monkeyball.chezz.domain;

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

    public abstract Set<ChessBoard.Square> movesFrom(ChessBoard chessBoard, ChessBoard.Square location);

    public Color getColor() {
        return color;
    }
}
