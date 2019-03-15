package org.academiadecodigo.mainiacs.controllers;

import org.academiadecodigo.mainiacs.domains.Player;

import java.net.Socket;


public class LoginController extends AbstractController{
    private QuestionController questionController;
    private Socket socket;
    private Player player;

    @Override
    public void init() {
        view.show();
        questionController = new QuestionController();
        questionController.setSocket(socket);
        questionController.init();
    }



    public void setPlayerName(String name){
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
