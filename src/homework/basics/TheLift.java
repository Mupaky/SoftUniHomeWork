package homework.basics;

import java.util.Scanner;
import java.util.Arrays;

public class TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        int[] wagons = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < wagons.length; i++) {
            int spaceInWagon = 4 - wagons[i];

            if (people >= spaceInWagon) {
                wagons[i] += spaceInWagon;
                people -= spaceInWagon;
            } else {
                wagons[i] += people;
                people = 0;
            }
        }

        if (people == 0 && Arrays.stream(wagons).sum() < 4 * wagons.length) {
            System.out.println("The lift has empty spots!");
            printWagons(wagons);
        } else if (people > 0) {
            System.out.println("There isn't enough space! " + people + " people in a queue!");
            printWagons(wagons);
        } else {
            printWagons(wagons);
        }
    }

    public static void printWagons(int[] wagons) {
        for (int wagon : wagons) {
            System.out.print(wagon + " ");
        }
    }
}
