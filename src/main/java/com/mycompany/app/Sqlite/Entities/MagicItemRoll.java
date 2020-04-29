package com.mycompany.app.Sqlite.Entities;

public class MagicItemRoll {

    private int tier;
    private int roll_result;
    private String magic_item_table_roll;

    public static MagicItemRoll create(int tier, int roll_result, String magic_item_table_roll) throws Exception {
        return new MagicItemRoll(tier, roll_result, magic_item_table_roll);
    }

    private MagicItemRoll(int tier, int roll_result, String magic_item_table_roll) throws Exception {
        this.tier = tier;
        this.roll_result = roll_result;
        this.magic_item_table_roll = magic_item_table_roll;

        validateTier();
    }

    public int getTier() {
        return tier;
    }

    public int getRollResult() {
        return roll_result;
    }

    public String getMagicItemTableRoll() {
        return magic_item_table_roll;
    }


    private void validateTier() throws Exception {
        if (this.tier < 1 || this.tier > 4) {
            throw new Exception("Error while building MagicItemRoll entity: Invalid tier provided");
        }
    }

}
