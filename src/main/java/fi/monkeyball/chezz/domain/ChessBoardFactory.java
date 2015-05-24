package fi.monkeyball.chezz.domain;

/**
 * Created by juho on 5/24/15.
 */
public class ChessBoardFactory {
    public static ChessBoard initialState() {
        ChessBoard chessBoard = new ChessBoard();

        chessBoard.placePiece(new Piece(), ChessBoard.ROW._1, ChessBoard.COLUMN.A);
        chessBoard.placePiece(new Piece(), ChessBoard.ROW._1, ChessBoard.COLUMN.B);
        chessBoard.placePiece(new Piece(), ChessBoard.ROW._1, ChessBoard.COLUMN.C);
        chessBoard.placePiece(new Piece(), ChessBoard.ROW._1, ChessBoard.COLUMN.D);
        chessBoard.placePiece(new Piece(), ChessBoard.ROW._1, ChessBoard.COLUMN.E);
        chessBoard.placePiece(new Piece(), ChessBoard.ROW._1, ChessBoard.COLUMN.F);
        chessBoard.placePiece(new Piece(), ChessBoard.ROW._1, ChessBoard.COLUMN.G);
        chessBoard.placePiece(new Piece(), ChessBoard.ROW._1, ChessBoard.COLUMN.H);

        chessBoard.placePiece(new Piece(), ChessBoard.ROW._2, ChessBoard.COLUMN.A);
        chessBoard.placePiece(new Piece(), ChessBoard.ROW._2, ChessBoard.COLUMN.B);
        chessBoard.placePiece(new Piece(), ChessBoard.ROW._2, ChessBoard.COLUMN.C);
        chessBoard.placePiece(new Piece(), ChessBoard.ROW._2, ChessBoard.COLUMN.D);
        chessBoard.placePiece(new Piece(), ChessBoard.ROW._2, ChessBoard.COLUMN.E);
        chessBoard.placePiece(new Piece(), ChessBoard.ROW._2, ChessBoard.COLUMN.F);
        chessBoard.placePiece(new Piece(), ChessBoard.ROW._2, ChessBoard.COLUMN.G);
        chessBoard.placePiece(new Piece(), ChessBoard.ROW._2, ChessBoard.COLUMN.H);


        chessBoard.placePiece(new Piece(), ChessBoard.ROW._7, ChessBoard.COLUMN.A);
        chessBoard.placePiece(new Piece(), ChessBoard.ROW._7, ChessBoard.COLUMN.B);
        chessBoard.placePiece(new Piece(), ChessBoard.ROW._7, ChessBoard.COLUMN.C);
        chessBoard.placePiece(new Piece(), ChessBoard.ROW._7, ChessBoard.COLUMN.D);
        chessBoard.placePiece(new Piece(), ChessBoard.ROW._7, ChessBoard.COLUMN.E);
        chessBoard.placePiece(new Piece(), ChessBoard.ROW._7, ChessBoard.COLUMN.F);
        chessBoard.placePiece(new Piece(), ChessBoard.ROW._7, ChessBoard.COLUMN.G);
        chessBoard.placePiece(new Piece(), ChessBoard.ROW._7, ChessBoard.COLUMN.H);

        chessBoard.placePiece(new Piece(), ChessBoard.ROW._8, ChessBoard.COLUMN.A);
        chessBoard.placePiece(new Piece(), ChessBoard.ROW._8, ChessBoard.COLUMN.B);
        chessBoard.placePiece(new Piece(), ChessBoard.ROW._8, ChessBoard.COLUMN.C);
        chessBoard.placePiece(new Piece(), ChessBoard.ROW._8, ChessBoard.COLUMN.D);
        chessBoard.placePiece(new Piece(), ChessBoard.ROW._8, ChessBoard.COLUMN.E);
        chessBoard.placePiece(new Piece(), ChessBoard.ROW._8, ChessBoard.COLUMN.F);
        chessBoard.placePiece(new Piece(), ChessBoard.ROW._8, ChessBoard.COLUMN.G);
        chessBoard.placePiece(new Piece(), ChessBoard.ROW._8, ChessBoard.COLUMN.H);

        return chessBoard;
    }
}
