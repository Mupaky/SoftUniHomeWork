package homework.methods;

import java.util.Scanner;

public class PasswordValidator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        // Validate the password
        boolean isValidLength = validateLength(password);
        boolean isValidContent = validateContent(password);
        boolean hasEnoughDigits = validateDigits(password);

        if (isValidLength && isValidContent && hasEnoughDigits) {
            System.out.println("Password is valid");
        }
    }

    public static boolean validateLength(String password) {
        if (password.length() < 6 || password.length() > 10) {
            System.out.println("Password must be between 6 and 10 characters");
            return false;
        }
        return true;
    }

    public static boolean validateContent(String password) {
        for (char ch : password.toCharArray()) {
            if (!Character.isLetterOrDigit(ch)) {
                System.out.println("Password must consist only of letters and digits");
                return false;
            }
        }
        return true;
    }

    public static boolean validateDigits(String password) {
        int digitsCount = 0;
        for (char ch : password.toCharArray()) {
            if (Character.isDigit(ch)) {
                digitsCount++;
            }
        }
        if (digitsCount < 2) {
            System.out.println("Password must have at least 2 digits");
            return false;
        }
        return true;
    }
}
