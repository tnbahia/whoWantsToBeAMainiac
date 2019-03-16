package org.academiadecodigo.mainiacs.domains;

import java.util.HashMap;
import java.util.LinkedList;

public class Game {
    private HashMap<String,Player> players;
    private LinkedList<Integer> questionsAsked;


    public String getQuestion(){
        String question = Questions.values()[0].getQuestion();
        return question;
    }

    public  String[] getOptions(){
        String[] options = Questions.values()[0].getOptions();
        return options;
    }

    public void checkAnswer(int answer){

    }

    public boolean addPlayer(String name){
        if (players.keySet().contains(name)) {
            return false;
        }
        players.put(name,new Player(name));
        return true;
    }

    public String rank(){
        String ranking = "";
        return ranking;
    }

}
