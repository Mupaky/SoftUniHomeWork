package homework.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppendArrays {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputArrays = scanner.nextLine().split("\\|");

        List<String> resultList = appendArrays(inputArrays);

        for (String value : resultList) {
            System.out.print(value + " ");
        }
    }

    private static List<String> appendArrays(String[] inputArrays) {
        List<String> result = new ArrayList<>();

        for (int i = inputArrays.length - 1; i >= 0; i--) {
            String[] values = inputArrays[i].trim().split("\\s+");
            for (String value : values) {
                if (!value.isEmpty()) {
                    result.add(value);
                }
            }
        }

        return result;
    }
}
