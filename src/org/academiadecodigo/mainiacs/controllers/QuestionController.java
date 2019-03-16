package org.academiadecodigo.mainiacs.controllers;


import org.academiadecodigo.mainiacs.views.QuestionView;

import java.net.Socket;

public class QuestionController extends AbstractController {
    private ScoreController scoreController;
    private Socket socket;
    private QuestionView questionView = new QuestionView();
    static int playersWaiting = 0;
    private int questionNumber = 0;

    @Override
    public void init() {
            synchronized (game) { 
                while (playersWaiting < 4) {
                    try {
                        playersWaiting++;
                        if (playersWaiting != 4) {
                            System.out.println("Chegou aqui tambem");
                            wait();
                        }
                        notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
            playersWaiting = 0;
            questionView.setQuestionController(this);
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

    public void setScoreController(ScoreController scoreController) {
        this.scoreController = scoreController;
    }

    public String getQuestion() {
        return game.getQuestion();
    }

    public String[] getOptions() {
        return game.getOptions();
    }

    public void setAnswer(int answer) {
        game.checkAnwser(answer);
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }
}
