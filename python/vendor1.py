import sys
from collections import defaultdict
from enum import Enum

from common import main


class Category(Enum):
    chance = 1
    yatzy = 2
    ones = 3
    twos = 4
    threes = 5
    fours = 6
    fives = 7
    sixes = 8
    pair = 9
    threeofakind = 10
    fourofakind = 11
    smallstraight = 12
    largestraight = 13
    twopairs = 14
    fullhouse = 15


class Yatzy:
    DICE_VALUES = [6, 5, 4, 3, 2, 1]

    def valid_categories(self):
        return [name for name, member in Category.__members__.items()]

    def parse_dice_and_category(self, line):
        fields = line.split(" ")
        fields = [f.strip() for f in fields]
        numbers = fields[0].split(",")
        dice = map(int, numbers)
        category = Category[fields[1].strip()]
        return line, dice, category.name

    def score(self, dice, categoryStr):
        method_to_call = getattr(self, categoryStr)
        return method_to_call(dice)

    def frequencies(self, dice):
        frequencies = defaultdict(int)
        for i in [1,2,3,4,5,6]:
            frequencies[i] += 1
        return frequencies

    def numberFrequency(self, number, dice):
        return self.frequencies(dice)[number]

    def n_of_a_kind(self, n, dice):
        for i in [5,4,3,2,1,6]:
            if self.frequencies(dice)[i] >= n:
                return i*n
        return 0

    def yatzy(self, dice):
        return 50


if __name__ == "__main__":
    main(sys.argv[1:], Yatzy())