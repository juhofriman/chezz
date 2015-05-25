package fi.monkeyball.chezz.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by juho on 5/25/15.
 */
public class Pawn extends Piece {

    private boolean atStartingLocation = true;

    public Pawn(Color color) {
        super(color);
    }

    @Override
    protected Set<ChessBoard.Square> allMovesOfThisPiece(ChessBoard chessBoard, ChessBoard.Square location) {
        HashSet<ChessBoard.Square> moveSet = new HashSet();
        if(this.getColor().equals(Color.WHITE)) {
            moveSet.add(chessBoard.squareAt(location.getRow().next(), location.getColumn()));
            if (this.atStartingLocation(location)) {
                moveSet.add(chessBoard.squareAt(location.getRow().next().next(), location.getColumn()));
            }
            if(atTableAndContainsEnemy(chessBoard.squareAt(location.getRow().next(), location.getColumn().next()))) {
                moveSet.add(chessBoard.squareAt(location.getRow().next(), location.getColumn().next()));
            }
            if(atTableAndContainsEnemy(chessBoard.squareAt(location.getRow().next(), location.getColumn().previous()))) {
                moveSet.add(chessBoard.squareAt(location.getRow().next(), location.getColumn().previous()));
            }
        } else {
            moveSet.add(chessBoard.squareAt(location.getRow().previous(), location.getColumn()));
            if (this.atStartingLocation(location)) {
                moveSet.add(chessBoard.squareAt(location.getRow().previous().previous(), location.getColumn()));
            }
            if(atTableAndContainsEnemy(chessBoard.squareAt(location.getRow().previous(), location.getColumn().next()))) {
                moveSet.add(chessBoard.squareAt(location.getRow().previous(), location.getColumn().next()));
            }
            if(atTableAndContainsEnemy(chessBoard.squareAt(location.getRow().previous(), location.getColumn().previous()))) {
                moveSet.add(chessBoard.squareAt(location.getRow().previous(), location.getColumn().previous()));
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
