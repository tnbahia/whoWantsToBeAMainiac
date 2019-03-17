package org.academiadecodigo.mainiacs.controllers;

import org.academiadecodigo.mainiacs.domains.Game;
import org.academiadecodigo.mainiacs.views.QuestionView;

import java.net.Socket;

/**
 * Controller of the questions part of the application
 * Controls the players.
 */

public class QuestionController extends AbstractController {
    private ScoreController scoreController;
    private Socket socket;
    private QuestionView questionView = new QuestionView();
    private static volatile int playersWaiting = 0;
    private int round = 0;

    /**
     * Sets the loop for the questions.
     * Ensures the questions are all sent at the same time.
     */

    @Override
    public void init() {
        synchronized (Game.GAME) {
            playersWaiting++;
            while (playersWaiting != 4) {
                try {
                    game.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Game.GAME.notifyAll();
        }

        if (Thread.activeCount() > 4) {
            playersWaiting = 0;
        }

        questionView.setQuestionController(this);
        questionView.show();
        loop();
    }

    public void loop() {
        if (round != 10) {
            round++;
            init();
        }
        scoreController.setSocket(socket);
        scoreController.setGame(game);
        scoreController.init();
    }

    /**
     * Sets the controller
     *
     * @param scoreController
     */
    public void setScoreController(ScoreController scoreController) {
        this.scoreController = scoreController;
    }

    /**
     * Gets String question from the game.
     */

    public String getQuestion() {
        return game.getQuestion(round);
    }

    /**
     * Gets the array of Strings that are the options.
     *
     * @return
     */
    public String[] getOptions() {
        return game.getOptions(round);
    }

    /**
     * Checks if the answer was correct or not.
     *
     * @param answer
     */
    public void setAnswer(int answer) {
        game.setAnswer(socket, round, answer);
    }

    /**
     * Sets the correct socket.
     *
     * @param socket
     */
    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    /**
     * gets the correct socket.
     *
     * @return
     */
    public Socket getSocket() {
        return socket;
    }
}
