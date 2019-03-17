package org.academiadecodigo.mainiacs.domains;

import org.academiadecodigo.mainiacs.domains.utils.Messages;
import org.academiadecodigo.mainiacs.domains.utils.Questions;

import java.net.Socket;
import java.util.*;

/**
 * Game class, where all the game logic is set.
 */

public enum Game {
    GAME;

    public static final int NUM_OF_PLAYERS = 4;
    public static final int NUM_OF_ROUNDS = 10;

    private final HashMap<Socket, Player> players;
    private int[] questionsToAsk;
    
    /**
     * Constructor that sets the players and the questions.
     */
    Game() {
        players = new HashMap<>();
        setQuestionsToAsk();
    }
    
    /**
     * Sets the question to be sent to the controller.
     */
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
    
    /**
     * Gets a new question.
     * @param round
     * @return
     */
    public String getQuestion(int round) {
        int questionNumber = questionsToAsk[round - 1];
        return "Question " + round + " - " + Questions.values()[questionNumber].getQuestion();
    }
    
    /**
     * Sets the options for the question.
     * @param round
     * @return
     */
    public String[] getOptions(int round) {
        int questionNumber = questionsToAsk[round - 1];
        return Questions.values()[questionNumber].getOptions();
    }
    
    /**
     * Sets the score according to the answer.
     * @param socket
     * @param round
     * @param answer
     * @return
     */
    public boolean setAnswer(Socket socket, int round, int answer) {
        if (checkAnswer(round, answer)) {
            players.get(socket).setScore(1);
            return true;
        }
        return false;
    }
    
    /**
     * Checks if the answer provided by the user is right or wrong.
     * @param round
     * @param answer
     * @return
     */
    private boolean checkAnswer(int round, int answer) {
        int question = questionsToAsk[round - 1];
        return Questions.values()[question].getRightAnswer() == answer;
    }
    
    /**
     * Adds the player to the Player's map.
     * @param socket
     * @param name
     * @return
     */
    public boolean addPlayer(Socket socket, String name) {
        if (nameAlreadyExists(name)) {
            return false;
        }
        players.put(socket, new Player(name));
        return true;
    }

    /**
     * Method to check if the name the user inserted is available or not.
     * @param name
     * @return
     */
    private boolean nameAlreadyExists(String name) {
        for (Player player : players.values()) {
            if (player.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method to see the game ranking.
     * Checks and sets the scores for all the users.
     * @return
     */
    public String rank() {
        getWinner();
        HashMap<String, Integer> results = new HashMap<>();
        for (Player player : players.values()) {
            String name = player.isWinner() ? Messages.WINNER + player.getName() : player.getName();
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

    /**
     * Checks and sets the winner of the game.
     */
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
