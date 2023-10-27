import java.util.Scanner;

public class Train {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Read the number of wagons
        int n = scanner.nextInt();

        // Step 2: Initialize an array of size n
        int[] train = new int[n];

        int sum = 0;  // This will store the total number of people on the train

        // Step 3: Loop through each wagon and read the number of people
        for (int i = 0; i < n; i++) {
            train[i] = scanner.nextInt();
            sum += train[i];
        }

        // Step 4: Print the entire train
        for (int i = 0; i < n; i++) {
            System.out.print(train[i] + " ");
        }
        System.out.println();

        // Print the total number of people on the train
        System.out.println(sum);
    }
}
