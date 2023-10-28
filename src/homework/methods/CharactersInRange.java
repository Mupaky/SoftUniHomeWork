package homework.methods;

import java.util.Scanner;

public class CharactersInRange {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char startChar = scanner.nextLine().charAt(0);
        char endChar = scanner.nextLine().charAt(0);

        printCharsInRange(startChar, endChar);
    }

    public static void printCharsInRange(char ch1, char ch2) {
        // Determine which character comes first based on ASCII value
        char start = ch1 < ch2 ? ch1 : ch2;
        char end = ch1 > ch2 ? ch1 : ch2;

        // Print characters between start and end
        for (char ch = (char) (start + 1); ch < end; ch++) {
            System.out.print(ch + " ");
        }
    }
}
