package fi.monkeyball.chezz.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by juho on 5/24/15.
 */
public class God extends Piece {

    public God(Color color) {
        super(color);
    }

    @Override
    public Set<ChessBoard.Square> allMovesOfThisPiece(ChessBoard chessBoard, ChessBoard.Square location) {
        HashSet<ChessBoard.Square> squares = new HashSet<ChessBoard.Square>();
        for (ChessBoard.Row row : chessBoard) {
            for (ChessBoard.Square square : row) {
                if(square != location) {
                    squares.add(square);
                }
            }
        }

        return squares;
    }
}