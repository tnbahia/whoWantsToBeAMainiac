package org.academiadecodigo.mainiacs.controllers;

import org.academiadecodigo.mainiacs.views.ScoreView;

import java.net.Socket;

/**
 * Controller of the score part of the application
 * Controls the information about the gaming score and restarting the game.
 */

public class ScoreController extends AbstractController {
    private Socket socket;

    /**
     * Send the final scores to be shown.
     * Deals with whether to restart the game or not.
     */
    @Override
    public void init() {
        ScoreView scoreView = new ScoreView();
        scoreView.setScoreController(this);
        scoreView.show();
    }

    /**
     * Deals with whether to restart the game or end the application.
     *
     * @param answer
     */
    public void setRestart(int answer) {
        if (answer == 1) {
            LoginController loginController = new LoginController();
            loginController.setSocket(socket);
            loginController.setGame(game);
            loginController.init();
        } else {
            System.exit(0);
        }
    }

    /**
     * Get the player rank in the game.
     *
     * @return
     */
    public String getRank() {
        return game.rank();
    }

    /**
     * Sets the socket for the game.
     *
     * @param socket
     */
    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    /**
     * Sets the socket to be passed to another class.
     *
     * @return
     */
    public Socket getSocket() {
        return socket;
    }
}
