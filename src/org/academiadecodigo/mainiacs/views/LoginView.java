package org.academiadecodigo.mainiacs.views;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.mainiacs.controllers.LoginController;
import org.academiadecodigo.mainiacs.domains.utils.Messages;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * View of the login part of the app.
 * Deals with setting up connection and accept the login itself.
 */

public class LoginView implements View {
    private LoginController loginController;

    /**
     * Implements the method show with the Login information.
     */
    @Override
    public void show() {
        Socket socket = loginController.getSocket();
        Prompt prompt = null;
        try {
            prompt = new Prompt(socket.getInputStream(), new PrintStream(socket.getOutputStream()));
        } catch (IOException e) {
            System.out.println("Unable to create prompt: " + e.getMessage());
        }
        getPlayerName(prompt);
        welcomePlayer(socket);
    }

    private StringInputScanner buildScanner() {
        StringInputScanner scanner = new StringInputScanner();
        scanner.setMessage(Messages.LOGO + Messages.LOGIN_PLAYER);
        return scanner;
    }

    private void getPlayerName(Prompt prompt) {
        StringInputScanner scanner = buildScanner();
        String playerName = prompt.getUserInput(scanner);
        while (!loginController.addPlayer(playerName)) {
            scanner.setMessage(Messages.OCCUPIED_NAME);
            playerName = prompt.getUserInput(scanner);
        }
    }

    private void welcomePlayer(Socket socket) {
        PrintWriter outToClient = null;
        try {
            outToClient = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        outToClient.println(Messages.WELCOME);
    }

    /**
     * Sets the controller for the class.
     */
    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }
}