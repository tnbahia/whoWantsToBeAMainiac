package org.academiadecodigo.mainiacs.domains;

import org.academiadecodigo.mainiacs.domains.utils.Questions;

import java.net.Socket;
import java.util.*;

public enum Game {
    GAME;

    public static final int NUM_OF_PLAYERS = 4;
    public static final int NUM_OF_ROUNDS = 10;

    private HashMap<Socket, Player> players;
    private int[] questionsToAsk;

    Game() {
        players = new HashMap<>();
        setQuestionsToAsk();
    }

    private void setQuestionsToAsk() {
        questionsToAsk = new int[NUM_OF_ROUNDS];
        HashSet<Integer> questionNumbers = new HashSet<>();
        for (int i = 0; i < questionsToAsk.length; i++) {
            int num = (int) (Math.random() * Questions.values().length);
            while (!questionNumbers.add(num)) {
                num = (int) (Math.random() * Questions.values().length);
            }
            questionsToAsk[i] = num;
        }
    }

    public String getQuestion(int round) {
        int questionNumber = questionsToAsk[round - 1];
        return Questions.values()[questionNumber].getQuestion();
    }

    public String[] getOptions(int round) {
        int questionNumber = questionsToAsk[round - 1];
        return Questions.values()[questionNumber].getOptions();
    }

    public boolean setAnswer(Socket socket, int round, int answer) {
        if (checkAnswer(round, answer)) {
            players.get(socket).setScore(1);
            return true;
        }
        return false;
    }

    private boolean checkAnswer(int round, int answer) {
        int question = questionsToAsk[round - 1];
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
        for (Player player : players.values()) {
            if (player.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public String rank() {
        getWinner();
        HashMap<String, Integer> results = new HashMap<>();
        for (Player player : players.values()) {
            String name = player.isWinner() ? "aljd " + player.getName() : player.getName();
            results.put(name, player.getScore());
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

    private void getWinner() {
        int maxPoints = 0;
        for (Player player : players.values()) {
            if (player.getScore() > maxPoints) {
                maxPoints = player.getScore();
            }
        }
        for (Player player : players.values()) {
            if (player.getScore() == maxPoints) {
                player.setWinner(true);
            }
        }
    }
}
