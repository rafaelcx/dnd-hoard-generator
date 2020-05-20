package com.mycompany.app.Support;

import com.mycompany.app.DiceRoller.Roller;

public class DiceRollerForTests implements Roller {

    private static int result = 0;
    private static boolean is_minimal_result = false;
    private static boolean is_maximum_result = false;

    public int makeRoll(int dice_quantity, int dice_type) {
        if (DiceRollerForTests.is_maximum_result) {
            return dice_quantity * dice_type;
        }

        if (DiceRollerForTests.is_minimal_result) {
            return dice_quantity;
        }

        System.out.println("Using dice roller for tests without mocking any result");
        return DiceRollerForTests.result;
    }

    public static void mockMinimalRollResult() {
        DiceRollerForTests.is_minimal_result = true;
    }

    public static void mockMaximumRollResult() {
        DiceRollerForTests.is_maximum_result = true;
    }

    public static void mockDiceResult(int result) {
        DiceRollerForTests.result = result;
    }

    public static void resetMockMinimalRollResult() {
        DiceRollerForTests.is_minimal_result = false;
    }

    public static void resetMockMaximumRollResult() {
        DiceRollerForTests.is_maximum_result = false;
    }

    public static void resetMockDiceResult() {
        DiceRollerForTests.result = 0;
    }

}
