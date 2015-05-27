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
        currentTurn = Piece.Color.WHITE;
        chessBoard = ChessBoardFactory.emptyBoard();
    }

    public ChessBoard board() {
        return new ChessBoard();
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
