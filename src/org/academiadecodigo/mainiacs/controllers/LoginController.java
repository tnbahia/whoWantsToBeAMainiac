package org.academiadecodigo.mainiacs.controllers;

import org.academiadecodigo.mainiacs.domains.Game;
import org.academiadecodigo.mainiacs.domains.Player;
import org.academiadecodigo.mainiacs.views.LoginView;
import java.net.Socket;

/**
 * Controller of the login part of the app.
 * Deals with setting up connection and accept the login itself.
 */

public class LoginController extends AbstractController{
    private Socket socket;
    
    /**
     * Method to initialize the controller itself.
     */

    @Override
    public void init() {
        LoginView loginView = new LoginView();
        loginView.setLoginController(this);
        loginView.show();
        startGame();
    }

    private void startGame() {
        QuestionController questionController = new QuestionController();
        questionController.setSocket(socket);
        questionController.setGame(game);
        questionController.init();
    }

    /**
     * Sets the player in question. Takes a String as an argument that will be stored as the player name.
     * @param name
     */
    public boolean addPlayer(String name){
        return game.addPlayer(socket, name);
    }

    /**
     * Sets the socket to allow the communication to the player terminal.
     * @param socket
     */
    public void setSocket(Socket socket){
        this.socket = socket;
    }
    
    /**
     * Get the socket being used by the controller.
     * @return
     */
    public Socket getSocket() {
        return socket;
    }

    public void setGame(Game game){
        this.game = game;
    }
}