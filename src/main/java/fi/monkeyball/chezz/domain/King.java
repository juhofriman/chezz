package fi.monkeyball.chezz.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by juho on 5/24/15.
 */
public class King extends Piece {

    public King(Color color) {
        super(color);
    }

    @Override
    public Set<ChessBoard.Square> allMovesOfThisPiece(ChessBoard chessBoard, ChessBoard.Square location) {
        HashSet<ChessBoard.Square> squares = new HashSet<ChessBoard.Square>();

        addIfOnBoard(squares, chessBoard.squareAt(location.getRow(), location.getColumn().east()));
        addIfOnBoard(squares, chessBoard.squareAt(location.getRow(), location.getColumn().west()));
        addIfOnBoard(squares, chessBoard.squareAt(location.getRow().north(), location.getColumn()));
        addIfOnBoard(squares, chessBoard.squareAt(location.getRow().north(), location.getColumn().east()));
        addIfOnBoard(squares, chessBoard.squareAt(location.getRow().north(), location.getColumn().west()));
        addIfOnBoard(squares, chessBoard.squareAt(location.getRow().east(), location.getColumn()));
        addIfOnBoard(squares, chessBoard.squareAt(location.getRow().east(), location.getColumn().east()));
        addIfOnBoard(squares, chessBoard.squareAt(location.getRow().east(), location.getColumn().west()));

        return squares;
    }

    private void addIfOnBoard(HashSet<ChessBoard.Square> squares, ChessBoard.Square square) {
        if(square != null) {
            squares.add(square);
        }
    }
}
