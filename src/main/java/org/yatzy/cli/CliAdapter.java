package org.yatzy.cli;

import org.yatzy.RollInput;
import org.yatzy.YatzyCalculator;

import java.util.Arrays;

public class CliAdapter {

    public static void main(String[] args, YatzyCalculator yatzy) {
        if (args.length > 0 && "--help".equals(args[0])) {
            String helptext = "Yatzy calculator program.\n" +
                    "\n" +
                    "You should pass dice rolls to standard input, formatted as one roll of five dice followed by the category to score:\n" +
                    "\n" +
                    "1,2,3,4,5 <category>\n" +
                    "1,2,2,3,3 <category>\n" +
                    "\n" +
                    "where <category> should be one of:\n" +
                    "\n" +
                    yatzy.validCategories() + "\n" +
                    "\n" +
                    "This program will then print the calculated score to standard output, and any error messages to standard error.\n";

            System.out.println(helptext);
            System.exit(0);
        }

        InputReader rollReader = new InputReader();
        while (rollReader.hasNext()) {
            String inputLine = rollReader.nextLine();
            RollInput roll = yatzy.parseDiceAndCategory(inputLine);
            int score = yatzy.score(roll.dice, roll.category);
            System.out.println("[" + roll.line.trim() + "] \"" + roll.category + "\": " + score);
        }
    }
}
