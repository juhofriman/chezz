package fi.monkeyball.chezz;

import fi.monkeyball.chezz.domain.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by juho on 5/27/15.
 */
public class ChezzRepl implements Runnable {


    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


    private GameOfChess gameOfChess = new GameOfChess(ChessBoardFactory.gameStart());
    private ChessBoard.COLUMN fromCol;
    private ChessBoard.ROW fromRow;
    private ChessBoard.COLUMN toCol;
    private ChessBoard.ROW toRow;

    private ChezzRepl() {
        gameOfChess.addMoveHandler(new MoveHandler() {
            @Override
            public Move handleState(ChessBoard chessBoard) {
                return new Move(chessBoard.squareAt(fromCol, fromRow), chessBoard.squareAt(toCol, toRow));
            }
        });

        gameOfChess.addEventHandler(new ChessEventHandler() {
            @Override
            public void onGiveup(Piece.Color loser) {

            }

            @Override
            public void onMove(Piece moved, Move move) {
                System.out.println(moved.getColor() + " " + moved.getClass().getSimpleName() +
                        " moved from " + move.from() + " to " + move.to());
            }

            @Override
            public void onCapture(Piece capturer, Piece captured, Move move) {
                System.out.println(capturer.getColor() + " " + capturer.getClass().getSimpleName() +
                        " CAPTURES " + captured.getColor() + " " + captured.getClass().getSimpleName() +
                " at " + move.to());
            }

        });
    }

    public static void main(String[] args) {
        System.out.println("Welcome to chezz-repl");
        System.out.println();

        new ChezzRepl().run();
    }


    @Override
    public void run() {
        System.out.print("chezz-repl [" + this.gameOfChess.onTurn() + "]> ");
        String input = System.console().readLine();

        try {
            if(input.equals("")) {

            } else if (input.equals("help")) {
                printHelp();
            } else if (input.equals("state")) {
                print(gameOfChess.board());
            } else if (input.startsWith("place")) {
                place(input);
            } else if (input.startsWith("moves")) {
                printMoves(input);
            } else if (input.startsWith("turn")) {
                turn(input);
            } else if (input.equals("quit")) {
                System.out.println("Bye!");
            } else {
                System.out.println("???");
            }

            if (!input.equals("quit")) {
                run();
            }
        } catch (Exception e) {
            System.out.println("No. That does not work");
            System.out.println(e.getMessage());
            run();
        }

    }

    private void turn(String input) {
        String[] split = input.split(" ");
        this.fromCol = getColumn(split[1]);
        this.fromRow = getRow(split[2]);
        this.toCol = getColumn(split[3]);
        this.toRow = getRow(split[4]);
        try {
            gameOfChess.move();
        } catch (ChessBoardException e) {
            System.out.println("That does not work");
            System.out.println(e.getMessage());
        }
    }

    private void printMoves(String input) {
        String[] split = input.split(" ");
        MoveSet possibleMoves = gameOfChess.board().moveSet(gameOfChess.board().squareAt(getColumn(split[1]), getRow(split[2])));

        if (possibleMoves.isEmpty()) {
            System.out.println("No moves");
        } else {
            print(gameOfChess.board(), possibleMoves);
        }
    }

    private void place(String input) {
        String[] split = input.split(" ");
        gameOfChess.board().placePiece(getPiece(split[1], split[2]), gameOfChess.board().squareAt(getColumn(split[3]), getRow(split[4])));
        System.out.println("Placed");
    }

    private Piece getPiece(String colorstr, String piecestr) {
        Piece.Color color = colorstr.toUpperCase().startsWith("W") ? Piece.Color.WHITE : Piece.Color.BLACK;
        if(piecestr.equals("rook")) {
            return new Rook(color);
        }
        if(piecestr.equals("bishob")) {
            return new Bishop(color);
        }
        if(piecestr.equals("queen")) {
            return new Queen(color);
        }
        if(piecestr.equals("king")) {
            return new King(color);
        }
        if(piecestr.equals("knight")) {
            return new Knight(color);
        }
        if(piecestr.equals("pawn")) {
            return new Pawn(color);
        }
        throw new IllegalArgumentException("??? Don't know piece called " + piecestr);
    }

    private ChessBoard.ROW getRow(String s) {
        return ChessBoard.ROW.valueOf("_" + s);
    }

    private ChessBoard.COLUMN getColumn(String string) {
        return ChessBoard.COLUMN.valueOf(string.toUpperCase());
    }

    private static void print(ChessBoard chessBoard) {
        print(chessBoard, MoveSet.EMPTY);
    }

    private static void print(ChessBoard chessBoard, MoveSet possibleMoves) {

        List<String> rows = new LinkedList();
        int c = 1;
        for (ChessBoard.RowContainer squares : chessBoard) {
            String row = "" + c;
            for (ChessBoard.Square square : squares) {
                if(possibleMoves.contains(square)) {
                    row += square.isEmpty() ? "*" :
                            getPieceChar(square, true);
                } else {
                    row += square.isEmpty() ? "-" :
                            getPieceChar(square, false);
                }
            }
            row += c++;
            rows.add(row);
        }
        System.out.println(" abcdefgh ");
        Collections.reverse(rows);
        for (String row : rows) {
            System.out.println(row);
        }
        System.out.println(" abcdefgh ");
    }

    private static String getPieceChar(ChessBoard.Square square, boolean capturable) {
        if(square.getPiece() instanceof Rook) {
            return square.getPiece().getColor().equals(Piece.Color.WHITE) ? red("r", capturable) : green("r", capturable);
        }
        if(square.getPiece() instanceof King) {
            return square.getPiece().getColor().equals(Piece.Color.WHITE) ? red("k", capturable) : green("k", capturable);
        }
        if(square.getPiece() instanceof Queen) {
            return square.getPiece().getColor().equals(Piece.Color.WHITE) ? red("q", capturable) : green("q", capturable);
        }
        if(square.getPiece() instanceof Knight) {
            return square.getPiece().getColor().equals(Piece.Color.WHITE) ? red("h", capturable) : green("h", capturable);
        }
        if(square.getPiece() instanceof Bishop) {
            return square.getPiece().getColor().equals(Piece.Color.WHITE) ? red("b", capturable) : green("b", capturable);
        }
        if(square.getPiece() instanceof Pawn) {
            return square.getPiece().getColor().equals(Piece.Color.WHITE) ? red("p", capturable) : green("p", capturable);
        }
        return square.getPiece().getColor().equals(Piece.Color.WHITE) ? red("u", capturable) : green("u", capturable);
    }

    private static String green(String character, boolean capturable) {
        if(capturable) {
            return ANSI_PURPLE + character.toUpperCase() + ANSI_RESET;
        } else {
            return ANSI_GREEN + character + ANSI_RESET;
        }
    }

    private static String red(String character, boolean capturable) {
        if(capturable) {
            return ANSI_CYAN + character.toUpperCase() + ANSI_RESET;
        } else {
            return ANSI_RED + character + ANSI_RESET;
        }
    }

    private void printHelp() {
        System.out.println("Chezz Repl");
        System.out.println("help: print this");
        System.out.println("state: print game state");
        System.out.println("quit: obvious");

    }
}
