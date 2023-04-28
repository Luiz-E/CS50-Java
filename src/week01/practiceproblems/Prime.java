package practiceproblems;

public class Prime {
    public static void main(String[] args) {
        int min = 1;
        int max = 100;
        int count = 0;

        for (int i = min; i < max; i++) {
            if (isPrime(i)) {
                System.out.println(i);
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
