package week01.problemset.credit;

import java.util.Scanner;

public class Credit {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Number: ");

        Card card = new Card(sc.nextLong());

        if (!card.isValid() || !card.lengthIsValid()) {
            System.out.print("INVALID\n");
            System.exit(1);
        }

        System.out.print("INVALID\n");

        System.out.printf(card.getType());

    }
}
