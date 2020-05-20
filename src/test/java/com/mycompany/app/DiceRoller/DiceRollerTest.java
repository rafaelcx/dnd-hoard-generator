package com.mycompany.app.DiceRoller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.mycompany.app.Support.DiceRollerForTests;
import com.mycompany.app.Support.DiceRollerResolverSwitcher;
import org.junit.jupiter.api.Test;

public class DiceRollerTest {

    @Test
    public void testMakeRoll() {
        DiceRollerResolverSwitcher.mock(new DiceRollerForTests());
        DiceRollerForTests.mockDiceResult(10);

        Roller dice_roller = DiceRollerResolver.resolve();
        int result = dice_roller.makeRoll(0, 0);

        assertEquals(10, result);
        tearDown();
    }

    private void tearDown() {
        DiceRollerResolverSwitcher.reset();
        DiceRollerForTests.resetMockDiceResult();
    }

}