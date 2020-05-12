package com.mycompany.app;

public class TreasureHoard {

    private int copper_pieces;
    private int silver_pieces;
    private int gold_pieces;
    private int platinum_pieces;
    private String valuables;
    private String magic_items;

    public static final int LOCAL_HERO_TIER = 1;
    public static final int REGIONAL_HERO_TIER = 2;
    public static final int NATIONAL_HERO_TIER = 3;
    public static final int WORLD_HERO_TIER = 4;

    public TreasureHoard() {
        copper_pieces = 0;
        silver_pieces = 0;
        gold_pieces = 0;
        platinum_pieces = 0;
        valuables = "";
        magic_items = "";
    }

    public int getCopperPieces() {
        return this.copper_pieces;
    }

    public int getSilverPieces() {
        return this.silver_pieces;
    }

    public int getGoldPieces() {
        return this.gold_pieces;
    }

    public int getPlatinumPieces() {
        return this.platinum_pieces;
    }

    public String getValuables() {
        return this.valuables;
    }

    public String getMagicItems() {
        return this.magic_items;
    }

    public void setCopperPieces(int copper_pieces) {
        this.copper_pieces = copper_pieces;
    }

    public void setSilverPieces(int silver_pieces) {
        this.silver_pieces = silver_pieces;
    }

    public void setGoldPieces(int gold_pieces) {
        this.gold_pieces = gold_pieces;
    }

    public void setPlatinumPieces(int platinum_pieces) {
        this.platinum_pieces = platinum_pieces;
    }

    public void setValuables(String valuables) {
        this.valuables = valuables;
    }

    public void setMagicItems(String magic_items) {
        this.magic_items = magic_items;
    }
}
