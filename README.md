Yatzy Vendor Assessment Kata
============================

Your employer, "Fun & Games AB" are developing a new product. They have decided to outsource 
part of the development to a third party vendor. There are three competing vendors. Your 
job is to assess a sample of their work and recommend which vendor to select. The three samples 
have been anonymized and are called Yatzy1, Yatzy2 and Yatzy3. 

You are free to perform any kind of testing you wish on the three competing implementations, 
when making your assessment.

Requirements
------------
All three implementations should:

- follow the Yatzy scoring rules explained in [yatzy_rules.md](https://github.com/emilybache/Yatzy-Vendor-Assessment-Kata/blob/master/yatzy_rules.md)
- calculate the Yatzy score for a given roll of 5 dice in a given category. 
- provide a list of available categories.
- accept input in the format: "d1,d2,d3,d4,d5 category" where d1 etc are the dice values and 'category' is the name of the category to score

Running on the Command Line
---------------------------

Each implementation has a command-line interface. You can run it via maven.

View help text:

    mvn exec:java -Dexec.mainClass="org.yatzy.cli.CliAdapterYatzy1" -Dexec.args="--help"

Calculate scores for input found in the stdin_sample.txt file:

	mvn exec:java -Dexec.mainClass="org.yatzy.cli.CliAdapterYatzy1" < src/test/resources/stdin_sample.txt

Replace "CliAdapterYatzy1" with "CliAdapterYatzy2" or "CliAdapterYatzy3" to test the three competing implementations.
Modify the input file as needed for testing.

Writing Tests Using JUnit
-------------------------

This is another option for writing tests. There is some test code to start you off, in "Vendor1Test" under `src/test/java`.
It uses a file to parameterize the tests. Look at 'valid_rolls_and_categories.csv' under `src/test/resources`
This file contains the input the yatzy calculator should accept on the command line, and the expected score.

