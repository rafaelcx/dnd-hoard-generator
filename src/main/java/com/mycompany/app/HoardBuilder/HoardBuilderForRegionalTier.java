package com.mycompany.app.HoardBuilder;

import com.mycompany.app.Sqlite.Entities.Coin;
import com.mycompany.app.TreasureHoard;
import com.mycompany.app.TreasureHoardBuilder;

public class HoardBuilderForRegionalTier extends TreasureHoardBuilder {

    public TreasureHoard buildHoard() {
        TreasureHoard treasure_hoard = new TreasureHoard();

        treasure_hoard.setCopperPieces(generateCoinStashByTypeAndTier(Coin.COPPER_TYPE, TreasureHoard.REGIONAL_HERO_TIER));
        treasure_hoard.setSilverPieces(generateCoinStashByTypeAndTier(Coin.SILVER_TYPE, TreasureHoard.REGIONAL_HERO_TIER));
        treasure_hoard.setGoldPieces(generateCoinStashByTypeAndTier(Coin.GOLD_TYPE, TreasureHoard.REGIONAL_HERO_TIER));
        treasure_hoard.setPlatinumPieces(generateCoinStashByTypeAndTier(Coin.PLATINUM_TYPE, TreasureHoard.REGIONAL_HERO_TIER));

        treasure_hoard.setValuables(generateValuablesByTier(TreasureHoard.REGIONAL_HERO_TIER));
        treasure_hoard.setMagicItems(generateMagicItensByTier(TreasureHoard.REGIONAL_HERO_TIER));

        return treasure_hoard;
    }

}
