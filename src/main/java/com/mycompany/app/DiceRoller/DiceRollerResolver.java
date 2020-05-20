package com.mycompany.app.DiceRoller;

public class DiceRollerResolver {

    public static Roller instance;

    public static Roller resolve() {
        if (instance == null) {
            return new DiceRoller();
        }

        return instance;
    }

}

