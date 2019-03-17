package org.academiadecodigo.mainiacs.domains.utils;

/**
 * List of all questions and respective answers and methods.
 */

public enum Questions {
    
    QUESTION_1("Whose wife was stalked in their honeymoon?",
            new String[]{
                    "Mila",
                    "Tiago",
                    "Dieferson",
                    "Bahia"},
            1),
    QUESTION_2("Who almost killed their brother-in-law by accident?",
            new String[]{
                    "Belle",
                    "Tiago",
                    "Álvaro",
                    "Bruno"},
            2),
    QUESTION_3("Who loves their dog like a daughter?",
            new String[]{
                    "Brigas",
                    "Sara",
                    "Fábio",
                    "Francisco"},
            3),
    QUESTION_4("Who is a football referee?",
            new String[]{
                    "Francisco",
                    "Ricardo",
                    "Bahia",
                    "Baganha"},
            4),
    QUESTION_5("Who ate only tuna for 5 consecutive days while stranded on an island?",
            new String[]{
                    "Alvaro",
                    "Fábio",
                    "Larissa",
                    "Robin"},
            1),
    QUESTION_6("Who was mistaken for a burglar one time?",
            new String[]{
                    "Ricardo",
                    "Larissa",
                    "Bruno",
                    "Dieferson"},
            2),
    QUESTION_7("Who was a DJ before coming to Portugal?",
            new String[]{
                    "Belle",
                    "Bruno",
                    "Dieferson",
                    "Álvaro"},
            3),
    QUESTION_8("Who passes out at the sight of their own blood?",
            new String[]{
                    "Baganha",
                    "Sara",
                    "Francisco",
                    "Belle"},
            4),
    QUESTION_9("Who has been known for getting puke in their eyes?",
            new String[]{
                    "Bruno",
                    "Bahia",
                    "Mila",
                    "Francisco"},
            2),
    QUESTION_10("Who is an alien?",
            new String[]{
                    "Sara",
                    "Ricardo",
                    "Francisco",
                    "Baganha"},
            3),
    QUESTION_11("Who loves plaid shirts the most?",
            new String[]{
                    "Dieferson",
                    "Sara",
                    "Mila",
                    "Ricardo"},
            4),
    QUESTION_12("Who has the youngest child?",
            new String[]{
                    "Bruno",
                    "Bahia",
                    "Tiago",
                    "Sara"},
            1),
    QUESTION_13("Who refuses to get up on a chair?",
            new String[]{
                    "Ricardo",
                    "Sara",
                    "Dieferson",
                    "Bahia"},
            2),
    QUESTION_14("What's the name of the device responsible for amplifying analog signals?",
            new String[]{
                    "Switch",
                    "Router",
                    "Transistor",
                    "Chip"},
            4),
    QUESTION_15("What the name given to a set of electronic circuits on one small flat piece of silicon?",
            new String[]{
                    "Integrated Circuit",
                    "RAM memory",
                    "Transistor",
                    "CPU"},
            1),
    QUESTION_16("What is NOT a numeral system?",
            new String[]{
                    "Hexadecimal",
                    "Lobster",
                    "Decimal",
                    "Binary",},
            2),
    QUESTION_17("What is not a logic operator?",
            new String[]{
                    "AND",
                    "OR",
                    "MAYBE",
                    "NOT"},
            3),
    QUESTION_18("What is the most common architecture used on modern computers?",
            new String[]{
                    "Turing",
                    "Boolean",
                    "Gates",
                    "Von Neumann"},
            4),
    QUESTION_19("What is NOT part of the basic computer architecture?",
            new String[]{
                    "USB",
                    "CPU",
                    "Memory",
                    "Input/Output",},
            1),
    QUESTION_20("What is a process?",
            new String[]{
                    "It's a series of rules used by the OS to execute programs.",
                    "It's a program in execution in memory.",
                    "It's a passive collection of instructions.",
                    "It's a group of threads."},
            2),
    QUESTION_21("What is the most common character-encoding scheme right now?",
            new String[]{
                    "UTF-16",
                    "ASCII",
                    "UTF-8",
                    "UTF-32"},
            3),
    QUESTION_22("What is NOT a type of ROM memory?",
            new String[]{
                    "PROMs",
                    "EPROMs",
                    "EEPROMs",
                    "EEEPROMs"},
            4),
    QUESTION_23("What's NOT a text editor for programmers?",
            new String[]{
                    "NotePad",
                    "Vi",
                    "Emacs",
                    "Vim"},
            1),
    QUESTION_24("What's not a high-level programming language?",
            new String[]{
                    "Python",
                    "Assembly",
                    "Java",
                    "Ruby"},
            2),
    QUESTION_25("What is RegEx used for?",
            new String[]{
                    "To make everyone's life harder.",
                    "To find patterns in text to replace it.",
                    "To find patterns in text to replace or remove them",
                    "To remove unwanted characters."},
            3),
    QUESTION_26("What is a thread?",
            new String[]{
                    "It's the information contained in a variable.",
                    "It's a way of running several commands at once.",
                    "It's how to control the timing of a program.",
                    "It's a sequence of instructions."},
            4),
    QUESTION_27("Which one is NOT a JVM language?",
            new String[]{
                    "Closure",
                    "JRuby",
                    "Jython",
                    "Groovy"},
            1),
    QUESTION_28("What is an algorythm?",
            new String[]{
                    "It's a group of processes.",
                    "It's a set of steps to accomplish a task.",
                    "It's the number of any given classes needed to run a program.",
                    "It's a complex way to protect information."},
            2),
    QUESTION_29("What's the keyword to use to leave a Switch?",
            new String[]{
                    "interrupt;",
                    "continue;",
                    "break;",
                    "leave;"},
            3),
    QUESTION_30("What does Git stand for?",
            new String[]{
                    "Great and important tracker",
                    "Geographic information technology",
                    "Gastrointestinal tract",
                    "Nothing"},
            4),
    QUESTION_31("What does OOP stand for?",
            new String[]{
                    "Object Oriented Programming",
                    "Out Of Place",
                    "Object Oriented Politics",
                    "Order Of Play"},
            1),
    QUESTION_32("What's NOT part of the Java Memory model?",
            new String[]{
                    "Each thread has its own stack.",
                    "Each process has only one thread.",
                    "Local method variables reside on the stack.",
                    "Objects reside on the heap."},
            2),
    QUESTION_33("What is an exception?",
            new String[]{
                    "Something to be excluded from the program",
                    "A reference to be included if a condition is met",
                    "An abnormal event that interrupts the flow of the program instructions",
                    "Something for the JVM to deal with"},
            3),
    QUESTION_34("Which one is not an IDE?",
            new String[]{
                    "IntelliJ",
                    "Eclipse",
                    "Visual Code",
                    "Emacs"},
            4),
    QUESTION_35("Packages will help you to organize your code. Choose what they are NOT used for: ",
            new String[]{
                    "Help with declaring variables",
                    "Avoiding name conflicts",
                    "Hierarchical organization",
                    "Access control"},
            1),
    QUESTION_36("What's not a markup language?",
            new String[]{
                    "XML",
                    "CSS",
                    "HTML",
                    "All of the above are markup languages."},
            2),
    QUESTION_37("What keyword is NOT related to exceptions?",
            new String[]{
                    "try",
                    "finally",
                    "ignore",
                    "catch"},
            3),
    QUESTION_38("What's a limitation of Arrays?",
            new String[]{
                    "Take up too much memory",
                    "Information is deleted",
                    "Elements are arranged randomly",
                    "Fixed-Size"},
            4),
    QUESTION_39("What type of Container is not dynamic?",
            new String[]{
                    "Array",
                    "Linked List",
                    "Map",
                    "Queue"},
            1),
    QUESTION_40("The Queue interface does NOT implement which one of the following methods?",
            new String[]{
                    "offer()",
                    "get()",
                    "peek()",
                    "poll()"},
            2),
    QUESTION_41("Which one is a Java byte stream?",
            new String[]{
                    "PipeStream",
                    "DateOutputStream",
                    "FileInputStream",
                    "ConstantInputStream"
            },
            3),
    QUESTION_42("Which one is a character stream?",
            new String[]{
                    "PrintWriter",
                    "DataStream",
                    "ObjectStream",
                    "BufferedReader"},
            4),
    QUESTION_43("Why Have Code Conventions?",
            new String[]{
                    "90% of the lifetime cost of a piece of software goes to maintenance",
                    "Hardly any software is maintained for its whole life by the original author",
                    "Code conventions improve the readability of the software, allowing engineers to understand new code more quickly and thoroughly.",
                    "If you ship your source code as a product, you need to make sure it is as well packaged and clean as any other product you create"},
            1),
    QUESTION_44("What's NOT a type of computer network?",
            new String[]{
                    "WAN",
                    "WMAN",
                    "LAN",
                    "MAN"},
            2),
    QUESTION_45("Tim Berner Lee invented the three fundamental technologies of the WWW. Which one does not belong?",
            new String[]{
                    "HTTP",
                    "URI",
                    "CSS",
                    "HTML",},
            3),
    QUESTION_46("Which one is not a language used in FrontEnd?",
            new String[]{
                    "HTML",
                    "CSS",
                    "JavaScript",
                    "Assembly"},
            4),
    QUESTION_47("In Bootstrap's grid system, how many columns can you use at the most?",
            new String[]{
                    "12",
                    "8",
                    "4",
                    "2"},
            1),
    QUESTION_48("What are the three types of Thread Pools we know?",
            new String[]{
                    "Single Thread, Multithread",
                    "Fixed Thread Pool, Cached Thread Pool",
                    "Concurrent Threads, Multithreads",
                    "Single Thread, Multiple Threads"},
            2),
    QUESTION_49("How can you create a thread?",
            new String[]{
                    "Extending the Thread class",
                    "Implementing the Runnable interface",
                    "Both of the above",
                    "None of the above"},
            3),
    QUESTION_50("Which one is NOT a category of concurrent programming errors:",
            new String[]{
                    "Visibility",
                    "Atomicity",
                    "Ordering",
                    "Synchronicity"},
            4);
    
    private String question;
    private String[] options;
    private int rightAnswer;
    
    
    /**
     * Constructor for the question itself. Takes three parameters:
     * @param question
     * @param options
     * @param rightAnswer
     */
    Questions(String question, String[] options, int rightAnswer) {
        this.question = question;
        this.options = options;
        this.rightAnswer = rightAnswer;
    }
    
    /**
     * Method to return the question as a String.
     * @return
     */
    public String getQuestion() {
        return question;
    }
    
    /**
     * Method to return an array of Strings to form the options.
     * @return
     */
    public String[] getOptions() {
        return options;
    }
    
    /**
     * Method to return the number (as shown to the player) of the right answer.
     * @return
     */
    public int getRightAnswer() {
        return rightAnswer;
    }
}
