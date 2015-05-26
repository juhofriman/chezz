package fi.monkeyball.chezz.domain;

public abstract class Piece {

    public enum Color {
        WHITE, BLACK;
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

    public boolean isFriendly(Piece another) {
        return getColor().equals(another.getColor());
    }
}
