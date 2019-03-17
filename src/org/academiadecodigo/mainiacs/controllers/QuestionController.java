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
    private static volatile int playersAwake = 0;
    private int round = 0;

    /**
     * Sets the loop for the questions.
     * Ensures the questions are all sent at the same time.
     */

    @Override
    public void init() {
        synchronized (Game.GAME) {
            playersWaiting++;
            while (playersWaiting != Game.NUM_OF_PLAYERS) {
                try {
                    Game.GAME.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("----" + Thread.currentThread().getName());
            Game.GAME.notifyAll();
        }
        System.out.println(Thread.currentThread().getName() + " - " + Thread.activeCount());
        synchronized (Game.GAME) {
            playersAwake++;
        }
        if (playersAwake == Game.NUM_OF_PLAYERS) {
            System.out.println("no players waiting");
            playersWaiting = 0;
            playersAwake = 0;
        }
        loop();
    }

    private void newQuestion() {
        questionView.setQuestionController(this);
        questionView.show();
    }

    private void loop() {
        round++;
        if (round > Game.NUM_OF_ROUNDS) {
            scoreController = new ScoreController();
            scoreController.setSocket(socket);
            scoreController.setGame(Game.GAME);
            scoreController.init();
        }
        newQuestion();
        init();
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
    public boolean setAnswer(int answer) {
        return game.setAnswer(socket, round, answer);
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
