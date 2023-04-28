package week02.practiceproblems;

import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        String[] regex = {".*[a-z]+.*", ".*[A-Z]+.*", ".*[0-9]+.*", ".*[!$#].*"};
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your password: ");
        String password = sc.next();
        for (String reg : regex) {
            System.out.println(password.matches(reg));
        }

    }
}
