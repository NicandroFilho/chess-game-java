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

    public abstract Piece[][] possibleMoves();

    public boolean possibleMove(Position position){
        // TODO: 23/08/2019
        return false;
    }

    public boolean isThereAnyPossibleMove(){
        // TODO: 23/08/2019
        return false;
    }
}
