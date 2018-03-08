package org.yatzy;

import java.util.List;

public class RollInput {
    public final String line;
    public final List<Integer> dice;
    public final YatzyCategory category;

    public RollInput(String line, List<Integer> dice, YatzyCategory category) {
        this.line = line;
        this.dice = dice;
        this.category = category;
    }
}


