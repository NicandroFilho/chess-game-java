package chess.pieces;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "K";
    }


    @Override
    public boolean[][] possibleMoves() {
        boolean mat[][] = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position pAux = new Position(0, 0);

        //Move North
        pAux.setValues(position.getRow() - 1, position.getColumn());
        if (getBoard().positionExists(pAux) && canMove(pAux)){
            mat[pAux.getRow()][pAux.getColumn()] = true;
        }

        //Move South
        pAux.setValues(position.getRow() + 1, position.getColumn());
        if (getBoard().positionExists(pAux) && canMove(pAux)){
            mat[pAux.getRow()][pAux.getColumn()] = true;
        }

        //Move East
        pAux.setValues(position.getRow(), position.getColumn() + 1);
        if (getBoard().positionExists(pAux) && canMove(pAux)){
            mat[pAux.getRow()][pAux.getColumn()] = true;
        }

        //Move West
        pAux.setValues(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExists(pAux) && canMove(pAux)){
            mat[pAux.getRow()][pAux.getColumn()] = true;
        }

        //Move NE
        pAux.setValues(position.getRow() - 1, position.getColumn() + 1);
        if (getBoard().positionExists(pAux) && canMove(pAux)){
            mat[pAux.getRow()][pAux.getColumn()] = true;
        }

        //Move NW
        pAux.setValues(position.getRow() - 1, position.getColumn() - 1);
        if (getBoard().positionExists(pAux) && canMove(pAux)){
            mat[pAux.getRow()][pAux.getColumn()] = true;
        }

        //Move SW
        pAux.setValues(position.getRow() + 1, position.getColumn() - 1);
        if (getBoard().positionExists(pAux) && canMove(pAux)){
            mat[pAux.getRow()][pAux.getColumn()] = true;
        }

        //Move SE
        pAux.setValues(position.getRow() + 1, position.getColumn() + 1);
        if (getBoard().positionExists(pAux) && canMove(pAux)){
            mat[pAux.getRow()][pAux.getColumn()] = true;
        }





        return mat;
    }

    public boolean canMove(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

}

