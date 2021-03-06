package org.academiadecodigo.mainiacs.domains;

/**
 * Class that defines the player itself
 */

class Player {
    private final String name;
    private int score;
    private boolean winner;
    
    /**
     * Player constructor. Takes a string that initializes the variable name.
     * @param name
     */
    public Player(String name) {
        this.name = name;
    }
    
    /**
     * Method to update the score of the player during the game.
     * @param points
     */
    public void setScore(int points) {
        this.score = score + points;
    }
    
    /**
     * Method to return the player's name.
     * @return
     */
    public String getName() {
        return name;
    }
    
    /**
     * Method to return the score the player has earned.
     * @return
     */
    public int getScore() {
        return score;
    }

    /**
     * Method to return the winning the player.
     * @return
     */
    public boolean isWinner() {
        return winner;
    }

    /**
     * Method to define the winner of this games.
     * @return
     */
    public void setWinner(boolean winner) {
        this.winner = winner;
    }
}
