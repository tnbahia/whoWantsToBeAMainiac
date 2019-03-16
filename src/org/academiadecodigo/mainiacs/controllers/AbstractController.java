package org.academiadecodigo.mainiacs.controllers;

import org.academiadecodigo.mainiacs.domains.Game;
import org.academiadecodigo.mainiacs.views.View;

/**
 * Class to define the basic functions of a controller
 */

public abstract class AbstractController implements Controller {
    View view;
    Game game;

    public void setGame(Game game) {
        this.game = game;
    }

    public void setView(View view) {
        this.view = view;
    }

}
