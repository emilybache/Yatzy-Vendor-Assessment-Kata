
function dice_frequencies(dice) {
    let answer = {1:0, 2:0, 3:0, 4:0, 5:0, 6:0};
    dice.forEach(number => answer[number]++);
    return answer
}

function score(dice, category) {
    return scoring_functions[category](dice);
}

function number_frequency(number, dice) {
    return dice_frequencies(dice)[number]*number;
}

function n_of_a_kind(n, dice) {
    const frequencies = dice_frequencies(dice);
    let scores = [5, 4, 3, 2, 1, 6].map( (dice_value) => {
        if (frequencies[dice_value] >= n)
            return n*dice_value;
        else
            return 0;
    } );
    scores = scores.filter( (score) => score > 0);
    return scores.length > 0 ? scores[0] : 0;
}

function is_straight(dice) {
    return Object.values(dice_frequencies(dice)).filter( (n) => n === 1).length === 5
}

scoring_functions = Object.freeze({
    "chance": function chance(dice) {
        sum = 0;
        dice.forEach(number => sum += number);
        return sum;
    },

    "yatzy": function yatzy(dice) {
        let frequencies = Object.values(dice_frequencies(dice));
        if (frequencies.find((n) => n === 5))
            return 50;
        else
            return 0;
    },

    "ones": dice => number_frequency(1, dice),

    "twos": dice => number_frequency(2, dice),

    "threes": dice => number_frequency(3, dice),

    "fours": dice => number_frequency(4, dice),

    "fives": dice => number_frequency(5, dice),

    "sixes": dice => number_frequency(5, dice),

    "pair": dice => n_of_a_kind(2, dice),

    "threeofakind": dice => nofakind(3, dice),

    "fourofakind": dice => nofakind(4, dice),

    "smallstraight": dice => (is_straight(dice) && dice_frequencies(dice)[6] === 0) ? 15 : 0,

    "largestraight": dice => (is_straight(dice) && dice_frequencies(dice)[6] === 1) ? 20 : 0,

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