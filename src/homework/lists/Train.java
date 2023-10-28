package homework.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagons = parseWagonList(scanner.nextLine());
        int maxCapacity = Integer.parseInt(scanner.nextLine());

        String command;
        while (!(command = scanner.nextLine()).equals("end")) {
            if (command.startsWith("Add")) {
                int passengers = Integer.parseInt(command.split(" ")[1]);
                wagons.add(passengers);
            } else {
                int passengers = Integer.parseInt(command);
                for (int i = 0; i < wagons.size(); i++) {
                    if (wagons.get(i) + passengers <= maxCapacity) {
                        wagons.set(i, wagons.get(i) + passengers);
                        break;
                    }
                }
            }
        }

        for (int wagon : wagons) {
            System.out.print(wagon + " ");
        }
    }

    private static List<Integer> parseWagonList(String input) {
        List<Integer> wagons = new ArrayList<>();
        String[] tokens = input.split(" ");
        for (String token : tokens) {
            wagons.add(Integer.parseInt(token));
        }
        return wagons;
    }
}
