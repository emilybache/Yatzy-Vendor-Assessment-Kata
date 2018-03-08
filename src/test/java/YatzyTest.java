import org.junit.Before;
import org.junit.Test;
import org.yatzy.Yatzy1;
import org.yatzy.YatzyCategory;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class YatzyTest {

    private Yatzy1 calculator;

    @Test
    public void test1() {
        List<Integer> dice = Arrays.asList(1,1,1,1,1);
        int score = new Yatzy1().score(dice, YatzyCategory.chance);
        assertEquals(5, score);
    }

    @Test
    public void testChance() {
        List<Integer> dice = Arrays.asList(1,1,1,1,1);
        int score = new Yatzy1().score(dice, YatzyCategory.chance);
        assertEquals(5, score);
    }

    @Before
    public void setUp() {
        calculator = new Yatzy1();
    }

    private void assertScore(int expected, YatzyCategory category, Integer... dice) {
        assertEquals(expected, calculator.score(Arrays.asList(dice), category));
    }

    @Test
    public void chanceSumsTheDice() {
        assertScore(5, YatzyCategory.chance, 1,1,1,1,1);
    }

    @Test
    public void yatzyWithSameDiceGives50() {
        assertScore(50, YatzyCategory.yatzy, 1,1,1,1,1);
    }

    @Test
    public void yatzyWithDifferentDiceGives0() {
        assertScore(0, YatzyCategory.yatzy, 1,1,1,1,2);
    }

    @Test
    public void score_Chance_Sums_The_Dice() {
        List<Integer> dice = Arrays.asList(1,1,1,1,1);
        int score = new Yatzy1().score(dice, YatzyCategory.chance);
        assertEquals(5, score);
    }

    @Test
    public void given_all_ones_score_chance_returns_5() {
        List<Integer> dice = Arrays.asList(1,1,1,1,1);
        int score = new Yatzy1().score(dice, YatzyCategory.chance);
        assertEquals(5, score);
    }

    @Test
    public void any_dice_score_chance_gives_sum() {
        List<Integer> dice = Arrays.asList(1,1,1,1,1);
        int score = new Yatzy1().score(dice, YatzyCategory.chance);
        assertEquals(5, score);
    }

    @Test
    public void score_any_dice_chance_gives_sum() {
        List<Integer> dice = Arrays.asList(1,1,1,1,1);
        int score = new Yatzy1().score(dice, YatzyCategory.chance);
        assertEquals(6, score);
    }

}
