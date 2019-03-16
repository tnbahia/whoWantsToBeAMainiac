package org.academiadecodigo.mainiacs.domains;

import java.net.Socket;
import java.util.*;

public class Game {
    private HashMap<Socket, Player> players;
    private int[] questionsToAsk;

    public Game() {
        players = new HashMap<>();
        questionsToAsk = new int[10];
        for (int i = 0; i < questionsToAsk.length; i++) {
            int num = (int) (Math.random() * Questions.values().length);
            questionsToAsk[i] = num;
        }
    }

    public String getQuestion(int round) {
        int questionNumber = questionsToAsk[round];
        return Questions.values()[questionNumber].getQuestion();
    }

    public String[] getOptions(int round) {
        int questionNumber = questionsToAsk[round];
        return Questions.values()[questionNumber].getOptions();
    }

    public void setAnswer(int answer, int round) {

    }

    public boolean addPlayer(Socket socket, String name) {
        if (nameAlreadyExists(name)) {
            return false;
        }
        players.put(socket, new Player(name));
        return true;
    }

    private boolean nameAlreadyExists(String name) {
        for (Player player: players.values()) {
            if (player.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }

    public String rank() {
        String ranking = "";
        return ranking;
    }



}
