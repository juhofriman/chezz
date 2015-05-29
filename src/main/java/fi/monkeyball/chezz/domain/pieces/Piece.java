package fi.monkeyball.chezz.domain.pieces;

import fi.monkeyball.chezz.domain.ChessBoard;

public abstract class Piece {

    public enum Color {
        WHITE, BLACK;

    }

    private Color color;
    public Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public boolean isFriendly(Piece another) {
        return getColor().equals(another.getColor());
    }

    public final MoveSet movesFrom(ChessBoard chessBoard, ChessBoard.Square location) {
        MoveSet squares = new MoveSet(this);
        registerMovesOfThisPiece(squares, chessBoard, location);
        return squares;
    }

    protected abstract void registerMovesOfThisPiece(MoveSet moveSet, ChessBoard chessBoard, ChessBoard.Square location);

    /**
     * Rook moves are used for Rook but Queen as well, Hence it's here.
     *
     * @param moveSet
     * @param chessBoard
     * @param location
     */
    protected void registerRookMoves(MoveSet moveSet, ChessBoard chessBoard, ChessBoard.Square location) {
        ChessBoard.ROW row = location.getRow();
        boolean blocks = false;
        while(!blocks) {
            blocks = moveSet.addIfOnBoard(chessBoard.squareAt(row.north(), location.getColumn()));
            row = row.north();
        }

        row = location.getRow();
        blocks = false;
        while(!blocks) {
            blocks = moveSet.addIfOnBoard(chessBoard.squareAt(row.south(), location.getColumn()));
            row = row.south();
        }

        ChessBoard.COLUMN column = location.getColumn();
        blocks = false;
        while(!blocks) {
            blocks = moveSet.addIfOnBoard(chessBoard.squareAt(location.getRow(), column.east()));
            column = column.east();
        }

        column = location.getColumn();
        blocks = false;
        while(!blocks) {
            blocks = moveSet.addIfOnBoard(chessBoard.squareAt(location.getRow(), column.west()));
            column = column.west();
        }
    }

    /**
     * Bishop moves are used by bishop and it's a super set of queen moves
     *
     * @param moveSet
     * @param chessBoard
     * @param location
     */
    protected void registerBishopMoves(MoveSet moveSet, ChessBoard chessBoard, ChessBoard.Square location) {
        ChessBoard.ROW row = location.getRow();
        ChessBoard.COLUMN column = location.getColumn();
        boolean blocks = false;
        while(!blocks) {
            blocks = moveSet.addIfOnBoard(chessBoard.squareAt(row.north(), column.east()));
            row = row.north();
            column = column.east();
        }

        row = location.getRow();
        column = location.getColumn();
        blocks = false;
        while(!blocks) {
            blocks = moveSet.addIfOnBoard(chessBoard.squareAt(row.north(), column.west()));
            row = row.north();
            column = column.west();
        }

        row = location.getRow();
        column = location.getColumn();
        blocks = false;
        while(!blocks) {
            blocks = moveSet.addIfOnBoard(chessBoard.squareAt(row.south(), column.east()));
            row = row.south();
            column = column.east();
        }

        row = location.getRow();
        column = location.getColumn();
        blocks = false;
        while(!blocks) {
            blocks = moveSet.addIfOnBoard(chessBoard.squareAt(row.south(), column.west()));
            row = row.south();
            column = column.west();
        }
    }
}
