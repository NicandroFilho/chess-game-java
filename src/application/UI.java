package application;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class UI {

    // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

    private static final String ANSI_RESET = "\u001B[0m";
    // private static final String ANSI_BLACK = "\u001B[30m";
    // private static final String ANSI_RED = "\u001B[31m";
    // private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    // private static final String ANSI_BLUE = "\u001B[34m";
    // private static final String ANSI_PURPLE = "\u001B[35m";
    // private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";

    // private static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    // private static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    // private static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    // private static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    // private static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    //private static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    private static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    // private static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    // https://stackoverflow.com/questions/2979383/java-clear-the-console
    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static ChessPosition readChessPosition(Scanner sc){
        try {
            String s = sc.nextLine();
            char column = s.charAt(0);
            int row = Integer.parseInt(s.substring(1));

            return new ChessPosition(column, row);
        }
        catch (RuntimeException e){
            throw new InputMismatchException("Error instantiating ChessPosition: Valid positions are from a1 to h8.");
        }
    }

    static void printMatch(ChessMatch chessMatch, List<ChessPiece> captured) {
        printBoard(chessMatch.getPieces());
        System.out.println();
        printCapturedPieces(captured);
        System.out.println();
        System.out.println("Turn: " + chessMatch.getTurn());

        if (!chessMatch.getCheckMate()) {
            System.out.println("Waiting Player: " + chessMatch.getCurrentPlayer());
            if (chessMatch.getCheck()) {
                System.out.println("CHECK!");
            }
        } else {
            System.out.println("CHECKMATE!");
            System.out.println("The Winner is: " + chessMatch.getCurrentPlayer());
        }
    }

    private static void printBoard(ChessPiece[][] pieces){
        for(int row = 0; row < pieces.length; row++){
            System.out.print(8 - row + " ");
            for(int col = 0; col < pieces[row].length; col++){
                printPiece(pieces[row][col], false);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves){
        for(int row = 0; row < pieces.length; row++){
            System.out.print(8 - row + " ");
            for(int col = 0; col < pieces[row].length; col++){
                printPiece(pieces[row][col], possibleMoves[row][col]);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    private static void printPiece(ChessPiece piece, boolean backGround){
        if(backGround){
            System.out.print(ANSI_CYAN_BACKGROUND);
        }
        if(piece == null){
            System.out.print("-"+ ANSI_RESET);
        }else {
            if (piece.getColor() == Color.WHITE) {
                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
            }
            else {
                System.out.print(ANSI_YELLOW+ piece + ANSI_RESET);
            }
        }
        System.out.print(" "); //Spacing so that the pieces do not stick together.
    }

    private static void printCapturedPieces(List<ChessPiece> captured){
        List<ChessPiece> white = captured.stream().filter(x -> x.getColor() == Color.WHITE).collect(Collectors.toList());
        List<ChessPiece> black = captured.stream().filter(x -> x.getColor() == Color.BLACK).collect(Collectors.toList());

        System.out.println("Captured Pieces: ");
        System.out.print("White: ");
        System.out.print(ANSI_WHITE);
        System.out.println(Arrays.toString(white.toArray()));
        System.out.print(ANSI_RESET);
        System.out.print("Black: ");
        System.out.print(ANSI_YELLOW);
        System.out.println(Arrays.toString(black.toArray()));
        System.out.print(ANSI_RESET);
    }
}
