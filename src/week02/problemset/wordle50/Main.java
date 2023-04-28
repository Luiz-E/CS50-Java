package week02.problemset.wordle50;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

    // each of our text files contains 1000 words
    private static final int LIST_SIZE = 1000;

    // values for colors and score (EXACT == right letter, right place; CLOSE == right letter, wrong place; WRONG == wrong letter)
    private static final int EXACT = 2;
    private static final int CLOSE = 1;
    private static final int WRONG = 0;

    // ANSI color codes for boxed in letters
    private static final String GREEN = "\u001B[42m\033[30m";
    private static final String YELLOW = "\u001B[43m\033[30m";
    private static final String RED = "\u001B[41m\033[30m";
    private static final String RESET = "\u001B[0m";


    public static void main(String[] args) throws IOException {
        // ensure proper usage
        // TODO #1

        if (args.length == 0) {
            System.out.println("Not enough arguments");
            System.exit(1);
        }

        int wordSize = 5;

        // ensure argv[1] is either 5, 6, 7, or 8 and store that value in wordsize instead
        // TODO #2
        wordSize = Integer.parseInt(args[0]);
        if (wordSize < 5 || wordSize > 8) {
            System.exit(1);
        }

        // open correct file, each file has exactly LISTSIZE words

        String wl_filename;

        wl_filename = "C:\\Users\\luize\\Documents\\Cursos\\CS50\\src\\week02\\problemset\\wordle50\\" + wordSize + ".txt";
        File wordList = new File(wl_filename);
        FileInputStream inputStream = new FileInputStream(wordList);
        if (wordList == null) {
            System.out.println("Error opening file %s.\n" + wl_filename);
            System.exit(1);
        }

        // load word file into an array of size LISTSIZE
        byte[][] options = new byte[LIST_SIZE][wordSize + 2];

        for (int i = 0; i < LIST_SIZE; i++) {
            inputStream.read(options[i]);
        }

        // pseudorandomly select a word for this game
        int randPosition = (int) (Math.random() * LIST_SIZE);
        String choice = new String(options[randPosition], StandardCharsets.UTF_8);
        System.out.println(choice);
        // allow one more guess than the length of the word
        int guesses = wordSize + 1;
        boolean won = false;

        // print greeting, using ANSI color codes to demonstrate
        System.out.println(GREEN + "This is WORDLE50" + RESET);
        System.out.printf("You have %d tries to guess the %d-letter word I'm thinking of\n", guesses, wordSize);

        // main game loop, one iteration for each guess
        for (int i = 0; i < guesses; i++) {
            // obtain user's guess
            String guess = getGuess(wordSize);

            // array to hold guess status, initially set to zero
            int[] status = new int[wordSize];

            // set all elements of status array initially to 0, aka WRONG
            // TODO #4
            for (int j = 0; j < status.length; j++) {
                status[j] = WRONG;
            }

            // Calculate score for the guess
            int score = checkWord(guess, wordSize, status, choice);

            System.out.printf("Guess %d: ", i + 1);

            // Print the guess
            printWord(guess, wordSize, status);

            // if they guessed it exactly right, set terminate loop
            if (score == EXACT * wordSize) {
                won = true;
                break;
            }
        }

        // Print the game's result
        // TODO #7
        if (won) {
            System.out.print(GREEN + "You Won!");
        } else {
            System.out.printf("The word was %s", choice);
        }
        // that's all folks!
        System.exit(0);
    }


    public static String getGuess(int wordSize) {

        String guess;
        Scanner sc = new Scanner(System.in);
        // ensure users actually provide a guess that is the correct length
        // TODO #3
        do {
            System.out.printf("Input a %d-letter word: ", wordSize);
            guess = sc.nextLine();
        } while (guess.length() != wordSize);

        return guess;
    }

    public static int checkWord(String guess, int wordSize, int status[], String choice) {
        int score = 0;

        // compare guess to choice and score points as appropriate, storing points in status
        // TODO #5

        for (int i = 0; i < wordSize; i++) {
            for (int j = 0; j < wordSize; j++) {
                if (guess.charAt(i) != choice.charAt(j)) {
                    continue;
                }
                if (i == j) {
                    status[i] = EXACT;
                    break;
                } else {
                    status[i] = CLOSE;
                }
            }
        }

        for (int i = 0; i < wordSize; i++) {
            score += status[i];
        }

        // HINTS
        // iterate over each letter of the guess
        // iterate over each letter of the choice
        // compare the current guess letter to the current choice letter
        // if they're the same position in the word, score EXACT points (green) and break so you don't compare that letter further
        // if it's in the word, but not the right spot, score CLOSE point (yellow)
        // keep track of the total score by adding each individual letter's score from above

        return score;
    }

    public static void printWord(String guess, int wordsize, int status[]) {
        // print word character-for-character with correct color coding, then reset terminal font to normal
        // TODO #6

        for (int i = 0; i < wordsize; i++) {
            switch (status[i]) {
                case 0:
                    System.out.print(RED + guess.charAt(i));
                    break;
                case 1:
                    System.out.print(YELLOW + guess.charAt(i));
                    break;
                case 2:
                    System.out.print(GREEN + guess.charAt(i));
                    break;
            }
        }

        System.out.println(RESET);
        return;
    }

}