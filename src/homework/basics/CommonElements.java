package homework.basics;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Collections;

public class CommonElements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Split the input strings by space and store in arrays
        String[] firstArray = scanner.nextLine().split(" ");
        String[] secondArray = scanner.nextLine().split(" ");

        // Use a HashSet for faster lookups
        Set<String> set = new HashSet<>();

        // Populate the set with elements from the first array using Collections.addAll()
        Collections.addAll(set, firstArray);

        // Compare elements of the second array with the set and print matches
        for (String element : secondArray) {
            if (set.contains(element)) {
                System.out.print(element + " ");
            }
        }
    }
}

