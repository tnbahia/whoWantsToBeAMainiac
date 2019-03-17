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
        try {
            Prompt prompt = new Prompt(socket.getInputStream(), new PrintStream(socket.getOutputStream()));
            int answer = prompt.getUserInput(createScanner());
            checkAnswer(socket, answer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Creates the screen.
     * @return
     */
    private MenuInputScanner createScanner() {
        MenuInputScanner menuInputScanner = new MenuInputScanner(questionController.getOptions());
        menuInputScanner.setMessage(questionController.getQuestion());
        return menuInputScanner;
    }

    /**
     *Sets up the Question Controller.
     * @param questionController
     */
    public void setQuestionController(QuestionController questionController){
        this.questionController = questionController;
    }

    /**
     * Checks if the answer given by the player is correct and tells the player.
     * @param socket
     * @param answer
     */
    private void checkAnswer(Socket socket, int answer){
        try {
            PrintWriter outToClient = new PrintWriter(socket.getOutputStream(), true);
            outToClient.println(questionController.setAnswer(answer) ? Messages.RIGHT : Messages.WRONG);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
