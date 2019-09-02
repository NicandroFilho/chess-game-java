package boardgame;

public abstract class Piece {

    protected Position position;
    private Board board;


    public Piece(Board board) {
        this.board = board;
        //position = null; /*By default 'position' will receive null. We don't need to declare*/
    }

    /**
     * Return the Board Object in which the Piece is set.
     * The method is Protected, only visible by the Board and the Subclasses of Piece.
     *
     * @return  The board from which the piece is set.
     * @see Board*/
    protected Board getBoard() {
        return board;
    }

    public abstract boolean[][] possibleMoves();

    public boolean possibleMove(Position position){
        return possibleMoves()[position.getRow()][position.getColumn()];
    }


    public boolean isThereAnyPossibleMove(){

        boolean[][] mat = possibleMoves();
        for (boolean[] booleans : mat) {
            for (boolean aBoolean : booleans) {
                if (aBoolean) {
                    return true;
                }
            }
        }
        return false;
    }
}
