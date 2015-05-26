package fi.monkeyball.chezz;

import fi.monkeyball.chezz.domain.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by juho on 5/24/15.
 */
public class Cli {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        ChessBoard chessBoard = ChessBoardFactory.gameStart();
        chessBoard.placePiece(new Rook(Piece.Color.BLACK), ChessBoard.COLUMN.D, ChessBoard.ROW._5);
        MoveSet possibleMoves = chessBoard.moveSet(ChessBoard.ROW._5, ChessBoard.COLUMN.D);
        System.out.println(possibleMoves);
        System.out.println(" abcdefgh ");
        List<String> rows = new LinkedList();
        int c = 1;
        for (ChessBoard.RowContainer squares : chessBoard) {
            String row = "" + c;
            for (ChessBoard.Square square : squares) {
                if(possibleMoves.contains(square)) {
                    row += square.isEmpty() ? "'" :
                            getPieceChar(square, true);
                } else {
                    row += square.isEmpty() ? " " :
                            getPieceChar(square, false);
                }
            }
            row += c++;
            rows.add(row);
        }
        Collections.reverse(rows);
        for (String row : rows) {
            System.out.println(row);
        }

        System.out.println(" abcdefgh ");
        System.out.println("");
        System.out.println("' can move here");
        System.out.println("u placeholder piece");
        System.out.println("UPPERCASE capturable");
    }

    private static String getPieceChar(ChessBoard.Square square, boolean capturable) {
        if(square.getPiece() instanceof Rook) {
            return square.getPiece().getColor().equals(Piece.Color.WHITE) ? red("r", capturable) : green("r", capturable);
        }
        if(square.getPiece() instanceof King) {
            return square.getPiece().getColor().equals(Piece.Color.WHITE) ? red("k", capturable) : green("k", capturable);
        }
        if(square.getPiece() instanceof Pawn) {
            return square.getPiece().getColor().equals(Piece.Color.WHITE) ? red("p", capturable) : green("p", capturable);
        }
        return square.getPiece().getColor().equals(Piece.Color.WHITE) ? red("u", capturable) : green("u", capturable);
    }

    private static String green(String character, boolean capturable) {
        if(capturable) {
            return ANSI_GREEN + character.toUpperCase() + ANSI_RESET;
        } else {
            return ANSI_GREEN + character + ANSI_RESET;
        }
    }

    private static String red(String character, boolean capturable) {
        if(capturable) {
            return ANSI_RED + character.toUpperCase() + ANSI_RESET;
        } else {
            return ANSI_RED + character + ANSI_RESET;
        }
    }

}
