package fi.monkeyball.chezz;

import fi.monkeyball.chezz.domain.ChessBoard;
import fi.monkeyball.chezz.domain.ChessBoardFactory;
import fi.monkeyball.chezz.domain.God;

import java.util.Set;

/**
 * Created by juho on 5/24/15.
 */
public class Cli {

    public static void main(String[] args) {
        ChessBoard chessBoard = ChessBoardFactory.gameStart();

        chessBoard.placePiece(new God(), ChessBoard.ROW._5, ChessBoard.COLUMN.D);
        Set<ChessBoard.Square> possibleMoves = chessBoard.moveSet(ChessBoard.ROW._5, ChessBoard.COLUMN.D);

        System.out.println(" abcdefgh ");
        int c = 8;
        for (ChessBoard.Row squares : chessBoard) {
            System.out.print(c);
            for (ChessBoard.Square square : squares) {
                if(possibleMoves.contains(square)) {
                    System.out.print(square.isEmpty() ? "'" : "E");
                } else {
                    System.out.print(square.isEmpty() ? " " : "*");
                }
            }
            System.out.println(c--);
        }
        System.out.println(" abcdefgh ");
        System.out.println("");
        System.out.println("' can move here");
        System.out.println("E contains pieve and can knock");
        System.out.println("* contains piece");

    }

}
