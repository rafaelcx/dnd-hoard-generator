package com.mycompany.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreasureHoardManagerTest {

    @Test
    public void testTreasureHoardManager_LocalTierBuild() {
        int tier = 1;
        TreasureHoard treasure_hoard = TreasureHoardManager.build(tier);

        assertEquals(0 ,treasure_hoard.getCopperPieces());
        assertEquals(0 ,treasure_hoard.getSilverPieces());
        assertEquals(0 ,treasure_hoard.getGoldPieces());
        assertEquals(0 ,treasure_hoard.getPlatinumPieces());
        assertEquals("", treasure_hoard.getValuables());
        assertEquals("", treasure_hoard.getMagicItems());
    }

    @Test
    public void testTreasureHoardManager_HeroTierBuild() {
        int tier = 2;
        TreasureHoard treasure_hoard = TreasureHoardManager.build(tier);

        assertEquals(0 ,treasure_hoard.getCopperPieces());
        assertEquals(0 ,treasure_hoard.getSilverPieces());
        assertEquals(0 ,treasure_hoard.getGoldPieces());
        assertEquals(0 ,treasure_hoard.getPlatinumPieces());
        assertEquals("", treasure_hoard.getValuables());
        assertEquals("", treasure_hoard.getMagicItems());
    }

    @Test
    public void testTreasureHoardManager_NationalTierBuild() {
        int tier = 3;
        TreasureHoard treasure_hoard = TreasureHoardManager.build(tier);

        assertEquals(0 ,treasure_hoard.getCopperPieces());
        assertEquals(0 ,treasure_hoard.getSilverPieces());
        assertEquals(0 ,treasure_hoard.getGoldPieces());
        assertEquals(0 ,treasure_hoard.getPlatinumPieces());
        assertEquals("", treasure_hoard.getValuables());
        assertEquals("", treasure_hoard.getMagicItems());
    }

    @Test
    public void testTreasureHoardManager_WorldTierBuild() {
        int tier = 4;
        TreasureHoard treasure_hoard = TreasureHoardManager.build(tier);

        assertEquals(0 ,treasure_hoard.getCopperPieces());
        assertEquals(0 ,treasure_hoard.getSilverPieces());
        assertEquals(0 ,treasure_hoard.getGoldPieces());
        assertEquals(0 ,treasure_hoard.getPlatinumPieces());
        assertEquals("", treasure_hoard.getValuables());
        assertEquals("", treasure_hoard.getMagicItems());
    }

}
