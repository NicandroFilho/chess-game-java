package chess.pieces;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
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

        // #Special move castling
        if(getMoveCount() == 0 && !chessMatch.getCheck()){

            //Castling King side Rook
            Position rook1 = new Position(position.getRow(), position.getColumn()+3);
            if(testRookCastling(rook1)){
                Position p1 = new Position(position.getRow(), position.getColumn() +1);
                Position p2 = new Position(position.getRow(), position.getColumn() +2);
                if(!getBoard().thereIsAPiece(p1) && !getBoard().thereIsAPiece(p2)){
                    mat[p2.getRow()][p2.getColumn()] = true;
                }
            }

            //Castling Queen side Rook
            Position rook2 = new Position(position.getRow(), position.getColumn() -4);
            if (testRookCastling(rook2)){
                Position p1 = new Position(position.getRow(), position.getColumn() -1);
                Position p2 = new Position(position.getRow(), position.getColumn() -2);
                Position p3 = new Position(position.getRow(), position.getColumn() -3);
                if (!getBoard().thereIsAPiece(p1) && !getBoard().thereIsAPiece(p2) && !getBoard().thereIsAPiece(p3)){
                    mat[p2.getRow()][p2.getColumn()] = true;
                }
            }
        }

        return mat;
    }

    public boolean canMove(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    private boolean testRookCastling(Position position){
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p != null && p.getMoveCount()==0 && p instanceof Rook && p.getColor() == getColor();
    }



}

