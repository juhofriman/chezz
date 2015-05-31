package fi.monkeyball.chezz.domain;

import fi.monkeyball.chezz.domain.pieces.Piece;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by juho on 30/05/15.
 */
public class ChessBoardBuilder {

    private final ChessBoard chessBoard;

    public ChessBoardBuilder() {
        this.chessBoard = new ChessBoard();
    }

    public ChessBoard build() {
        return this.chessBoard;
    }

    public ChessBoardBuilder place(Piece.Color white, Class<? extends Piece> pieceClass, ChessBoard.COLUMN column, ChessBoard.ROW row) {
        try {
            this.chessBoard.placePiece(pieceClass.getConstructor(Piece.Color.class).newInstance(white),
                    chessBoard.squareAt(column, row));
        } catch (InstantiationException e) {
            throw new ChessBoardBuilderException("Can't build " + pieceClass, e);
        } catch (IllegalAccessException e) {
            throw new ChessBoardBuilderException("Can't build " + pieceClass, e);
        } catch (NoSuchMethodException e) {
            throw new ChessBoardBuilderException("Can't build " + pieceClass, e);
        } catch (InvocationTargetException e) {
            throw new ChessBoardBuilderException("Can't build " + pieceClass, e);
        }
        return this;
    }
}
