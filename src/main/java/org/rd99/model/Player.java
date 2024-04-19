package org.rd99.model;

public class Player {
    public String name;
    public PlayingPiece playingPiece;

    Player(String name , PlayingPiece playingPiece){
        this.name = name;
        this.playingPiece = playingPiece;
    }
}
