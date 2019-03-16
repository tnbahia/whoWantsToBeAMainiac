package org.academiadecodigo.mainiacs.domains;

import java.util.HashMap;
import java.util.LinkedList;

public class Game {
    private HashMap<String,Player> players;
    private LinkedList<Integer> questionsAsked;

    public  String[] getOptions(){
        String[] options = Questions.values()[0].getOptions();
        return options;
    }

    public void checkAnwser(int answer){

    }

    public String getQuestion(){
        String question = Questions.values()[0].getQuestion();
        return question;
    }

    public void addPlayer(Player player){

    }

    public String rank(){
        String ranking = "";
        return ranking;
    }

}
