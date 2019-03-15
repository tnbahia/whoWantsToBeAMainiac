package org.academiadecodigo.mainiacs.views;

import org.academiadecodigo.mainiacs.controllers.Controller;

public abstract class AbstractView implements View {
    protected Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
