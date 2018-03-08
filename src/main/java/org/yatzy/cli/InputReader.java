package org.yatzy.cli;

import org.yatzy.RollInput;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class InputReader {

    private final Scanner scanner;

    public InputReader() {
        scanner = new Scanner(System.in);
    }

    public boolean hasNext() {
        return scanner.hasNextLine();
    }

    public String nextLine() {
        if (scanner.hasNextLine()){
            String line = scanner.nextLine();
            return line;
        }
        throw new EndOfInputException();
    }
}
