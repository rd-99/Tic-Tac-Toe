package org.rd99.model.WinningStrategy;

import org.rd99.model.Board;
import org.rd99.model.Player;

public interface DidPlayerWin {
    public boolean didPlayerWinGame(Player player , Board board);
}
