package homework.objectsandclasses;

import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfMessages = Integer.parseInt(scanner.nextLine());

        MessageGenerator generator = new MessageGenerator();

        for (int i = 0; i < numberOfMessages; i++) {
            System.out.println(generator.generateRandomMessage());
        }
    }
}

class MessageGenerator {
    private static final String[] PHRASES = {
            "Excellent product.",
            "Such a great product.",
            "I always use that product.",
            "Best product of its category.",
            "Exceptional product.",
            "I can’t live without this product."
    };

    private static final String[] EVENTS = {
            "Now I feel good.",
            "I have succeeded with this product.",
            "Makes miracles. I am happy of the results!",
            "I cannot believe but now I feel awesome.",
            "Try it yourself, I am very satisfied.",
            "I feel great!"
    };

    private static final String[] AUTHORS = {
            "Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"
    };

    private static final String[] CITIES = {
            "Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"
    };

    private Random random = new Random();

    public String generateRandomMessage() {
        String phrase = getRandomElement(PHRASES);
        String event = getRandomElement(EVENTS);
        String author = getRandomElement(AUTHORS);
        String city = getRandomElement(CITIES);

        return String.format("%s %s %s – %s", phrase, event, author, city);
    }

    private String getRandomElement(String[] elements) {
        return elements[random.nextInt(elements.length)];
    }
}
