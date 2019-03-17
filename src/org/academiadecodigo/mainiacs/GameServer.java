package org.academiadecodigo.mainiacs;

import org.academiadecodigo.mainiacs.controllers.LoginController;
import org.academiadecodigo.mainiacs.domains.Game;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Class that starts the game.
 * Creates the socket and waits for players connections, creating a thread for each player.
 */

public class GameServer {
    private static final int DEFAULT_PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(DEFAULT_PORT);

            int playersLoggedIn = 0;
            while (playersLoggedIn < Game.NUM_OF_PLAYERS) {
                Socket newPlayer = serverSocket.accept();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        LoginController loginController = new LoginController();
                        loginController.setSocket(newPlayer);
                        loginController.setGame(Game.GAME);
                        System.out.println("entrou um");
                        loginController.init();
                    }
                }).start();
                playersLoggedIn++;
            }
            System.out.println(Thread.currentThread().getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
