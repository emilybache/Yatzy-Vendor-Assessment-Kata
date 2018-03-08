package org.yatzy.vendor1;

import org.yatzy.RollInput;
import org.yatzy.YatzyCalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Yatzy1 implements YatzyCalculator {

    @Override
    public List<String> validCategories() {
        return Arrays.stream(Yatzy1Category.values()).map(elt -> elt.toString()).collect(Collectors.toList());
    }

    @Override
    public RollInput parseDiceAndCategory(String line) {
        String[] fields = line.split(" ");
        String[] numbers = fields[0].split(",");
        List<Integer> dice = Arrays.asList(numbers).stream()
                .map(elt -> Integer.parseInt(elt))
                .collect(Collectors.toList());
        Yatzy1Category category = Yatzy1Category.valueOf(fields[1]);
        return new RollInput(line, dice, category.name());
    }

    @Override
    public int score(List<Integer> dice, String categoryStr) {
        Yatzy1Category category = Yatzy1Category.valueOf(categoryStr);
        return dice.stream().mapToInt(Integer::intValue).sum();
    }
}

