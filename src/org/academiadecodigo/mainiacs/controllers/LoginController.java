package org.academiadecodigo.mainiacs.controllers;

import org.academiadecodigo.mainiacs.domains.Player;
import org.academiadecodigo.mainiacs.views.LoginView;

import java.net.Socket;

/**
 *
 */

public class LoginController extends AbstractController{
    private QuestionController questionController;
    private LoginView loginView = new LoginView();
    private Socket socket;
    private Player player;

    @Override
    public void init() {
        loginView.show();
        questionController = new QuestionController();
        questionController.setSocket(socket);
        questionController.init();
    }

    public void setPlayer(String name){
        player = new Player(name);
        game.addPlayer(player);
    }

    public void setSocket(Socket socket){
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }
}
