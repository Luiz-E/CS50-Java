package week02.practiceproblems;

public class novowels {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Error");
            System.exit(1);
        }

        String novowels = args[0]
                .replace('a', '6')
                .replace('e', '3')
                .replace('i', '1')
                .replace('o', '0');
        System.out.println(novowels);
    }
}
