package problemset;

public class Mario {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Incorrect usage");
            System.exit(1);
        }

        int height = Integer.parseInt(args[0]);
        if (height > 8 || height < 1) {
            System.out.println("Incorrect height");
            System.exit(1);
        }

        for (int i = 0; i < height; i++) {
            printLeftSide(i+1, height);
            System.out.print("  ");
            printRightSide(i+1);
            System.out.println();
        }
    }


    public static void printLeftSide(int hashes, int height) {
        for (int i = 0; i < (height - hashes); i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < hashes; i++) {
            System.out.print("#");
        }
    }

    private static void printRightSide(int hashes) {
        for (int i = 0; i < hashes; i++) {
            System.out.print("#");
        }
    }

}
