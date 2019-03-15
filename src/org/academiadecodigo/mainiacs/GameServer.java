package org.academiadecodigo.mainiacs;

import org.academiadecodigo.mainiacs.controllers.LoginController;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    public static final int DEFAULT_PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(DEFAULT_PORT);
            LoginController loginController = GameSetup.setup();

            int players = 0;
            while (players < 4) {
                Socket newPlayer = serverSocket.accept();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        loginController.newPlayer();
                    }
                }).start();
                players++;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
