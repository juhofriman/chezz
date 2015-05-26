package fi.monkeyball.chezz;

import fi.monkeyball.chezz.domain.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by juho on 5/24/15.
 */
public class Cli {

    public static void main(String[] args) {
        ChessBoard chessBoard = ChessBoardFactory.gameStart();

        chessBoard.placePiece(new God(Piece.Color.BLACK), ChessBoard.ROW._3, ChessBoard.COLUMN.D);
        MoveSet possibleMoves = chessBoard.moveSet(ChessBoard.ROW._3, ChessBoard.COLUMN.D);

        System.out.println(" abcdefgh ");
        List<String> rows = new LinkedList();
        int c = 1;
        for (ChessBoard.RowContainer squares : chessBoard) {
            String row = "" + c;
            for (ChessBoard.Square square : squares) {
                if(possibleMoves.contains(square)) {
                    row += square.isEmpty() ? "'" :
                            square.getPiece().getColor().equals(Piece.Color.WHITE) ? "W" : "B";
                } else {
                    row += square.isEmpty() ? " " :
                            square.getPiece().getColor().equals(Piece.Color.WHITE) ? "w" : "b";
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

}
