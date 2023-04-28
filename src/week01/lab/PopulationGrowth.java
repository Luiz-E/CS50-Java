package lab;

import java.util.Scanner;

public class PopulationGrowth {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int years = 0;
        int initial;
        do {
            System.out.print("Insert the starting size: ");
            initial = sc.nextInt();
        } while (initial < 9);

        int end;
        do {
            System.out.print("Insert the ending size: ");
            end = sc.nextInt();
        } while (end < initial);

        int population = initial;

        while (population < end) {
            int newBorn = population / 3;
            int passAway = population / 4;
            population = population + newBorn - passAway;
            years++;
        }

        System.out.println("years: " + years);

        sc.close();
    }

}
