
const YatzyCategoriesEnum = Object.freeze({
    "chance":1, "yatzy":2,
    "ones":3, "twos":4, "threes":5, "fours":6, "fives":7, "sixes":8,
    "pair":9, "threeofakind":10, "fourofakind":11,
    "smallstraight":12, "largestraight":13,
    "twopairs":14, "fullhouse":15
})


function valid_categories() {
    return Object.keys(YatzyCategoriesEnum)
}


module.exports = valid_categories