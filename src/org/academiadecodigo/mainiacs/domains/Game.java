package org.academiadecodigo.mainiacs.domains;

import java.net.Socket;
import java.util.*;

public enum Game {
    GAME;

    private HashMap<Socket, Player> players;
    private int[] questionsToAsk;

    Game() {
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

    public void setAnswer(Socket socket, int round, int answer) {
        if (checkAnswer(round, answer)) {
            players.get(socket).setScore(1);
        }
    }

    private boolean checkAnswer(int round, int answer) {
        int question = questionsToAsk[round];
        return Questions.values()[question].getRightAnswer() == answer;
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
                System.out.println("nome já existe");
                return false;
            }
        }
        return true;
    }

    public String rank() {
        HashMap<String, Integer> results = new HashMap<>();
        for (Player player : players.values()) {
            results.put(player.getName(),player.getScore());
        }
        StringBuilder s = new StringBuilder();
        for (String name : results.keySet()) {
            s.append(name);
            s.append(" - ");
            s.append(results.get(name));
            s.append("\n");
        }
        return s.toString();
    }
}
