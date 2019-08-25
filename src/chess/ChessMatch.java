package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
    Board board;

    public ChessMatch() {
        board = new Board(8, 8);
        initialSetup();
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

    private void initialSetup(){
        board.placePiece(new Rook(board, Color.WHITE), new Position(3, 4));
        board.placePiece(new King(board, Color.BLACK), new Position(4, 3));
        

    }
}
