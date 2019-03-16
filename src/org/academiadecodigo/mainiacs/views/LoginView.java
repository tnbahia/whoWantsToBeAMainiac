package org.academiadecodigo.mainiacs.views;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.mainiacs.controllers.LoginController;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

/**
 * View of the login part of the app.
 * Deals with setting up connection and accept the login itself.
 */

public class LoginView extends AbstractView {
    
    /**
     * Implements the method show with the Login information.
     */
    @Override
    public void show() {

        Socket socket = ((LoginController) controller).getSocket();

        Prompt prompt = null;
        try {
            prompt = new Prompt(socket.getInputStream(), new PrintStream(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringInputScanner scanner = new StringInputScanner();
        scanner.setMessage("Input Login");
        //scanner.setMessage(Messages.LOGIN_PLAYER);
        //scanner.setError(Messages.ERROR_INVALID_PLAYER);
        String playerName = prompt.getUserInput(scanner);
        ((LoginController) controller).setPlayer(playerName);
    }
}
