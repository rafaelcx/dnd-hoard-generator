package com.mycompany.app.DiceRoller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class DiceRollerTest {

    @Test
    public void testMakeRoll() {
        int arbitrary_dice_quantity = 2;
        int arbitrary_dice_type = 6;

        int result = DiceRoller.makeRoll(arbitrary_dice_quantity, arbitrary_dice_type);

        int lowest_value_posible = arbitrary_dice_quantity;
        int highest_value_posible = arbitrary_dice_type * arbitrary_dice_quantity;

        assertTrue(result >= lowest_value_posible);
        assertTrue(result <= highest_value_posible);
    }

}