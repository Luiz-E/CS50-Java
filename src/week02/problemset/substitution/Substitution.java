package week02.problemset.substitution;

import java.util.Scanner;

public class Substitution {
    public static void main(String[] args) {
        String key = args[0].toUpperCase();
        Scanner sc = new Scanner(System.in);
        System.out.print("plaintext: ");
        String plainText = sc.nextLine();
        String cipherText = cipher(plainText, key);
        System.out.println("ciphertext: " + cipherText);
    }

    private static String cipher(String plainText, String key) {
        StringBuilder sb = new StringBuilder("");

        for (char i : plainText.toCharArray()) {
            if (Character.isUpperCase(i)) {
                int charValue = i - 65;
                if (charValue < 0 || charValue > 25) {
                    sb.append(i);
                    continue;
                }
                sb.append(key.charAt(charValue));
            } else {
                int charValue = i - 97;
                if (charValue < 0 || charValue > 25) {
                    sb.append(i);
                    continue;
                }
                sb.append(Character.toLowerCase(key.charAt(charValue)));
            }

        }

        return sb.toString();
    }
}
