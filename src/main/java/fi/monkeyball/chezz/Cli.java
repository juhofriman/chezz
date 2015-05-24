package fi.monkeyball.chezz;

import fi.monkeyball.chezz.domain.ChessBoard;
import fi.monkeyball.chezz.domain.ChessBoardFactory;

/**
 * Created by juho on 5/24/15.
 */
public class Cli {

    public static void main(String[] args) {
        ChessBoard chessBoard = ChessBoardFactory.gameStart();
        System.out.println(" abcdefgh ");
        int c = 8;
        for (ChessBoard.Row squares : chessBoard) {
            System.out.print(c);
            for (ChessBoard.Square square : squares) {
                System.out.print(square.isEmpty() ? " " : "*");
            }
            System.out.println(c--);
        }
        System.out.println(" abcdefgh ");

    }

}
