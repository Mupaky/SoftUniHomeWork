import java.util.Scanner;

public class ZigZagArrays {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] firstArray = new int[n];
        int[] secondArray = new int[n];

        for (int i = 0; i < n; i++) {
            int firstNumber = scanner.nextInt();
            int secondNumber = scanner.nextInt();

            if (i % 2 == 0) {  // even index
                firstArray[i] = firstNumber;
                secondArray[i] = secondNumber;
            } else {  // odd index
                firstArray[i] = secondNumber;
                secondArray[i] = firstNumber;
            }
        }

        for (int num : firstArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        for (int num : secondArray) {
            System.out.print(num + " ");
        }
    }
}
