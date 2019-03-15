package org.academiadecodigo.mainiacs.views;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.mainiacs.controllers.LoginController;

public class LoginView extends AbstractView {


    @Override
    public void show() {

        StringInputScanner scanner = new StringInputScanner();
        scanner.setMessage("Input Login");
        //scanner.setMessage(Messages.LOGIN_PLAYER);
        //scanner.setError(Messages.ERROR_INVALID_PLAYER);
        String playerName = prompt.getUserInput(scanner);
        ((LoginController) controller).setPlayerName(playerName);




    }
}
