import vendor1


def test_yatzy():
    yatzy = vendor1.Yatzy()
    line, dice, category_name = yatzy.parse_dice_and_category("11111 yatzy\n")
    score = yatzy.score(dice, category_name)
    assert 50 == score
