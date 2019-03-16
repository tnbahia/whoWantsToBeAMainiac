package org.academiadecodigo.mainiacs.views;

import org.academiadecodigo.mainiacs.controllers.Controller;

/**
 * Class to define the basic functions of a view
 */

public abstract class AbstractView implements View {
    protected Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
