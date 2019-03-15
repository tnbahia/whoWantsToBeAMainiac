package org.academiadecodigo.mainiacs.controllers;

import org.academiadecodigo.mainiacs.domains.Game;

public class LoginController extends AbstractController{
    private QuestionController questionController;

    @Override
    public void init() {
        view.show();
    }

    public void setQuestionController(QuestionController questionController) {
        this.questionController = questionController;
    }

    public void setPlayerName(String name){
        
    }

}
