package week02.labs;

import java.awt.*;
import java.util.Scanner;

public class scrabble {
    // Points assigned to each letter of the alphabet
    static final int POINTS[] = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};

    public static void main(String[] args) {
        // Get input words from both players
        Scanner sc = new Scanner(System.in);

        System.out.print("Player 1: ");
        String word1 = sc.next();
        System.out.print("Player 2: ");
        String word2 = sc.next();

        int score1 = compute_score(word1);
        int score2 = compute_score(word2);

        if (score2 == score1) {
            System.out.println("Tie!");
        } else {
            System.out.printf("Player %d wins", (score1 > score2 ? 1 : 2));
        }
    }

    public static int compute_score(String word) {
        word = word.toUpperCase();
        int point = 0;
        char[] characters = word.toCharArray();
        for (char ch : characters) {
            int i = ch - 65;
            if (i < 0 || i > 25) {
                point += 0;
                continue;
            }
            point += POINTS[i];
        }
        return point;
    }

}
