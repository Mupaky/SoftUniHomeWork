package homework.lists.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnonymousThreatTest {

    public static void main(String[] args) {
        testMerge();
        testDivide();
        testMergeAndDivide();
        System.out.println("All tests passed!");
    }

    private static void testMerge() {
        assertOutput("abc def ghi", "merge 0 1", "abcdef ghi");
        assertOutput("a b c d e", "merge 0 4", "abcde");
        assertOutput("apple orange banana", "merge 0 2", "appleorangebanana");
        assertOutput("apple orange banana", "merge 1 3", "apple orangebanana");
    }

    private static void testDivide() {
        assertOutput("abcdef ghi jkl", "divide 0 3", "ab cd ef ghi jkl");
        assertOutput("abcdef", "divide 0 4", "a b cd ef");
        assertOutput("abcd efgh ijkl", "divide 0 3", "a b cd efgh ijkl");
    }

    private static void testMergeAndDivide() {
        assertOutput("abc def ghi", new String[]{"merge 0 1", "divide 0 2"}, "abc d efghi");
        assertOutput("a b c d e", new String[]{"divide 0 2", "merge 0 1"}, "a b cde");
        assertOutput("apple orange banana", new String[]{"merge 0 2", "divide 0 2"}, "appleo rangebanana");
        assertOutput("apple orange banana", new String[]{"divide 0 2", "merge 1 2"}, "app leorangebanana");
    }

    private static void assertOutput(String input, String command, String expectedOutput) {
        assertOutput(input, new String[]{command}, expectedOutput);
    }

    private static void assertOutput(String input, String[] commands, String expectedOutput) {
        List<String> data = new ArrayList<>(Arrays.asList(input.split(" ")));

        for (String command : commands) {
            String[] parts = command.split(" ");

            if ("merge".equals(parts[0])) {
                int startIndex = Integer.parseInt(parts[1]);
                int endIndex = Integer.parseInt(parts[2]);
                AnonymousThreat.merge(data, startIndex, endIndex);
            } else if ("divide".equals(parts[0])) {
                int index = Integer.parseInt(parts[1]);
                int partitions = Integer.parseInt(parts[2]);
                AnonymousThreat.divide(data, index, partitions);
            }
        }

        StringBuilder result = new StringBuilder();
        for (String item : data) {
            result.append(item).append(" ");
        }

        if (!expectedOutput.equals(result.toString().trim())) {
            throw new AssertionError("Expected \"" + expectedOutput + "\" but got \"" + result.toString().trim() + "\"");
        }
    }
}

