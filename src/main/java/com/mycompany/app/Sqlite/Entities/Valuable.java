package com.mycompany.app.Sqlite.Entities;

public class Valuable {

    private int dice_qnt;
    private int dice_type;
    private int value;

    public static Valuable create(int dice_qnt, int dice_type, int value) {
        return new Valuable(dice_qnt, dice_type, value);
    }

    private Valuable(int dice_qnt, int dice_type, int value) {
        this.dice_qnt = dice_qnt;
        this.dice_type = dice_type;
        this.value = value;
    }

    public int getDiceQnt() {
        return this.dice_qnt;
    }

    public int getDiceType() {
        return this.dice_type;
    }

    public int getValue() {
        return this.value;
    }

}
