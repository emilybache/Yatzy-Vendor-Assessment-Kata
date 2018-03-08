import org.junit.Before;
import org.junit.Test;
import org.yatzy.vendor1.Yatzy1;
import org.yatzy.YatzyCalculator;
import org.yatzy.vendor1.Yatzy1Category;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class YatzyTest {

    private YatzyCalculator calculator;

    @Before
    public void setUp() {
        calculator = new Yatzy1();
    }

    private void assertScore(int expected, String category, Integer... dice) {
        assertEquals(expected, calculator.score(Arrays.asList(dice), category));
    }

    @Test
    public void chanceSumsTheDice() {
        assertScore(5, "chance", 1,1,1,1,1);
    }


}
