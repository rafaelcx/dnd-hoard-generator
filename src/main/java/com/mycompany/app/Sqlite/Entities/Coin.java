package com.mycompany.app.Sqlite.Entities;

public class Coin {

    private int tier;
    private String coin_type;
    private int dice_qnt;
    private int multiplier;

    public static final String COPPER_TYPE = "copper";
    public static final String SILVER_TYPE = "silver";
    public static final String GOLD_TYPE = "gold";
    public static final String PLATINUM_TYPE = "platinum";

    public static Coin create(int tier, String coin_type, int dice_qnt, int multiplier) throws Exception {
        return new Coin(tier, coin_type, dice_qnt, multiplier);
    }

    private Coin(int tier, String coin_type, int dice_qnt, int multiplier) throws Exception {
        this.tier = tier;
        this.coin_type = coin_type;
        this.dice_qnt = dice_qnt;
        this.multiplier = multiplier;

        validateCoinData();
    }

    public int getDiceQuantity() {
        return this.dice_qnt;
    }

    public int getMultiplier() {
        return this.multiplier;
    }

    private void validateCoinData() throws Exception {
        boolean is_valid_tier = tier >= 1 && tier <= 4;
        boolean is_valid_coin_type = coin_type.equals(COPPER_TYPE) || coin_type.equals(SILVER_TYPE) || coin_type.equals(GOLD_TYPE) || coin_type.equals(PLATINUM_TYPE);

        if (!is_valid_tier) {
            throw new Exception("Error while building coin entity: Invalid tier provided");
        }

        if (!is_valid_coin_type) {
            throw new Exception("Error while building coin entity: Invalid coin_type provided");
        }
    }

}
