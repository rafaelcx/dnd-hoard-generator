package com.mycompany.app.DiceRoller;

import java.util.Random;

public class DiceRoller {

    public static int makeRoll(int dice_quantity, int dice_type) {
        int value = 0;
        for(int i = 0; i < dice_quantity; i++) {
            value += DiceRoller.rollSingleDie(dice_type);
        }
        return value;
    }

    private static int rollSingleDie(int dice_type) {
        Random rand = new Random();
        return rand.nextInt(dice_type) + 1;
    }

}
