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
    protected void registerMovesOfThisPiece(MoveSet moveSet, ChessBoard chessBoard, ChessBoard.Square location) {
        for (ChessBoard.Row row : chessBoard) {
            for (ChessBoard.Square square : row) {
                if(square != location) {
                    moveSet.addIfOnBoard(square);
                }
            }
        }
    }
}
