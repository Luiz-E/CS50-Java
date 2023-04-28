package week01.problemset.credit;

public class Card {

    private final int LASTDIGITSEPARATOR = 10;
    private long cardNumber;
    private int length;
    private String type;

    public Card(long cardNumber) {
        this.cardNumber = cardNumber;
        length = setLength();
        type = setType();
    }

    public String getType() {
        return type;
    }

    private int setLength() {
        length = 1;
        for (long i = 10; i <= cardNumber; i *= 10) {
            length++;
        }
        return length;
    }

    public boolean isValid() {
        long sum = doSum();
        return sum % LASTDIGITSEPARATOR == 0;
    }

    private long doSum() {
        long sum = 0;
        int position = 1;
        for (double i = 10; cardNumber / i > 0.1; i *= 10) {

            if (position % 2 != 0) {
                sum += getNumbersWithoutDouble(i);
            } else {
                sum += getNumbersToDouble(i);
            }

            position++;
        }
        return sum;
    }

    private long getNumbersWithoutDouble(double divisor) {
        long removedFinalNumbers = (long) (cardNumber / divisor * 10);
        long removedStartingNumbers = removedFinalNumbers % LASTDIGITSEPARATOR;
        return removedStartingNumbers;
    }

    private long getNumbersToDouble(double divisor) {
        long removedFinalNumbers = (long) (cardNumber / divisor * 10);
        long removedStartingNumbers = removedFinalNumbers % LASTDIGITSEPARATOR;
        long resultDoubled = removedStartingNumbers * 2;
        if (resultDoubled >= 10) {
            resultDoubled = separateNumbers(resultDoubled);
        }
        return resultDoubled;
    }

    private long separateNumbers(long number) {
        return (number / 10) + (number % LASTDIGITSEPARATOR);
    }

    public boolean lengthIsValid() {
        if (this.length < 13 || this.length > 16 || this.length == 14) {
            return false;
        }
        return true;
    }

    private String setType() {
        if (isAmericanExpress()) {
            return "AMEX\n";
        }
        if (isMasterCard()) {
            return "MASTERCARD\n";
        }
        if (isVisa()) {
            return "VISA\n";
        }

        return "INVALID\n";
    }

    private boolean isAmericanExpress() {
        if (length != 15) {
            return false;
        }
        int initialDigits = (int) (cardNumber / positionsToDiscard());
        if (initialDigits == 34 || initialDigits == 37) {
            return true;
        }
        return false;
    }

    private boolean isMasterCard() {
        if (length != 16) {
            return false;
        }
        int initialDigits = (int) (cardNumber / positionsToDiscard());

        if (initialDigits >= 51 && initialDigits <= 55) {
            return true;
        }
        return false;
    }

    private boolean isVisa() {
        if (length != 13 && length != 16) {
            return false;
        }
        int initialDigit = (int) (cardNumber / positionsToDiscard() / 10);
        if (initialDigit == 4) {
            return true;
        }
        return false;
    }

    private long positionsToDiscard() {
        long number = 1;
        for (int i = 0; i < length - 2; i++) {
            number *= 10;
        }
        return number;
    }

}