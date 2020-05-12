package com.mycompany.app;

public class TreasureHoardManager {

    // This class will be invoked by the application GUI, which passes the selected tier to the build function,
    // then the correct builder will be selected and the TreasureHoard object will be generated and returned

    public static TreasureHoard build(int tier) {

        TreasureHoard treasure_hoard = new TreasureHoard();

        switch (tier) {
            case TreasureHoard.LOCAL_HERO_TIER : treasure_hoard = buildLocalTierHoard(treasure_hoard);
                break;
            case TreasureHoard.REGIONAL_HERO_TIER : treasure_hoard = buildRegionalTierHoard(treasure_hoard);
                break;
            case TreasureHoard.NATIONAL_HERO_TIER : treasure_hoard = buildNationalTierHoard(treasure_hoard);
                break;
            case TreasureHoard.WORLD_HERO_TIER : treasure_hoard = buildWorldTierHoard(treasure_hoard);
                break;

            default: System.out.println("Invalid tier selected, please try again");
        }

        return treasure_hoard;
    }

    private static TreasureHoard buildLocalTierHoard(TreasureHoard hoard) {
        return hoard;
    }

    private static TreasureHoard buildRegionalTierHoard(TreasureHoard hoard) {
        return hoard;
    }

    private static TreasureHoard buildNationalTierHoard(TreasureHoard hoard) {
        return hoard;
    }

    private static TreasureHoard buildWorldTierHoard(TreasureHoard hoard) {
        return hoard;
    }

}
