
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.yatzy.RollInput;
import org.yatzy.vendor1.Yatzy1;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Vendor1Test {

    private Yatzy1 calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Yatzy1();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/valid_rolls_and_categories.csv", delimiter = ';')
    public void valid_rolls_and_categories(String input, int expected) {
        RollInput roll = calculator.parseDiceAndCategory(input);
        assertEquals(expected, calculator.score(roll.dice, roll.category));
    }

}
