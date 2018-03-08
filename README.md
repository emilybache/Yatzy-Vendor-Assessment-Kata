Yatzy Vendor Assessment Kata
============================

Your employer, "Fun & Games AB" are developing a new product. They have decided to outsource part of the development to a third party vendor. There are three competing vendors. Your job is to assess a sample of their work and recommend which vendor to select. The three samples have been anonymized and are called Yatzy1, Yatzy2 and Yatzy3. All three of them should implement the Yatzy rules listed in yatzy_rules.md.

You are free to perform any kind of testing you wish on the three competing implementations, when making your assessment.

In order to make the assessment as fair as possible, there is a unified command-line interface you can use to access any one of the implementations. You can run the main class through your IDE, or via maven, for example:

	mvn exec:java -Dexec.mainClass="org.yatzy.cli.CliAdapterYatzy1" < src/it/texttest/Chance/stdin.yatzy

Replace CliAdapterYatzy1 with CliAdapterYatzy2 or CliAdapterYatzy3, and modify the input file as needed.

Using TextTest
==============

Included in the maven build are (incomplete) regression tests using [TextTest](http://texttest.org). I recommend that you inspect the test results using the TextTest IDE. You can start it with this command:

	texttest -a yatzy -c $PWD -d $PWD/src/it/texttest 

Note that $PWD should automatically expand to the complete path to the current working directory. If it does not, insert it by hand instead.

You can switch version from Yatzy1 to Yatzy2 and Yatzy3 by changing the 'executable' listed in src/it/texttest/config.yatzy.
