package org.academiadecodigo.mainiacs.controllers;

import org.academiadecodigo.mainiacs.domains.Game;

/**
 * Class to define the basic functions of a controller
 */

abstract class AbstractController implements Controller {
    Game game;
    
    /**
     * Sets the game for the controllers.
     * @param game
     */
    public void setGame(Game game) {
        this.game = game;
    }
}
