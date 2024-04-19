package org.rd99.model;

import org.rd99.Exception.PieceAlreadyExistsException;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public int size;
    public PlayingPiece[][] gameBoard;

    Board(int size){
        this.size = size;
        gameBoard = new PlayingPiece[size][size];
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
                if(gameBoard[i][j].pieceType == PieceType.X){
                    s.append("X");
                }
                else if (gameBoard[i][j].pieceType == PieceType.O){
                    s.append("O");
                }
                s.append("_");
            }
            System.out.println(s.toString());
        }
    }
}
