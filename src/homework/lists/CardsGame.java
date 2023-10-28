package homework.lists;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstPlayerCards = parseIntegerList(scanner.nextLine());
        List<Integer> secondPlayerCards = parseIntegerList(scanner.nextLine());

        playGame(firstPlayerCards, secondPlayerCards);
    }

    private static List<Integer> parseIntegerList(String input) {
        return Arrays.stream(input.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedList::new)); // Using LinkedList for easier manipulation
    }

    private static void playGame(List<Integer> firstPlayer, List<Integer> secondPlayer) {
        while (!firstPlayer.isEmpty() && !secondPlayer.isEmpty()) {
            int firstCard = firstPlayer.get(0);
            int secondCard = secondPlayer.get(0);

            if (firstCard > secondCard) {
                moveCards(firstPlayer, secondPlayer);
            } else if (secondCard > firstCard) {
                moveCards(secondPlayer, firstPlayer);
            } else {
                firstPlayer.remove(0);
                secondPlayer.remove(0);
            }
        }

        if (firstPlayer.size() > 0) {
            System.out.println("First player wins! Sum: " + sumList(firstPlayer));
        } else {
            System.out.println("Second player wins! Sum: " + sumList(secondPlayer));
        }
    }

    private static void moveCards(List<Integer> winner, List<Integer> loser) {
        winner.add(loser.remove(0)); // Add the loser's card
        winner.add(winner.remove(0)); // Move the winner's card to the end
    }

    private static int sumList(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
