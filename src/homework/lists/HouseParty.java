package homework.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<String> guests = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            processCommand(scanner.nextLine(), guests);
        }

        printGuestList(guests);
    }

    private static void processCommand(String command, List<String> guests) {
        String[] tokens = command.split("\\s+", 2);
        String name = tokens[0];
        String action = tokens[1];

        if (action.equals("is going!")) {
            addGuest(name, guests);
        } else if (action.equals("is not going!")) {
            removeGuest(name, guests);
        }
    }

    private static void addGuest(String name, List<String> guests) {
        if (guests.contains(name)) {
            System.out.println(name + " is already in the list!");
        } else {
            guests.add(name);
        }
    }

    private static void removeGuest(String name, List<String> guests) {
        if (guests.contains(name)) {
            guests.remove(name);
        } else {
            System.out.println(name + " is not in the list!");
        }
    }

    private static void printGuestList(List<String> guests) {
        for (String guest : guests) {
            System.out.println(guest);
        }
    }
}

