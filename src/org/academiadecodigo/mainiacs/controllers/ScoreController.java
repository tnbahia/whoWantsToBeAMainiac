package org.academiadecodigo.mainiacs.controllers;

import org.academiadecodigo.mainiacs.domains.utils.Messages;
import org.academiadecodigo.mainiacs.views.ScoreView;

import java.io.IOException;
import java.io.PrintWriter;
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
     * @param answer
     */
    public void setRestart(int answer) {
        if (answer == 1) {
            LoginController loginController = new LoginController();
            loginController.setSocket(socket);
            loginController.setGame(game);
            loginController.init();
        } else {
            try {
                PrintWriter outToClient = new PrintWriter(socket.getOutputStream(), true);
                outToClient.println(Messages.QUIT);
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Get the player ranking for the game.
     * @return
     */
    public String getRank() {
        return game.rank();
    }

    /**
     * Sets the socket for the game.
     * @param socket
     */
    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    /**
     * Gets the socket to be passed to another class.
     * @return
     */
    public Socket getSocket() {
        return socket;
    }
}
