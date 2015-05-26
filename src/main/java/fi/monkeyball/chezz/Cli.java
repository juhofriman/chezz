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
        ChessBoard chessBoard = ChessBoardFactory.emptyBoard();
        chessBoard.placePiece(new Pawn(Piece.Color.WHITE), ChessBoard.ROW._2, ChessBoard.COLUMN.A);
        chessBoard.placePiece(new Rock(Piece.Color.WHITE), ChessBoard.ROW._3, ChessBoard.COLUMN.A);

        chessBoard.placePiece(new Pawn(Piece.Color.BLACK), ChessBoard.ROW._7, ChessBoard.COLUMN.A);
        chessBoard.placePiece(new Rock(Piece.Color.BLACK), ChessBoard.ROW._6, ChessBoard.COLUMN.A);
        MoveSet possibleMoves = chessBoard.moveSet(ChessBoard.ROW._2, ChessBoard.COLUMN.A);

        System.out.println(" abcdefgh ");
        List<String> rows = new LinkedList();
        int c = 1;
        for (ChessBoard.RowContainer squares : chessBoard) {
            String row = "" + c;
            for (ChessBoard.Square square : squares) {
                if(possibleMoves.contains(square)) {
                    row += square.isEmpty() ? "'" :
                            square.getPiece().getColor().equals(Piece.Color.WHITE) ? red("W") : green("B");
                } else {
                    row += square.isEmpty() ? " " :
                            square.getPiece().getColor().equals(Piece.Color.WHITE) ? red("w") : green("b");
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
        System.out.println("w contains white piece");
        System.out.println("b contains black piece");
        System.out.println("W contains white piece for capturing");
        System.out.println("B contains black piece for capturing");
    }

    private static String green(String character) {
        return ANSI_GREEN + character + ANSI_RESET;
    }

    private static String red(String character) {
        return ANSI_RED + character + ANSI_RESET;
    }

}
