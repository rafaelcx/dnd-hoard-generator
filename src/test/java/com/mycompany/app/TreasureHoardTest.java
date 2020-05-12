package com.mycompany.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreasureHoardTest {

    @Test
    public void testTreasureHoardObject() {
        TreasureHoard treasure_hoard = new TreasureHoard();

        assertEquals(0 ,treasure_hoard.getCopperPieces());
        assertEquals(0 ,treasure_hoard.getSilverPieces());
        assertEquals(0 ,treasure_hoard.getGoldPieces());
        assertEquals(0 ,treasure_hoard.getPlatinumPieces());
        assertEquals("", treasure_hoard.getValuables());
        assertEquals("", treasure_hoard.getMagicItems());

        treasure_hoard.setCopperPieces(1);
        treasure_hoard.setSilverPieces(1);
        treasure_hoard.setGoldPieces(1);
        treasure_hoard.setPlatinumPieces(1);
        treasure_hoard.setValuables("Test Valuables");
        treasure_hoard.setMagicItems("Test Magic Item");

        assertEquals(1 ,treasure_hoard.getCopperPieces());
        assertEquals(1 ,treasure_hoard.getSilverPieces());
        assertEquals(1 ,treasure_hoard.getGoldPieces());
        assertEquals(1 ,treasure_hoard.getPlatinumPieces());
        assertEquals("Test Valuables", treasure_hoard.getValuables());
        assertEquals("Test Magic Item", treasure_hoard.getMagicItems());
    }

}
