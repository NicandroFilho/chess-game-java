package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {

    private Color color;
    private int moveCount;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    ChessPosition getChessPosition(){
        return ChessPosition.fromPosition(position);
    }

    public int getMoveCount(){
        return moveCount;
    }

    void increaseMoveCount(){
        moveCount++;
    }

    void decreaseMoveCount(){
        moveCount--;
    }

    protected boolean isThereOpponentPiece(Position position){
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p != null && p.getColor() != color;
    }
}
