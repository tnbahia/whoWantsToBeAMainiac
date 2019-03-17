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
public class ScoreView implements View {
    
    private ScoreController scoreController;
    
    /**
     * Implements the method show with the ranking.
     */
    @Override
    public void show() {
        Socket socket = scoreController.getSocket();
        try {
            Prompt prompt = new Prompt(socket.getInputStream(), new PrintStream(socket.getOutputStream()));
            int answer = prompt.getUserInput(createScanner());
            scoreController.setRestart(answer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Sets the ranking screen.
     * @return
     */
    private MenuInputScanner createScanner() {
        String[] options = {Messages.YES, Messages.NO};
        MenuInputScanner menuInputScanner = new MenuInputScanner(options);

        menuInputScanner.setMessage(
                Messages.OVER + "\n\n" +
                Messages.SCORE_BAR + "\n" +
                scoreController.getRank() + "\n" +
                Messages.SCORE_BAR + "\n\n" +
                Messages.GAME_RESTART);
        
        return menuInputScanner;
    }
    
    /**
     * Sets the controller for the view.
     * @param scoreController
     */
    public void setScoreController(ScoreController scoreController) {
        this.scoreController = scoreController;
    }
}
