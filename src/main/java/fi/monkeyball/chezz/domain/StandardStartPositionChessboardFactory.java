package fi.monkeyball.chezz.domain;

import fi.monkeyball.chezz.domain.pieces.*;

/**
 * Created by juho on 29/05/15.
 */
public class StandardStartPositionChessboardFactory implements ChessBoardFactory {

    @Override
    public ChessBoard instance() {
        ChessBoard chessBoard = new ChessBoard();

        chessBoard.placePiece(new Rook(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._1, ChessBoard.COLUMN.A));
        chessBoard.placePiece(new Knight(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._1, ChessBoard.COLUMN.B));
        chessBoard.placePiece(new Bishop(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._1, ChessBoard.COLUMN.C));
        chessBoard.placePiece(new King(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._1, ChessBoard.COLUMN.D));
        chessBoard.placePiece(new Queen(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._1, ChessBoard.COLUMN.E));
        chessBoard.placePiece(new Bishop(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._1, ChessBoard.COLUMN.F));
        chessBoard.placePiece(new Knight(Piece.Color.WHITE), chessBoard.squareAt(ChessBoard.ROW._1, ChessBoard.COLUMN.G));
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
        chessBoard.placePiece(new Knight(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.ROW._8, ChessBoard.COLUMN.B));
        chessBoard.placePiece(new Bishop(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.ROW._8, ChessBoard.COLUMN.C));
        chessBoard.placePiece(new King(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.ROW._8, ChessBoard.COLUMN.D));
        chessBoard.placePiece(new Queen(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.ROW._8, ChessBoard.COLUMN.E));
        chessBoard.placePiece(new Bishop(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.ROW._8, ChessBoard.COLUMN.F));
        chessBoard.placePiece(new Knight(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.ROW._8, ChessBoard.COLUMN.G));
        chessBoard.placePiece(new Rook(Piece.Color.BLACK), chessBoard.squareAt(ChessBoard.ROW._8, ChessBoard.COLUMN.H));

        return chessBoard;
    }
}
