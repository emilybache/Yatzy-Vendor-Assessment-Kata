Yatzy Rules
===========

The game of Yatzy is a simple dice game. Each player
rolls five six-sided dice. They can re-roll some or all
of the dice up to three times (including the original roll).

The player then places the roll in a category, such as ones,
twos, fives, pair, two pairs etc (see below). If the roll is
compatible with the category, the player gets a score for the
roll according to the rules. If the roll is not compatible
with the category, the player scores zero for the roll.

For example, suppose a player scores 5,6,5,5,2 in the fives
category they would score 15 (three fives). The score for
that go is then added to their total and the category cannot
be used again in the remaining goes for that game.
A full game consists of one go for each category. Thus, for
their last go in a game, a player must choose their only
remaining category.

Your task is to score a GIVEN roll in a GIVEN category.
You do NOT have to program the random dice rolling.
The game is NOT played by letting the computer choose the
highest scoring category for a given roll.

Yatzy Categories and Scoring Rules
----------------------------------

### Chance:
The player scores the sum of all dice, no matter what they read.

### Yatzy:
If all dice have the same number,
the player scores 50 points. Otherwise they score 0.

### Ones, Twos, Threes, Fours, Fives, Sixes:
The player scores the sum of the dice that reads one,
two, three, four, five or six, respectively. The score is 0 if
there is no dice present with that number.

### Pair:
The player scores the sum of the two matching dice. 
If there is more than one pair of matching dice, score the higher of the two.
If there are no pairs of dice with the same number, score 0.

### Two pairs:
If there are two pairs of dice with the same number, the
player scores the sum of these four dice. Otherwise, score 0.

### Three of a kind:
If there are three dice with the same number, the player
scores the sum of these three dice. Otherwise, score 0.

### Four of a kind:
If there are four dice with the same number, the player
scores the sum of these four dice. Otherwise, score 0.

### Small straight:
When placed on "small straight", if the dice read

   1,2,3,4,5,

the player scores 15 (the sum of all the dice). Otherwise, score 0.

### Large straight:
When placed on "large straight", if the dice read

   2,3,4,5,6,

the player scores 20 (the sum of all the dice). Otherwise, score 0.

### Full house:
If the dice are two of a kind and three of a kind, the
player scores the sum of all the dice. Otherwise, score 0.
