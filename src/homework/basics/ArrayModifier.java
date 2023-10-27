package homework.basics;

import java.util.Scanner;
import java.util.Arrays;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the initial array
        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // Read commands until "end"
        String command;
        while (!(command = scanner.nextLine()).equals("end")) {
            String[] commandParts = command.split(" ");

            switch (commandParts[0]) {
                case "swap":
                    int index1 = Integer.parseInt(commandParts[1]);
                    int index2 = Integer.parseInt(commandParts[2]);
                    int temp = numbers[index1];
                    numbers[index1] = numbers[index2];
                    numbers[index2] = temp;
                    break;
                case "multiply":
                    index1 = Integer.parseInt(commandParts[1]);
                    index2 = Integer.parseInt(commandParts[2]);
                    numbers[index1] *= numbers[index2];
                    break;
                case "decrease":
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i]--;
                    }
                    break;
            }
        }

        // Print the modified array
        for (int i = 0; i < numbers.length; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(numbers[i]);
        }
    }
}
