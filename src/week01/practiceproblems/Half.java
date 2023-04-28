package practiceproblems;

import java.util.Scanner;

public class Half {

    public static final int HUNDRED = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Bill before tax and tip: ");

        double bill = sc.nextDouble();

        System.out.print("Sale Tax Percent: ");

        double tax = sc.nextDouble();

        System.out.print("Tip percent: ");

        int tip = sc.nextInt();

        double halfBill = calculateBill(bill, tax, tip);
        System.out.printf("You will owe $%.2f each!", halfBill);

        sc.close();
    }

    public static double calculateBill (double bill, double tax, int tip) {

        double billValue = bill + (bill * tax / HUNDRED);
        double tipValue = billValue * ((double) tip / HUNDRED);
        return (billValue + tipValue) / 2;
    }


}
