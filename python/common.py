import sys


def main(args, yatzy):
    if len(args) > 0 and "--help" == args[0]:
        helptext = f"""\
Yatzy calculator program.

You should pass dice rolls to standard input, formatted as one roll of five dice followed by the category to score:
1,2,3,4,5 <category>
1,2,2,3,3 <category>

where <category> should be one of:

{yatzy.valid_categories()}

This program will then print the calculated score to standard output, and any error messages to standard error.
"""

        print(helptext)
        sys.exit(0)

    for inputLine in sys.stdin:
        if not inputLine.strip():
            continue
        line, dice, category_name = yatzy.parse_dice_and_category(inputLine)
        score = yatzy.score(dice, category_name)
        print("[" + line + "] \"" + category_name + "\": " + score)