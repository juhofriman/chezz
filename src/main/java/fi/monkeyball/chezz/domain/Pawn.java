package fi.monkeyball.chezz.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by juho on 5/25/15.
 */
public class Pawn extends Piece {

    public Pawn(Color color) {
        super(color);
    }

    @Override
    protected Set<ChessBoard.Square> allMovesOfThisPiece(ChessBoard chessBoard, ChessBoard.Square location) {
        HashSet<ChessBoard.Square> moveSet = new HashSet();
        if(this.getColor().equals(Color.WHITE)) {
            moveSet.add(chessBoard.squareAt(location.getRow().north(), location.getColumn()));
            if (this.atStartingLocation(location)) {
                moveSet.add(chessBoard.squareAt(location.getRow().north().north(), location.getColumn()));
            }
            if(atTableAndContainsEnemy(chessBoard.squareAt(location.getRow().north(), location.getColumn().east()))) {
                moveSet.add(chessBoard.squareAt(location.getRow().north(), location.getColumn().east()));
            }
            if(atTableAndContainsEnemy(chessBoard.squareAt(location.getRow().north(), location.getColumn().west()))) {
                moveSet.add(chessBoard.squareAt(location.getRow().north(), location.getColumn().west()));
            }
        } else {
            moveSet.add(chessBoard.squareAt(location.getRow().east(), location.getColumn()));
            if (this.atStartingLocation(location)) {
                moveSet.add(chessBoard.squareAt(location.getRow().east().east(), location.getColumn()));
            }
            if(atTableAndContainsEnemy(chessBoard.squareAt(location.getRow().east(), location.getColumn().east()))) {
                moveSet.add(chessBoard.squareAt(location.getRow().east(), location.getColumn().east()));
            }
            if(atTableAndContainsEnemy(chessBoard.squareAt(location.getRow().east(), location.getColumn().west()))) {
                moveSet.add(chessBoard.squareAt(location.getRow().east(), location.getColumn().west()));
            }
        }
        return moveSet;
    }

    private boolean atTableAndContainsEnemy(ChessBoard.Square square) {
        if(square == null || square.isEmpty()) {
            return false;
        }
        return !square.getPiece().getColor().equals(this.getColor());
    }

    private boolean atStartingLocation(ChessBoard.Square location) {
        // TODO: we need "service" for retrieving moves? It could be mocked at tests.
        return getColor().equals(Color.WHITE) ?
                location.getRow().equals(ChessBoard.ROW._2) :
                location.getRow().equals(ChessBoard.ROW._7);
    }
}
