package org.academiadecodigo.mainiacs.domains;

public class Player {
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
