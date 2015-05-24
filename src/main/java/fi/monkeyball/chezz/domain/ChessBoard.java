package fi.monkeyball.chezz.domain;

import java.util.ArrayList;
import java.util.Iterator;

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
        rows.add(new Row());
        rows.add(new Row());
        rows.add(new Row());
        rows.add(new Row());
        rows.add(new Row());
        rows.add(new Row());
        rows.add(new Row());
        rows.add(new Row());
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

    public static class Row implements Iterable<Square> {

        private ArrayList<Square> squares = new ArrayList<Square>(8);

        private Row() {
            squares.add(new Square());
            squares.add(new Square());
            squares.add(new Square());
            squares.add(new Square());
            squares.add(new Square());
            squares.add(new Square());
            squares.add(new Square());
            squares.add(new Square());
        }

        @Override
        public Iterator<Square> iterator() {
            return squares.iterator();
        }
    }

    public static class Square {

        private Piece piece = null;

        private Square() {}

        public boolean isEmpty() {
            return this.piece == null;
        }

        public void setPiece(Piece piece) {
            this.piece = piece;
        }

        public Piece getPiece() {
            return piece;
        }
    }
}
