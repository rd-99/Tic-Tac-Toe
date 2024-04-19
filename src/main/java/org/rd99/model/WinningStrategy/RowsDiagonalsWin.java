package org.rd99.model.WinningStrategy;

import org.rd99.model.Board;
import org.rd99.model.Player;
import org.rd99.model.PlayingPiece;

public class RowsDiagonalsWin implements DidPlayerWin{
    @Override
    public boolean didPlayerWinGame(Player player , Board boardToVerify) {
        PlayingPiece[][] pPToVerify = boardToVerify.gameBoard;
        for(int i = 0; i < boardToVerify.size; i++){
            int horizontalCount = 0;
            for(int j = 0; j < boardToVerify.size; j ++){
                if(pPToVerify[i][j] == null){
                    continue;
                }
                if(pPToVerify[i][j].pieceType == player.playingPiece.pieceType){
                    horizontalCount += 1;
                }
            }
            if(horizontalCount == boardToVerify.size){
                return true;
            }
        }


        for(int i1 = 0; i1 < boardToVerify.size; i1++){
            int verticalCount = 0;
            for(int j = 0; j< boardToVerify.size; j ++){
                    if(pPToVerify[j][i1] == null){
                        continue;
                    }
                    if(pPToVerify[j][i1].pieceType == player.playingPiece.pieceType){
                        verticalCount += 1;
                    }
                }
                if(verticalCount == boardToVerify.size){
                    return true;
                }
        }
        int diagCount = 0;
        for(int k = 0; k < boardToVerify.size; k++){
                if(pPToVerify[k][k] == null) break;
                if(pPToVerify[k][k].pieceType != player.playingPiece.pieceType){
                    break;
                }
                diagCount += 1;
            }
        if(diagCount == boardToVerify.size){
            return true;
        }
        diagCount = 0;
        for(int k1 = 0; k1 < boardToVerify.size; k1++){
            if(pPToVerify[k1][boardToVerify.size - k1 - 1] == null) break;
            if(pPToVerify[k1][boardToVerify.size - k1 - 1].pieceType != player.playingPiece.pieceType){
                break;
            }
            diagCount += 1;
        }
        if(diagCount == boardToVerify.size){
            return true;
        }
        return false;
    }
}
