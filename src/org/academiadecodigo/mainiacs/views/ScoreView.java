package org.academiadecodigo.mainiacs.views;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.mainiacs.controllers.ScoreController;
import org.academiadecodigo.mainiacs.domains.utils.Messages;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

/**
 * View of the Score part.
 * Deals with showing the final score to the player.
 */

public class ScoreView extends AbstractView {
    private ScoreController scoreController;
    
    /**
     * Implements the method show with the ranking.
     */
    @Override
    public void show() {
        Socket socket = scoreController.getSocket();
        Prompt prompt = null;
        try {
            prompt = new Prompt(socket.getInputStream(), new PrintStream(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] options = {Messages.YES, Messages.NO};
        MenuInputScanner menuInputScanner = new MenuInputScanner(options);

        menuInputScanner.setMessage(Messages.OVER + "\n\n" + Messages.SCORE_BAR + "\n" +
                                    scoreController.getRank() + "\n" +
                                    Messages.SCORE_BAR + "\n\n" + Messages.GAME_RESTART);

        int answer = prompt.getUserInput(menuInputScanner);
        scoreController.setRestart(answer);
    }

    public void setScoreController(ScoreController scoreController) {
        this.scoreController = scoreController;
    }
}
