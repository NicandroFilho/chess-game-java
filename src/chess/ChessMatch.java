package chess;

import boardgame.Board;

public class ChessMatch {
    Board board;

    public ChessMatch() {
        board = new Board(8, 8);
    }

    public ChessPiece[][] getPieces(){
        ChessPiece[][] matrix = new ChessPiece[board.getRows()][board.getColumns()];
        for(int row = 0; row < board.getRows(); row++){
            for(int col = 0; col< board.getColumns(); col++){
                matrix[row][col] = (ChessPiece) board.piece(row, col);
            }
        }
        return matrix;
    }
}
