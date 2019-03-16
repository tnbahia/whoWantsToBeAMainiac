package org.academiadecodigo.mainiacs.views;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.mainiacs.controllers.LoginController;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class LoginView extends AbstractView {

    LoginController loginController;

    @Override
    public void show() {


        Socket socket = loginController.getSocket();
        Prompt prompt = null;
        try {
            //prompt = new Prompt(System.in, System.out);
            prompt = new Prompt(socket.getInputStream(), new PrintStream(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringInputScanner scanner = new StringInputScanner();
        scanner.setMessage("Input User: ");
        //scanner.setMessage(Messages.LOGIN_PLAYER);
        //scanner.setError(Messages.ERROR_INVALID_PLAYER);
        String playerName = prompt.getUserInput(scanner);
        loginController.setPlayer(playerName);
    }

    public void setLoginController(LoginController loginController){
        this.loginController = loginController;
    }
}
