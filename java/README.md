Yazy Vendor Assessment Kata Java Version
=========================================

In this folder you find java code and a maven/gradle project. 
Each implementation has a command-line interface. 

## Maven

Build the project:

	mvn verify

View help text:

	mvn exec:java -Dexec.mainClass="org.yatzy.cli.CliAdapterYatzy1" -Dexec.args="--help"

Calculate scores for input found in the stdin_sample.txt file:

	mvn exec:java -Dexec.mainClass="org.yatzy.cli.CliAdapterYatzy1" < src/test/resources/stdin_sample.txt

Replace "CliAdapterYatzy1" with "CliAdapterYatzy2" or "CliAdapterYatzy3" to test the three competing implementations.
Modify the input file as needed for testing.

## Gradle

Build the project:

	gradlew build

View help text:   

	java -jar build/libs/Yatzy-Vendor-Assessment-Kata-1.0.0-SNAPSHOT.jar --help

Calculate scores for input found in the stdin_sample.txt file:

	java -jar build/libs/Yatzy-Vendor-Assessment-Kata-1.0.0-SNAPSHOT.jar < src/test/resources/stdin_sample.txt


Replace "CliAdapterYatzy1" with "CliAdapterYatzy2" or "CliAdapterYatzy3" in build.gradle to test the three competing implementations.
Don't forget to rebuild the project!

Writing Tests Using JUnit
-------------------------

This is another option for writing tests. There is some test code to start you off, in "Vendor1Test" under `src/test/java`.
It uses a file to parameterize the tests. Look at 'valid_rolls_and_categories.csv' under `src/test/resources`
This file contains the input the yatzy calculator should accept on the command line, and the expected score.

