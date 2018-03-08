package org.yatzy;

import java.util.List;

public interface YatzyCalculator {

    List<String> validCategories();
    RollInput parseDiceAndCategory(String inputLine);
    int score(List<Integer> dice, YatzyCategory category);
}
