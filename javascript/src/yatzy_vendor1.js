
function dice_frequencies(dice) {
    let answer = {1:0, 2:0, 3:0, 4:0, 5:0, 6:0};
    dice.forEach(number => answer[number]++);
    return answer
}

function score(dice, category) {
    return scoring_functions[category](dice);
}

scoring_functions = Object.freeze({
    "chance": function chance(dice) {
        sum = 0;
        dice.forEach(number => sum += number);
        return sum;
    },

    "yatzy": function yatzy(dice) {
        let frequencies = Object.values(dice_frequencies(dice));
        if (frequencies.find((n) => n===5))
            return 50;
        else
            return 0;
    },
    "ones": function ones(dice) {
        return 1;
    },

    "twos":4, "threes":5, "fours":6, "fives":7, "sixes":8,
    "pair":9, "threeofakind":10, "fourofakind":11,
    "smallstraight":12, "largestraight":13,
    "twopairs":14, "fullhouse":15
});

function valid_categories() {
    return Object.keys(scoring_functions)
}


module.exports = {
    valid_categories: valid_categories,
    dice_frequencies: dice_frequencies,
    score: score
};