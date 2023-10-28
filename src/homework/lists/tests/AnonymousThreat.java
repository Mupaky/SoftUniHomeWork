package homework.lists.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnonymousThreat {
    static List<String> data;

    // Merge elements from startIndex to endIndex.
    public static void merge(List<String> data, int startIndex, int endIndex) {
        startIndex = Math.max(0, startIndex); // Ensure startIndex is not negative
        endIndex = Math.min(data.size() - 1, endIndex); // Ensure endIndex doesn't exceed the list size

        StringBuilder mergedData = new StringBuilder();
        for (int i = startIndex; i <= endIndex; i++) {//dsad
            mergedData.append(data.get(i));
        }

        // Remove the merged items from the list
        for (int i = endIndex; i >= startIndex; i--) {
            data.remove(i);
        }

        // Add the concatenated result back to the list at the starting position
        data.add(startIndex, mergedData.toString());
    }

    // Divide the element at the given index into partitions
    public static void divide(List<String> data, int index, int partitions) {
        if (index < 0 || index >= data.size() || partitions <= 0) {
            return;
        }

        String toDivide = data.get(index);
        int length = toDivide.length();

        int partSize = length / partitions;
        int largerPartSize = partSize + (length % partitions);

        List<String> newParts = new ArrayList<>();
        for (int i = 0; i < partitions; i++) {
            if (i == partitions - 1) { // for the last partition
                newParts.add(toDivide.substring(i * partSize));
            } else {
                newParts.add(toDivide.substring(i * partSize, i * partSize + partSize));
            }
        }

        data.remove(index);  // Remove the original string
        data.addAll(index, newParts);  // Add the divided strings
    }


    // Process the given command
    public static void processCommand(List<String> data, String command) {
        String[] parts = command.split(" ");

        if ("merge".equals(parts[0])) {
            int startIndex = Integer.parseInt(parts[1]);
            int endIndex = Integer.parseInt(parts[2]);
            merge(data, startIndex, endIndex);
        } else if ("divide".equals(parts[0])) {
            int index = Integer.parseInt(parts[1]);
            int partitions = Integer.parseInt(parts[2]);
            divide(data, index, partitions);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        data = new ArrayList<>();

        String[] inputStrings = scanner.nextLine().split(" ");
        for (String s : inputStrings) {
            data.add(s);
        }

        String command = scanner.nextLine();
        while (!"3:1".equals(command)) {
            processCommand(data, command);
            command = scanner.nextLine();
        }

        for (String s : data) {
            System.out.print(s + " ");
        }
    }
}

