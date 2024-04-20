package org.rd99.model;

import javafx.util.Pair;

import java.security.PublicKey;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {

    public Board board;
    Deque<Player> players;
    public Game(int size){
        this.board = new Board(size);
        this.players = new LinkedList<>();
    }
    public void initializeGame(){
        System.out.println("Enter First Player' name : ");
        Scanner playerNameScanner = new Scanner(System.in);
        Player player1 = new Player(playerNameScanner.nextLine() , new PlayingPiece(PieceType.X));
        System.out.println("Enter second player name : ");
        Player player2 = new Player(playerNameScanner.nextLine() , new PlayingPiece(PieceType.O));
        players.add(player1);
        players.add(player2);
    }
    public  void startGame(){
        boolean isWinnerDeclared = false;
        while(!isWinnerDeclared){
            Player playerTurn = players.removeFirst();
            System.out.println("the current position - ");
            board.printBoard();
            System.out.printf("it's %s turn ", playerTurn.name);
            Scanner scanner = new Scanner(System.in);
            String[] move = scanner.nextLine().split(",");
            int i = Integer.parseInt(move[0]);
            int j = Integer.parseInt((move[1]));
            if(i < board.size && i >= 0 && j < board.size && j >=0 &&
                    board.addPiece(i,j,playerTurn.playingPiece)){
                if(board.didPlayerWin(playerTurn , board)){
                    System.out.println(playerTurn.name + "won!");
                    isWinnerDeclared = true;
                }
                if(board.isBoardFull()){
                    System.out.println("Game is a draw!");
                    isWinnerDeclared = true;
                }
                players.add(playerTurn);

            }else{
                System.out.println("Enter proper params mf.");
                players.addFirst(playerTurn);
            }
        }
    }

}
