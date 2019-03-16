package org.academiadecodigo.mainiacs.controllers;

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
    static int playersWaiting = 0;
    private int questionNumber = 0;
    
    /**
     * Sets the loop for the questions.
     * Ensures the questions are all sent at the same time.
     */
    @Override
    public void init() {
            synchronized (game) { 
                while (playersWaiting < 4) {
                    try {
                        playersWaiting++;
                        if (playersWaiting != 4) {
                            wait();
                        }
                        notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            playersWaiting = 0;
            questionView.show();
            loop();
    }

    public void loop() {
        if ( questionNumber != 10 ) {
            questionNumber++;
            init();
        }
        scoreController.setSocket(socket);
        scoreController.init();
    }
    
    /**
     * Sets the controller
     * @param scoreController
     */
    public void setScoreController(ScoreController scoreController) {
        this.scoreController = scoreController;
    }
    
    /**
     * Gets String question from the game.
     */
    public String getQuestion() {
        return game.getQuestion();
    }
    
    /**
     * Gets the array of Strings that are the options.
     * @return
     */
    public String[] getOptions() {
        return game.getOptions();
    }
    
    /**
     * Checks if the answer was correct or not.
     * @param answer
     */
    public void setAnswer(int answer) {
        game.checkAnswer(answer);
    }
    
    /**
     * Sets the correct socket.
     * @param socket
     */
    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    
    /**
     * gets the correct socket.
     * @return
     */
    public Socket getSocket() {
        return socket;
    }
}
