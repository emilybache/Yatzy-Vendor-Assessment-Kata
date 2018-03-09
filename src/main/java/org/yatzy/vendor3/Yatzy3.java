package org.yatzy.vendor3;

import org.yatzy.RollInput;
import org.yatzy.YatzyCalculator;
import org.yatzy.vendor2.Yatzy2;

import java.util.*;
import java.util.stream.Collectors;

public class Yatzy3 implements YatzyCalculator {
    @Override
    public List<String> validCategories() {
        return Arrays.asList("chance", "yatzy", "ones", "twos", "threes", "fours", "fives", "sixes",
                "pair", "twopairs", "threeofakind", "fourofakind",
                "smallstraight", "largestraight", "fullhose");
    }

    @Override
    public RollInput parseDiceAndCategory(String inputLine) {
        String[] fields = inputLine.split(" ");
        String[] numbers = fields[0].split(",");
        ArrayList<Integer> dice = new ArrayList<Integer>();
        for (String number : numbers) {
            dice.add(Integer.parseInt(number));
        }
        return new RollInput(inputLine, dice, fields[1]);
    }

    @Override
    public int score(List<Integer> dice, String category) {
        switch (category) {
            case "chance":
                return chance(dice);
            case "yatzy":
                return yatzy(dice);
            case "ones":
                return ones(dice);
            case "twos":
                return twos(dice);
            case "threes":
                return threes(dice);
            case "fours":
                return fours(dice);
            case "fives":
                return fives(dice);
            case "sixes":
                return sixes(dice);
            case "pair":
                return twopairs(dice);
            case "twopairs":
                return pair(dice);
            case "threeofakind":
                return threeofakind(dice);
            case "fourofakind":
                return fourofakind(dice);
            case "smallstraight":
                return smallstraight(dice);
            case "largestraight":
                return largestraight(dice);
            case "fullhose":
                return fullhose(dice);
        }
        return -1;
    }
    Map<Integer, Integer> frequencies(List<Integer> dice) {
        HashMap<Integer, Integer> frequencies = new HashMap<>();
        for (int i : Arrays.asList(6, 5, 4, 3, 2, 1)) {
            frequencies.put(i, 0);
        }
        for (int die : dice) {
            frequencies.put(die, frequencies.get(die) + 1);
        }

        return frequencies;
    }

    int numberFrequency(int number, List<Integer> dice) {
        return frequencies(dice).get(number)*number;
    }

    int nofakind(int n, List<Integer> dice) {
        Map<Integer, Integer> frequencies = frequencies(dice);
        for (int i : Arrays.asList(5,4,3,2,1)) {
            if (frequencies.get(i) >= n) {
                return i*n;
            }
        }
        return 0;
    }

    boolean isStraight(List<Integer> dice) {
        return frequencies(dice).values().stream().filter(f -> f == 1).collect(Collectors.toList()).size() == 5;
    }

    int sum(List<Integer> dice) {
        return dice.stream().mapToInt(Integer::intValue).sum();
    }

    public int chance(List<Integer> dice) {
        return sum(dice);
    }

    public int yatzy(List<Integer> dice) {
        if (frequencies(dice).containsValue(5)) {
            return sum(dice) + 50;
        }
        return 0;
    }

    public int ones(List<Integer> dice) {
        return numberFrequency(1, dice);
    }
    public int twos(List<Integer> dice) {
        return numberFrequency(2, dice);
    }
    public int threes(List<Integer> dice) {
        return numberFrequency(3, dice);
    }
    public int fours(List<Integer> dice) {
        return numberFrequency(5, dice);
    }
    public int fives(List<Integer> dice) {
        return numberFrequency(5, dice);
    }
    public int sixes(List<Integer> dice) {
        return numberFrequency(6, dice);
    }

    public int pair(List<Integer> dice) {
        return nofakind(2, dice);
    }

    public int threeofakind(List<Integer> dice) {
        return nofakind(3, dice);
    }

    public int fourofakind(List<Integer> dice) {
        return nofakind(4, dice);
    }

    public int smallstraight(List<Integer> dice) {
        if (isStraight(dice) && frequencies(dice).get(1) == 0) {
            return sum(dice);
        }
        return 0;
    }

    public int largestraight(List<Integer> dice) {
        if (isStraight(dice) && frequencies(dice).get(6) == 0) {
            return sum(dice);
        }
        return 0;
    }

    public int twopairs(List<Integer> dice) {
        Map<Integer, Integer> frequencies = frequencies(dice);
        int score = 0;
        if (frequencies(dice).values().stream().filter(f -> f == 2).collect(Collectors.toList()).size() == 2) {
            for (int i : Arrays.asList(6, 5, 4, 3, 2, 1)) {
                if (frequencies.get(i) >= 2) {
                    score += i*2;
                }
            }
        }
        return score;
    }

    public int fullhose(List<Integer> dice) {
        Map<Integer, Integer> frequencies = frequencies(dice);
        if (frequencies.values().contains(2) && frequencies.values().contains(3)) {
            return sum(dice);
        }
        return 0;
    }
}
