package week02.practiceproblems;

import java.util.Scanner;

public class Hours {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of weeks taking CS50: ");
        int weeks = sc.nextInt();
        int[] hours = new int[weeks];
        for (int i = 0; i < weeks; i++) {
            System.out.printf("Week %d HW Hours: ", (i + 1));
            hours[i] = sc.nextInt();
        }

        System.out.print("Enter T for total hours, A for average hours per week: ");
        String choice = sc.next();
        int total = 0;
        for (int i = 0; i < weeks; i++) {
            total += hours[i];
        }
        if (choice.equals("T")) {
            System.out.printf("%d hours", total);
        } else if (choice.equals("A")) {
            System.out.printf("%.1f hours", ((double) total / weeks));
        } else {
            System.out.println("Invalid");
        }
    }

}
