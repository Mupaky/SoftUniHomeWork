package homework.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChangeList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = parseIntegerList(scanner.nextLine());

        processCommands(scanner, numbers);

        printList(numbers);
    }

    private static List<Integer> parseIntegerList(String input) {
        List<Integer> numbers = new ArrayList<>();
        String[] tokens = input.split(" ");
        for (String token : tokens) {
            numbers.add(Integer.parseInt(token));
        }
        return numbers;
    }

    private static void processCommands(Scanner scanner, List<Integer> numbers) {
        String command;
        while (!(command = scanner.nextLine()).equals("end")) {
            String[] commandParts = command.split(" ");
            switch (commandParts[0]) {
                case "Delete":
                    deleteElement(numbers, Integer.parseInt(commandParts[1]));
                    break;
                case "Insert":
                    insertElement(numbers, Integer.parseInt(commandParts[1]), Integer.parseInt(commandParts[2]));
                    break;
            }
        }
    }

    private static void deleteElement(List<Integer> numbers, int element) {
        numbers.removeAll(List.of(element));
    }

    private static void insertElement(List<Integer> numbers, int element, int position) {
        if (position >= 0 && position < numbers.size()) {
            numbers.add(position, element);
        }
    }

    private static void printList(List<Integer> numbers) {
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
