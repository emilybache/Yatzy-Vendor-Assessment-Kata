
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

test('score pair', () => {
    expect(yatzy1.score([1,2,2,3,4], "pair")).toBe(4);
    expect(yatzy1.score([1,2,3,4,5], "pair")).toBe(0);
    expect(yatzy1.score([1,2,2,5,5], "pair")).toBe(10);
});

test('score straight', () => {
    expect(yatzy1.score([1,2,2,2,2], "smallstraight")).toBe(0);
    expect(yatzy1.score([1,2,3,4,5], "smallstraight")).toBe(15);
    expect(yatzy1.score([2,3,4,5,6], "largestraight")).toBe(20);
    expect(yatzy1.score([2,3,4,5,2], "largestraight")).toBe(0);
});

test('score two pairs', () => {
    expect(yatzy1.score([1,2,2,3,4], "twopairs")).toBe(0);
    expect(yatzy1.score([1,2,2,4,4], "twopairs")).toBe(12);
});