package fi.monkeyball.chezz.domain;

/**
 * Created by juho on 27/05/15.
 */
public class GameOfChess {

    private Piece.Color currentTurn;
    private MoveHandler moveHandler;
    private ChessEventHandler chessEventHandler;
    private final ChessBoard chessBoard;

    public GameOfChess() {
        this(ChessBoardFactory.gameStart());
    }

    public GameOfChess(ChessBoard chessBoard) {
        this.currentTurn = Piece.Color.WHITE;
        this.chessBoard = chessBoard;
    }

    public ChessBoard board() {
        return this.chessBoard;
    }

    public Piece.Color onTurn() {
        return this.currentTurn;
    }

    public Piece.Color nextMove() {
        return currentTurn;
    }

    public void move() {
        if(moveHandler != null) {
            // Nnononononononon nooot like this
            Move move = moveHandler.handleState(this.chessBoard);
            if(move == Move.GIVEUP) {
                chessEventHandler.onGiveup(currentTurn);
            } else {
                if(!move.from().getPiece().getColor().equals(currentTurn)) {
                    throw new ChessBoardException("Can't move because not turn of " + move.from().getPiece().getColor());
                }

                if(move.to().isEmpty()) {
                    chessBoard.move(move.from(), move.to());
                    chessEventHandler.onMove(chessBoard.squareAt(move.to().getColumn(), move.to().getRow()).getPiece(),
                            move);
                } else {
                    Piece captured = move.to().getPiece();
                    Piece capturer = move.from().getPiece();

                    chessBoard.move(move.from(), move.to());
                    chessEventHandler.onCapture(capturer, captured, move);
                }
            }
        }
        if(this.currentTurn == Piece.Color.WHITE) {
            currentTurn = Piece.Color.BLACK;
        } else {
            currentTurn = Piece.Color.WHITE;
        }

    }

    public void addMoveHandler(MoveHandler moveHandler) {
        this.moveHandler = moveHandler;
    }

    public void addEventHandler(ChessEventHandler chessEventHandler) {
        this.chessEventHandler = chessEventHandler;
    }


}
