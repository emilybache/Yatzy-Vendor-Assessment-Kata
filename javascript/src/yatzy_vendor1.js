
const YatzyCategoriesEnum = Object.freeze({
    "chance":1, "yatzy":2,
    "ones":3, "twos":4, "threes":5, "fours":6, "fives":7, "sixes":8,
    "pair":9, "threeofakind":10, "fourofakind":11,
    "smallstraight":12, "largestraight":13,
    "twopairs":14, "fullhouse":15
});


function valid_categories() {
    return Object.keys(YatzyCategoriesEnum)
}

function dice_frequencies(dice) {
    let answer = {1:0, 2:0, 3:0, 4:0, 5:0, 6:0};
    dice.forEach(number => answer[number]++);
    return answer
}


module.exports = {
    valid_categories: valid_categories,
    dice_frequencies: dice_frequencies
};