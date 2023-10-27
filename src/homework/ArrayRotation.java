package homework;

import java.util.Scanner;

public class ArrayRotation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Split the input string by space and store in an array
        String[] inputArray = scanner.nextLine().split(" ");
        int rotations = scanner.nextInt();

        for (int i = 0; i < rotations; i++) {
            String firstElement = inputArray[0];

            // Shift elements to the left
            for (int j = 0; j < inputArray.length - 1; j++) {
                inputArray[j] = inputArray[j + 1];
            }

            // Place the first element at the end
            inputArray[inputArray.length - 1] = firstElement;
        }

        // Print the rotated array
        for (String element : inputArray) {
            System.out.print(element + " ");
        }
    }
}
