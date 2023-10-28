package homework.methods;

import java.util.Scanner;

public class MiddleCharacters {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        printMiddleCharacters(input);
    }

    public static void printMiddleCharacters(String text) {
        if (text.length() % 2 == 0) {
            // even length
            System.out.print(text.charAt((text.length() / 2) - 1));
            System.out.println(text.charAt(text.length() / 2));
        } else {
            // odd length
            System.out.println(text.charAt(text.length() / 2));
        }
    }
}
