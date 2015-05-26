package fi.monkeyball.chezz.domain;

/**
 * Created by juho on 5/24/15.
 */
public class ChessBoardFactory {

    public static ChessBoard emptyBoard() {
        return new ChessBoard();
    }

    public static ChessBoard gameStart() {
        ChessBoard chessBoard = new ChessBoard();

        chessBoard.placePiece(new Rook(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._1, ChessBoard.COLUMN.A));
        chessBoard.placePiece(new Rock(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._1, ChessBoard.COLUMN.B));
        chessBoard.placePiece(new Rock(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._1, ChessBoard.COLUMN.C));
        chessBoard.placePiece(new Rock(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._1, ChessBoard.COLUMN.D));
        chessBoard.placePiece(new King(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._1, ChessBoard.COLUMN.E));
        chessBoard.placePiece(new Rock(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._1, ChessBoard.COLUMN.F));
        chessBoard.placePiece(new Rock(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._1, ChessBoard.COLUMN.G));
        chessBoard.placePiece(new Rook(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._1, ChessBoard.COLUMN.H));

        chessBoard.placePiece(new Pawn(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._2, ChessBoard.COLUMN.A));
        chessBoard.placePiece(new Pawn(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._2, ChessBoard.COLUMN.B));
        chessBoard.placePiece(new Pawn(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._2, ChessBoard.COLUMN.C));
        chessBoard.placePiece(new Pawn(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._2, ChessBoard.COLUMN.D));
        chessBoard.placePiece(new Pawn(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._2, ChessBoard.COLUMN.E));
        chessBoard.placePiece(new Pawn(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._2, ChessBoard.COLUMN.F));
        chessBoard.placePiece(new Pawn(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._2, ChessBoard.COLUMN.G));
        chessBoard.placePiece(new Pawn(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._2, ChessBoard.COLUMN.H));


        chessBoard.placePiece(new Pawn(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.ROW._7, ChessBoard.COLUMN.A));
        chessBoard.placePiece(new Pawn(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.ROW._7, ChessBoard.COLUMN.B));
        chessBoard.placePiece(new Pawn(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.ROW._7, ChessBoard.COLUMN.C));
        chessBoard.placePiece(new Pawn(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.ROW._7, ChessBoard.COLUMN.D));
        chessBoard.placePiece(new Pawn(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.ROW._7, ChessBoard.COLUMN.E));
        chessBoard.placePiece(new Pawn(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.ROW._7, ChessBoard.COLUMN.F));
        chessBoard.placePiece(new Pawn(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.ROW._7, ChessBoard.COLUMN.G));
        chessBoard.placePiece(new Pawn(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.ROW._7, ChessBoard.COLUMN.H));

        chessBoard.placePiece(new Rook(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.ROW._8, ChessBoard.COLUMN.A));
        chessBoard.placePiece(new Rock(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.ROW._8, ChessBoard.COLUMN.B));
        chessBoard.placePiece(new Rock(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.ROW._8, ChessBoard.COLUMN.C));
        chessBoard.placePiece(new King(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.ROW._8, ChessBoard.COLUMN.D));
        chessBoard.placePiece(new Rock(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.ROW._8, ChessBoard.COLUMN.E));
        chessBoard.placePiece(new Rock(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.ROW._8, ChessBoard.COLUMN.F));
        chessBoard.placePiece(new Rock(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.ROW._8, ChessBoard.COLUMN.G));
        chessBoard.placePiece(new Rook(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.ROW._8, ChessBoard.COLUMN.H));

        return chessBoard;
    }
}
