
const yatzy1 = require('../src/yatzy_vendor1');


test('all categories', () => {
    const categories = yatzy1.valid_categories();
    expect(categories).toMatchSnapshot();
});

test('dice frequencies', () => {
   expect(yatzy1.dice_frequencies([1,2,2,2,2])).toEqual({1:1, 2:4, 3:0, 4:0, 5:0, 6:0});
   expect(yatzy1.dice_frequencies([6,3,5,2,1])).toEqual({1:1, 2:1, 3:1, 4:0, 5:1, 6:1});
});

test('score chance', () => {
   expect(yatzy1.score([1,2,2,2,2], "chance")).toBe(9);
});

test('score yatzy', () => {
    expect(yatzy1.score([1,2,2,2,2], "yatzy")).toBe(0);
    expect(yatzy1.score([2,2,2,2,2], "yatzy")).toBe(50);
});

test('score ones', () => {
    expect(yatzy1.score([1,2,2,2,2], "ones")).toBe(1);
});