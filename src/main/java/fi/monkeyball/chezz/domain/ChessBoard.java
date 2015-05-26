package fi.monkeyball.chezz.domain;

import java.util.*;

/**
 * Created by juho on 5/24/15.
 */
public class ChessBoard implements Iterable<ChessBoard.RowContainer> {

    public static final Square OUT_OF_BOARD = new Square(null, null, null);

    public static enum ROW {

        OUT(-1),
        _1(0), _2(1), _3(2), _4(3), _5(4), _6(5), _7(6), _8(7);

        private int index;

        ROW(int index) {
            this.index = index;
        }

        public ROW north() {
            switch(this) {
                case _1: return _2;
                case _2: return _3;
                case _3: return _4;
                case _4: return _5;
                case _5: return _6;
                case _6: return _7;
                case _7: return _8;
                default: return OUT;
            }
        }

        public ROW south() {
            switch(this) {
                case _2: return _1;
                case _3: return _2;
                case _4: return _3;
                case _5: return _4;
                case _6: return _5;
                case _7: return _6;
                case _8: return _7;
                default: return OUT;
            }
        }

    }
    public static enum COLUMN {

        OUT(-1),
        A(0), B(1), C(2), D(3), E(4), F(5), G(6), H(7);
        private int index;

        COLUMN(int index) {
            this.index = index;
        }

        public COLUMN east() {
            switch(this) {
                case A: return B;
                case B: return C;
                case C: return D;
                case D: return E;
                case E: return F;
                case F: return G;
                case G: return H;
                default: return OUT;
            }
        }

        public COLUMN west() {
            switch(this) {
                case B: return A;
                case C: return B;
                case D: return C;
                case E: return D;
                case F: return E;
                case G: return F;
                case H: return G;
                default: return OUT;
            }
        }

    }
    private ArrayList<RowContainer> rowContainers = new ArrayList<RowContainer>(8);

    public ChessBoard() {
        rowContainers.add(new RowContainer(this, ROW._1));
        rowContainers.add(new RowContainer(this, ROW._2));
        rowContainers.add(new RowContainer(this, ROW._3));
        rowContainers.add(new RowContainer(this, ROW._4));
        rowContainers.add(new RowContainer(this, ROW._5));
        rowContainers.add(new RowContainer(this, ROW._6));
        rowContainers.add(new RowContainer(this, ROW._7));
        rowContainers.add(new RowContainer(this, ROW._8));
    }

    @Override
    public Iterator<RowContainer> iterator() {
        return rowContainers.iterator();
    }

    public void move(Square from, Square to) {
        assertSquareBelongsToThisChessBoard(from);
        assertSquareBelongsToThisChessBoard(to);
        if(from.isEmpty()) {
            throw new ChessBoardException("Can't move " + from + " because it's empty");
        }
        MoveSet squares = this.moveSet(from);
        if(!squares.contains(to)) {
            throw new ChessBoardException("Can't move " + from + " to " + to);
        }
        to.setPiece(from.getPiece());
        from.setPiece(null);
    }

    /**
     * Returns set of allowed moves from this square
     *
     * @param square
     * @return
     */
    public MoveSet moveSet(Square square) {
        assertSquareBelongsToThisChessBoard(square);
        if(square.isEmpty()) {
            return MoveSet.EMPTY;
        }
        return square.getPiece().movesFrom(this, square);
    }

    /**
     * Returns Square at certain chessboard location
     *
     * @param column
     * @param row
     * @return
     */
    public Square squareAt(COLUMN column, ROW row) {
        return this.squareAt(row, column);
    }

    /**
     * Returns Square at certain chessboard location
     *
     * @param column
     * @param row
     * @return
     */
    public Square squareAt(ROW row, COLUMN column) {
        if(row == ROW.OUT || column == COLUMN.OUT) {
            return  OUT_OF_BOARD;
        }
        return this.rowContainers.get(row.index).squares.get(column.index);
    }

    /**
     * Places Piece at Square
     *
     * @param piece
     * @param square
     */
    public void placePiece(Piece piece, Square square) {
        assertSquareBelongsToThisChessBoard(square);
        square.setPiece(piece);
    }

    private void assertSquareBelongsToThisChessBoard(Square square) {
        if(square.parent != this) {
            throw new IllegalSquareReferenceException("Accessing Square of parent " + square.parent + " from chessboard " + this);
        }
    }

    public static class RowContainer implements Iterable<Square> {

        private final ROW row;
        private ArrayList<Square> squares = new ArrayList<Square>(8);

        private RowContainer(ChessBoard parent, ROW row) {
            this.row = row;
            squares.add(new Square(parent, row, COLUMN.A));
            squares.add(new Square(parent, row, COLUMN.B));
            squares.add(new Square(parent, row, COLUMN.C));
            squares.add(new Square(parent, row, COLUMN.D));

            squares.add(new Square(parent, row, COLUMN.E));
            squares.add(new Square(parent, row, COLUMN.F));
            squares.add(new Square(parent, row, COLUMN.G));
            squares.add(new Square(parent, row, COLUMN.H));
        }

        public ROW getRow() {
            return row;
        }

        @Override
        public Iterator<Square> iterator() {
            return squares.iterator();
        }
    }

    public static class Square {

        private final ROW row;
        private final COLUMN column;
        private final ChessBoard parent;

        private Piece piece = null;

        private Square(ChessBoard parent, ROW row, COLUMN column) {
            this.parent = parent;
            this.row = row;
            this.column = column;
        }

        public boolean isEmpty() {
            return this.piece == null;
        }

        public void setPiece(Piece piece) {
            this.piece = piece;
        }

        public Piece getPiece() {
            return piece;
        }

        public ROW getRow() {
            return row;
        }

        public COLUMN getColumn() {
            return column;
        }

        @Override
        public String toString() {
            return column.toString() + row.toString();
        }
    }
}
