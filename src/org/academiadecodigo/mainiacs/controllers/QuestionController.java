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
    private final QuestionView questionView = new QuestionView();
    private static volatile int playersWaiting = 0;
    private static volatile int playersAwake = 0;
    private int round = 0;

    /**
     * Sets the question stage.
     * Ensures the questions are all sent at the same time.
     */
    @Override
    public void init() {
        waitForOtherPlayers();
        round++;
        checkForEndGame();
        newQuestion();
        init();
    }
    
    /**
     * Method to ensure that the question is sent to all players at the same time.
     */
    
    private void waitForOtherPlayers() {
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
            playersAwake++;
            Game.GAME.notifyAll();
        }
        if (playersAwake == Game.NUM_OF_PLAYERS) {
            playersWaiting = 0;
            playersAwake = 0;
        }
    }
    
    /**
     * Checks if the number of rounds have been played.
     */
    private void checkForEndGame() {
        if (round > Game.NUM_OF_ROUNDS) {
            ScoreController scoreController = new ScoreController();
            scoreController.setSocket(socket);
            scoreController.setGame(Game.GAME);
            scoreController.init();
        }
    }
    
    /**
     * Gets new question.
     */
    private void newQuestion() {
        questionView.setQuestionController(this);
        questionView.show();
    }

    /**
     * Sends a waiting message to the user until the users are ready to play.
     */
    private void waitingMessage(){
        try {
            PrintWriter outToClient = new PrintWriter(socket.getOutputStream(), true);
            outToClient.println(Messages.WAITING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Gets String question from the game.
     */

    public String getQuestion() {
        return game.getQuestion(round);
    }

    /**
     * Gets the array of Strings that are the options.
     * @return
     */
    public String[] getOptions() {
        return game.getOptions(round);
    }

    /**
     * Checks if the answer was correct or not.
     * @param answer
     */
    public boolean setAnswer(int answer) {
        return game.setAnswer(socket, round, answer);
    }

    /**
     * Sets the correct socket.
     * @param socket
     */
    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    /**
     * Gets the socket information.
     * @return
     */
    public Socket getSocket() {
        return socket;
    }
}
