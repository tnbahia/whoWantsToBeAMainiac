package org.academiadecodigo.mainiacs.controllers;

public class QuestionController extends AbstractController {
    private ScoreController scoreController;

    @Override
    public void init() {

    }

    public void setScoreController(ScoreController scoreController) {
        this.scoreController = scoreController;
    }
}
