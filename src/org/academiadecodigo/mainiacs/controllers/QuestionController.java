package org.academiadecodigo.mainiacs.controllers;

import org.academiadecodigo.mainiacs.domains.Game;
import org.academiadecodigo.mainiacs.domains.utils.Messages;
import org.academiadecodigo.mainiacs.views.QuestionView;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Controller of the questions part of the application
 * Controls the players.
 */

public class QuestionController extends AbstractController {
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
                    waitingMessage();
                    Game.GAME.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Game.GAME.notifyAll();
        }
        synchronized (Game.GAME) {
            playersAwake++;
        }
        if (playersAwake == Game.NUM_OF_PLAYERS) {
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
            ScoreController scoreController = new ScoreController();
            scoreController.setSocket(socket);
            scoreController.setGame(Game.GAME);
            scoreController.init();
        }
        newQuestion();
        init();
    }

    private void waitingMessage(){
        PrintWriter outToClient = null;
        try {
            outToClient = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        outToClient.println(Messages.WAITING);
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
