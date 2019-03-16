package org.academiadecodigo.mainiacs.controllers;


import org.academiadecodigo.mainiacs.views.ScoreView;

import java.net.Socket;


public class ScoreController extends AbstractController {

    private ScoreView scoreView = new ScoreView();
    private Socket socket;
    private LoginController loginController;

    @Override
    public void init() {
        scoreView.show();
    }

    public void setRestart(int answer){
        if(answer == 1){
            loginController = new LoginController();
            loginController.setSocket(socket);
            loginController.setGame(game);
            loginController.init();
        } else {
            System.out.println("Game Over");
        }
    }

    public String getRank(){
        return game.rank();
    }

    public void setSocket(Socket socket) {

        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }
}
