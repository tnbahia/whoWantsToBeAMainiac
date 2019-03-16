package org.academiadecodigo.mainiacs.views;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.mainiacs.controllers.LoginController;
import org.academiadecodigo.mainiacs.utils.Messages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * View of the login part of the app.
 * Deals with setting up connection and accept the login itself.
 */

public class LoginView extends AbstractView {

    LoginController loginController;
    
    /**
     * Implements the method show with the Login information.
     */
    @Override
    public void show() {
        Socket socket = loginController.getSocket();
        Prompt prompt = null;
        try {
            //prompt = new Prompt(System.in, System.out);
            prompt = new Prompt(socket.getInputStream(),new PrintStream(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringInputScanner scanner = new StringInputScanner();
        scanner.setMessage(Messages.LOGIN_PLAYER);
        //scanner.setError(Messages.OCCUPIED_NAME);
        String playerName = prompt.getUserInput(scanner);
        while (!loginController.addPlayer(playerName)) {
            //scanner.setMessage(Messages.ERROR_INVALID_PLAYER);
            playerName = prompt.getUserInput(scanner);
            System.out.println("aisodiuadosiu");
        }
        System.out.println(playerName);
    }

    /**
     * Sets the controller for the class.
     */
    public void setLoginController(LoginController loginController){
        this.loginController = loginController;
    }
}