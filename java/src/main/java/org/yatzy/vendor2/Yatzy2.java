package org.yatzy.vendor2;

import org.yatzy.RollInput;
import org.yatzy.YatzyCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Yatzy2 implements YatzyCalculator {

    @Override
    public List<String> validCategories() {
        return Arrays.asList("chance", "yatzy", "ones", "twos", "threes", "fours", "fives", "sixes",
                "pair", "twopairs", "threeofakind", "fourofakind",
                "smallstraight", "largestraight", "fullhouse");
    }

    @Override
    public RollInput parseDiceAndCategory(String inputLine) {
        String[] fields = inputLine.split(" ");
        String[] numbers = fields[0].split(",");
        ArrayList<Integer> dice = new ArrayList<Integer>();
        for (int i = 0; i < numbers.length; i++) {
            dice.add(Integer.parseInt(numbers[i]));
        }
        return new RollInput(inputLine, dice, fields[1]);
    }

    @Override
    public int score(List<Integer> dice, String category) {
        switch (category) {
            case "chance":
                return chance(dice.get(0), dice.get(1), dice.get(2), dice.get(3), dice.get(4));
            case "yatzy":
                return yatzy(dice.get(0), dice.get(1), dice.get(2), dice.get(3), dice.get(4));
            case "ones":
                return ones(dice.get(0), dice.get(1), dice.get(2), dice.get(3), dice.get(4));
            case "twos":
                return twos(dice.get(0), dice.get(1), dice.get(2), dice.get(3), dice.get(4));
            case "threes":
                return threes(dice.get(0), dice.get(1), dice.get(2), dice.get(3), dice.get(4));
            case "fours":
                return new Yatzy2(dice.get(0), dice.get(1), dice.get(2), dice.get(3), dice.get(4)).fours();
            case "fives":
                return new Yatzy2(dice.get(0), dice.get(1), dice.get(2), dice.get(3), dice.get(4)).fives();
            case "sixes":
                return new Yatzy2(dice.get(0), dice.get(1), dice.get(2), dice.get(3), dice.get(4)).sizes();
            case "pair":
                return score_pair(dice.get(0), dice.get(1), dice.get(2), dice.get(3), dice.get(4));
            case "twopairs":
                return two_pair(dice.get(0), dice.get(1), dice.get(2), dice.get(3), dice.get(4));
            case "threeofakind":
                return three_of_a_kind(dice.get(0), dice.get(1), dice.get(2), dice.get(3), dice.get(4));
            case "fourofakind":
                return four_of_a_kind(dice.get(0), dice.get(1), dice.get(2), dice.get(3), dice.get(4));
            case "smallstraight":
                return smallStraight(dice.get(0), dice.get(1), dice.get(2), dice.get(3), dice.get(4));
            case "largestraight":
                return largeStraight(dice.get(0), dice.get(1), dice.get(2), dice.get(3), dice.get(4));
            case "fullhouse":
                return fullHouse(dice.get(0), dice.get(1), dice.get(2), dice.get(3), dice.get(4));
        }
        return 0;
    }

    public static int chance(int d1, int d2, int d3, int d4, int d5)
    {
        int total = 0;
        total += d1;
        total += d2;
        total += d3;
        total += d4;
        total += d5;
        return total;
    }

    public static int yatzy(int... dice)
    {
        int[] counts = new int[6];
        for (int die : dice)
            counts[die-1]++;
        for (int i = 0; i != 6; i++)
            if (counts[i] == 5)
                return 50;
        return 0;
    }

    public static int ones(int d1, int d2, int d3, int d4, int d5) {
        int sum = 0;
        if (d1 == 1) sum++;
        if (d2 == 1) sum++;
        if (d3 == 1) sum++;
        if (d4 == 1) sum++;
        if (d5 == 1)
            sum++;

        return sum;
    }

    public static int twos(int d1, int d2, int d3, int d4, int d5) {
        int sum = 0;
        if (d1 == 2) sum += 2;
        if (d2 == 2) sum += 2;
        if (d3 == 2) sum += 2;
        if (d4 == 2) sum += 2;
        if (d5 == 2) sum += 2;
        return sum;
    }

    public static int threes(int d1, int d2, int d3, int d4, int d5) {
        int s;
        s = 0;
        if (d1 == 3) s += 3;
        if (d2 == 3) s += 3;
        if (d3 == 3) s += 3;
        if (d4 == 3) s += 3;
        if (d5 == 3) s += 3;
        return s;
    }

    protected int[] dice;
    public Yatzy2(int d1, int d2, int d3, int d4, int _5)
    {
        dice = new int[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = _5;
    }

    public int fours()
    {
        int sum;
        sum = 0;
        for (int at = 0; at != 5; at++) {
            if (dice[at] == 4) {
                sum += 4;
            }
        }
        return sum;
    }

    public int fives()
    {
        int s = 0;
        int i;
        for (i = 0; i < dice.length; i++)
            if (dice[i] == 5)
                s = s + 5;
        return s;
    }

    public int sizes()
    {
        int sum = 0;
        for (int at = 0; at < dice.length; at++)
            if (dice[at] == 6)
                sum = sum + 6;
        return sum;
    }

    public static int score_pair(int d1, int d2, int d3, int d4, int d5)
    {
        int[] counts = new int[6];
        counts[d1-1]++;
        counts[d2-1]++;
        counts[d3-1]++;
        counts[d4-1]++;
        counts[d5-1]++;
        int at;
        for (at = 0; at != 6; at++)
            if (counts[6-at-1] >= 2)
                return (6-at)*2;
        return 0;
    }

    public static int two_pair(int d1, int d2, int d3, int d4, int d5)
    {
        int[] counts = new int[6];
        counts[d1-1]++;
        counts[d2-1]++;
        counts[d3-1]++;
        counts[d4-1]++;
        counts[d5-1]++;
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1)
            if (counts[6-i-1] >= 2) {
                n++;
                score += (6-i);
            }
        if (n == 2)
            return score * 2;
        else
            return 0;
    }

    public static int four_of_a_kind(int _1, int _2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[6];
        tallies[_1-1]++;
        tallies[_2-1]++;
        tallies[d3-1]++;
        tallies[d4-1]++;
        tallies[d5-1]++;
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= 4)
                return (i+1) * 4;
        return 0;
    }

    public static int three_of_a_kind(int d1, int d2, int d3, int d4, int d5)
    {
        int[] t;
        t = new int[6];
        t[d1-1]++;
        t[d2-1]++;
        t[d3-1]++;
        t[d4-1]++;
        t[d5-1]++;
        for (int i = 0; i < 6; i++)
            if (t[i] >= 3)
                return (i+1) * 3;
        return 0;
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;
        if (tallies[0] == 1 &&
                tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1)
            return 15;
        return 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;
        if (tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1
                && tallies[5] == 1)
            return 20;
        return 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;




        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i+1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i+1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }


}



