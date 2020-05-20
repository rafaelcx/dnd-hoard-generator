package com.mycompany.app.Support;

import com.mycompany.app.DiceRoller.DiceRollerResolver;
import com.mycompany.app.DiceRoller.Roller;

public class DiceRollerResolverSwitcher {

    public static void mock(Roller dice_roller_instance) {
        DiceRollerResolver.instance = dice_roller_instance;
    }

    public static void reset() {
        DiceRollerResolver.instance = null;
    }

}
