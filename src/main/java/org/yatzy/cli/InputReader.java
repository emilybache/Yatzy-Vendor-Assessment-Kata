package org.yatzy.cli;

import java.util.Scanner;

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
