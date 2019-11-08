
const valid_categories = require('../src/yatzy_vendor1');


test('all categories', () => {
    const categories = valid_categories();
    expect(categories).toMatchSnapshot();
});
