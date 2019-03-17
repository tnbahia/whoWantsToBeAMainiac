package org.academiadecodigo.mainiacs.views;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.mainiacs.controllers.QuestionController;
import org.academiadecodigo.mainiacs.domains.utils.Messages;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
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
        checkAnswer(socket, answer);
    }

    /**
     *Setting up the Question Controller.
     * @param questionController
     */

    public void setQuestionController(QuestionController questionController){
        this.questionController = questionController;
    }

    /**
     * Will check if the answer give by the player is correct.
     * @param socket
     * @param answer
     */

    private void checkAnswer(Socket socket, int answer){
        PrintWriter outToClient = null;
        try {
            outToClient = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        outToClient.println(questionController.setAnswer(answer) ? Messages.RIGHT : Messages.WRONG);
    }
}
