package org.academiadecodigo.mainiacs.domains;

public enum Questions {
    QUESTION_1 ("Quem é este?",
            new String[]{
                    "oia",
                    "oiasc",
                    "oicjsd",
                    "oiscdj"},
            1);

    private String question;
    private String[] options;
    private int rightAnswer;

    Questions(String question, String[] options, int rightAnswer) {
        this.question = question;
        this.options = options;
        this.rightAnswer = rightAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getRightAnswer() {
        return rightAnswer;
    }
}
