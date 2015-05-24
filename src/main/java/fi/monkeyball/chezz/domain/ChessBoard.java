package fi.monkeyball.chezz.domain;

import java.util.*;

/**
 * Created by juho on 5/24/15.
 */
public class ChessBoard implements Iterable<ChessBoard.Row> {

    public enum ROW {

        _1(0), _2(1), _3(2), _4(3), _5(4), _6(5), _7(6), _8(7);

        private int index;

        ROW(int index) {
            this.index = index;
        }
    }
    public enum COLUMN {

        A(0), B(1), C(2), D(3), E(4), F(5), G(6), H(7);

        private int index;

        COLUMN(int index) {
            this.index = index;
        }
    }

    private ArrayList<Row> rows = new ArrayList<Row>(8);

    public ChessBoard() {
        rows.add(new Row(ROW._1));
        rows.add(new Row(ROW._2));
        rows.add(new Row(ROW._3));
        rows.add(new Row(ROW._4));
        rows.add(new Row(ROW._5));
        rows.add(new Row(ROW._6));
        rows.add(new Row(ROW._7));
        rows.add(new Row(ROW._8));
    }

    public Set<Square> moveSet(ROW row, COLUMN f) {
        Square square = squareAt(row, f);
        if(square.isEmpty()) {
            return Collections.emptySet();
        }
        return square.getPiece().movesFrom(this, square);
    }

    @Override
    public Iterator<Row> iterator() {
        return rows.iterator();
    }

    public Square squareAt(ROW row, COLUMN column) {
        return this.rows.get(row.index).squares.get(column.index);
    }

    public void placePiece(Piece piece, ROW row, COLUMN column) {
        squareAt(row, column).setPiece(piece);
    }

    // This should not be "row" because enum is ROW already
    public static class Row implements Iterable<Square> {

        private final ROW row;
        private ArrayList<Square> squares = new ArrayList<Square>(8);

        private Row(ROW row) {
            this.row = row;
            squares.add(new Square(row, COLUMN.A));
            squares.add(new Square(row, COLUMN.B));
            squares.add(new Square(row, COLUMN.C));
            squares.add(new Square(row, COLUMN.D));

            squares.add(new Square(row, COLUMN.E));
            squares.add(new Square(row, COLUMN.F));
            squares.add(new Square(row, COLUMN.G));
            squares.add(new Square(row, COLUMN.H));
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

        private Piece piece = null;

        private Square(ROW row, COLUMN column) {
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
    }
}
