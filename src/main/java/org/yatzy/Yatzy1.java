package org.yatzy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Yatzy1 implements YatzyCalculator {

    @Override
    public List<String> validCategories() {
        return Arrays.stream(YatzyCategory.values()).map(elt -> elt.toString()).collect(Collectors.toList());
    }

    @Override
    public RollInput parseDiceAndCategory(String line) {
        String[] fields = line.split(" ");
        String[] numbers = fields[0].split(",");
        List<Integer> dice = Arrays.asList(numbers).stream()
                .map(elt -> Integer.parseInt(elt))
                .collect(Collectors.toList());
        YatzyCategory category = YatzyCategory.valueOf(fields[1]);
        return new RollInput(line, dice, category);
    }

    @Override
    public int score(List<Integer> dice, YatzyCategory category) {
        return dice.stream().mapToInt(Integer::intValue).sum();
    }
}

