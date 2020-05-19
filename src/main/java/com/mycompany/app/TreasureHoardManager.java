package com.mycompany.app;

import com.mycompany.app.HoardBuilder.HoardBuilderForLocalTier;
import com.mycompany.app.HoardBuilder.HoardBuilderForNationalTier;
import com.mycompany.app.HoardBuilder.HoardBuilderForRegionalTier;
import com.mycompany.app.HoardBuilder.HoardBuilderForWorldTier;

public class TreasureHoardManager {

    // This class will be invoked by the application GUI, which passes the selected tier to the build function,
    // then the correct builder will be selected and the TreasureHoard object will be generated and returned

    public static TreasureHoard build(int tier) {
        TreasureHoard treasure_hoard = new TreasureHoard();

        switch (tier) {
            case TreasureHoard.LOCAL_HERO_TIER : treasure_hoard = buildLocalTierHoard();
                break;
            case TreasureHoard.REGIONAL_HERO_TIER : treasure_hoard = buildRegionalTierHoard();
                break;
            case TreasureHoard.NATIONAL_HERO_TIER : treasure_hoard = buildNationalTierHoard();
                break;
            case TreasureHoard.WORLD_HERO_TIER : treasure_hoard = buildWorldTierHoard();
                break;

            default: System.out.println("Invalid tier selected, please try again");
        }

        return treasure_hoard;
    }

    private static TreasureHoard buildLocalTierHoard() {
        TreasureHoardBuilder hoard_builder = new HoardBuilderForLocalTier();
        return hoard_builder.buildHoard();
    }

    private static TreasureHoard buildRegionalTierHoard() {
        TreasureHoardBuilder hoard_builder = new HoardBuilderForRegionalTier();
        return hoard_builder.buildHoard();
    }

    private static TreasureHoard buildNationalTierHoard() {
        TreasureHoardBuilder hoard_builder = new HoardBuilderForNationalTier();
        return hoard_builder.buildHoard();
    }

    private static TreasureHoard buildWorldTierHoard() {
        TreasureHoardBuilder hoardBuilder = new HoardBuilderForWorldTier();
        return hoardBuilder.buildHoard();
    }

}
