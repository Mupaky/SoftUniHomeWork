package homework.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Long> pokemons = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Long::parseLong)
                .collect(Collectors.toList());

        long totalRemovedValue = 0;

        while (!pokemons.isEmpty()) {
            int index = scanner.nextInt();
            long currentValue;

            if (index < 0) {
                currentValue = pokemons.get(0);
                pokemons.set(0, pokemons.get(pokemons.size() - 1));
            } else if (index >= pokemons.size()) {
                currentValue = pokemons.get(pokemons.size() - 1);
                pokemons.set(pokemons.size() - 1, pokemons.get(0));
            } else {
                currentValue = pokemons.remove(index);
            }

            totalRemovedValue += currentValue;

            for (int i = 0; i < pokemons.size(); i++) {
                if (pokemons.get(i) <= currentValue) {
                    pokemons.set(i, pokemons.get(i) + currentValue);
                } else {
                    pokemons.set(i, pokemons.get(i) - currentValue);
                }
            }
        }

        System.out.println(totalRemovedValue);
    }
}
