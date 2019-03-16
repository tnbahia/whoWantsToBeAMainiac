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

public class QuestionView extends AbstractView {
    
    /**
     * Implements the method show with the Questions.
     */
    @Override
    public void show() {
        Socket socket = ((QuestionController)controller).getSocket();
        Prompt prompt = null;
        try {
            prompt = new Prompt(socket.getInputStream(), new PrintStream(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        MenuInputScanner menuInputScanner = new MenuInputScanner(((QuestionController) controller).getOptions());
        menuInputScanner.setMessage(((QuestionController) controller).getQuestion());
        int answer = prompt.getUserInput(menuInputScanner);
        ((QuestionController)controller).setAnswer(answer);
    }
}
