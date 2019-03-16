package org.academiadecodigo.mainiacs;

import org.academiadecodigo.mainiacs.controllers.LoginController;
import org.academiadecodigo.mainiacs.domains.Game;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    private static final int DEFAULT_PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(DEFAULT_PORT);
            Game game = new Game();

            int playersLoggedIn = 0;
            while (playersLoggedIn < 4) {
                Socket newPlayer = serverSocket.accept();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        LoginController loginController = new LoginController();
                        loginController.setSocket(newPlayer);
                        loginController.setGame(game);
                        loginController.init();
                    }
                }).start();
                playersLoggedIn++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
