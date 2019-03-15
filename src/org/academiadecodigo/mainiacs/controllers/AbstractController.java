package org.academiadecodigo.mainiacs.controllers;

import org.academiadecodigo.mainiacs.domains.Game;
import org.academiadecodigo.mainiacs.views.View;

public abstract class AbstractController implements Controller {
    protected View view;
    protected Game game;

    public void setGame(Game game) {
        this.game = game;
    }

    public void setView(View view) {
        this.view = view;
    }

}
