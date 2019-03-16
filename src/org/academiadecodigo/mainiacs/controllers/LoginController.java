package org.academiadecodigo.mainiacs.controllers;

import org.academiadecodigo.mainiacs.domains.Game;
import org.academiadecodigo.mainiacs.domains.Player;
import org.academiadecodigo.mainiacs.views.LoginView;
import java.net.Socket;


public class LoginController extends AbstractController{
    private QuestionController questionController;
    private LoginView loginView;
    private Socket socket;
    private Player player;


    @Override
    public void init() {
        loginView = new LoginView();
        loginView.setLoginController(this);
        loginView.show();
        questionController = new QuestionController();
        questionController.setSocket(socket);
        questionController.init();
    }

    public void setPlayer(String name){
        player = new Player(name);
        game.addPlayer(player);
        System.out.println("chegou aqui");
    }

    public void setSocket(Socket socket){

        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public LoginController getLoginController(){
        return this;
    }

    public void setGame(Game game){
        this.game = game;
    }
}
