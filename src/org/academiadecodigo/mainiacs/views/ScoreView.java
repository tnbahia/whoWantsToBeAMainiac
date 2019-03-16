package org.academiadecodigo.mainiacs.views;


import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.mainiacs.controllers.ScoreController;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class ScoreView extends AbstractView {
    @Override
    public void show() {

        Socket socket = ((ScoreController)controller).getSocket();
        Prompt prompt = null;
        try {
            prompt = new Prompt(socket.getInputStream(), new PrintStream(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(((ScoreController)controller).getRack());

        String[] options = {"Yes", "No"};
        MenuInputScanner menuInputScanner = new MenuInputScanner(options);
        menuInputScanner.setMessage("Restart Game?");
        int answer = prompt.getUserInput(menuInputScanner);
        ((ScoreController)controller).setRestart(answer);

    }
}
