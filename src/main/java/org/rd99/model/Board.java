package org.rd99.model;

import org.rd99.model.WinningStrategy.RowsDiagonalsWin;

public class Board {
    public int size;
    public PlayingPiece[][] gameBoard;
    private RowsDiagonalsWin rowsDiagonalsWin;

    Board(int size){
        this.size = size;
        gameBoard = new PlayingPiece[size][size];
        rowsDiagonalsWin = new RowsDiagonalsWin();
    }
    public boolean addPiece (int row, int column , PlayingPiece playingPiece){
        if(gameBoard[row][column] != null){
            return false;
            //throw new PieceAlreadyExistsException();
        }
        gameBoard[row][column] = playingPiece;
        return true;
    }

    public void printBoard(){
        for(int i=0 ; i<size; i ++){
            StringBuilder s = new StringBuilder();
            for (int j = 0;j < size; j ++){
                if(gameBoard[i][j] == null){
                    s.append("_");
                    continue;
                }
                if(gameBoard[i][j].pieceType == PieceType.X){
                    s.append("X");
                }
                else if (gameBoard[i][j].pieceType == PieceType.O){
                    s.append("O");
                }
            }
            System.out.println(s.toString());
        }
    }

    public boolean didPlayerWin(Player playerTurn , Board board) {
        return rowsDiagonalsWin.didPlayerWinGame(playerTurn , board);
    }

    public boolean isBoardFull(){
        for (int i = 0;i < size; i++ ){
        for (int j = 0;j < size; j++ ){
            if(gameBoard[i][j] == null){
                return false;
            }
        }
    }
        return true;
}
}
