package org.academiadecodigo.mainiacs.views;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.mainiacs.controllers.QuestionController;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

/**
 * View of the Question part.
 * Deals with showing the questions to the player.
 */

public class QuestionView implements View {
    private QuestionController questionController;

    /**
     * Implements the method show with the Questions.
     */

    @Override
    public void show() {
        Socket socket = questionController.getSocket();
        Prompt prompt = null;
        try {
            prompt = new Prompt(socket.getInputStream(), new PrintStream(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        MenuInputScanner menuInputScanner = new MenuInputScanner(questionController.getOptions());
        menuInputScanner.setMessage(questionController.getQuestion());

        int answer = prompt.getUserInput(menuInputScanner);
        questionController.setAnswer(answer);
    }

    public void setQuestionController(QuestionController questionController){
        this.questionController = questionController;
    }
}
