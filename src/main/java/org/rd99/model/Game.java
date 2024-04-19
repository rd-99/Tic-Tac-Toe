package org.rd99.model;

import javafx.util.Pair;

import java.security.PublicKey;
import java.util.Deque;
import java.util.Scanner;

public class Game {

    public Board board;
    Deque<Player> players;
    Game(int size){
        this.board = new Board(size);
    }
    public void initializeGame(){
        Player player1 = new Player("Rutu" , new PlayingPiece(PieceType.X));
        Player player2 = new Player("Kshitija" , new PlayingPiece(PieceType.O));
        players.add(player1);
        players.add(player2);
    }
    public  boolean startGame(){
        boolean isWinnerDeclared = false;
        while(!isWinnerDeclared){
            Player playerTurn = players.removeFirst();
            System.out.println("the current position - ");
            board.printBoard();
            System.out.printf("it's %s turn", playerTurn.name);
            Scanner scanner = new Scanner(System.in);
            String[] move = scanner.nextLine().split(",");
            Integer i = Integer.parseInt(move[0]);
            Integer j = Integer.parseInt((move[1]));
            if(board.addPiece(i,j,playerTurn.playingPiece)){

            }else{
                System.out.println("Enter proper params mf.");
                players.addFirst(playerTurn);
            }



        }
    return true;
    }

}
