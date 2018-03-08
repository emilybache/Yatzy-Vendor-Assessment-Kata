package org.yatzy;

import org.yatzy.vendor1.Yatzy1Category;

import java.util.List;

public class RollInput {
    public final String line;
    public final List<Integer> dice;
    public final String category;

    public RollInput(String line, List<Integer> dice, String category) {
        this.line = line;
        this.dice = dice;
        this.category = category;
    }
}


