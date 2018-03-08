import org.junit.Before;
import org.junit.Test;
import org.yatzy.Yatzy1;
import org.yatzy.YatzyCalculator;
import org.yatzy.YatzyCategory;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class YatzyTest {

    private YatzyCalculator calculator;

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


}
