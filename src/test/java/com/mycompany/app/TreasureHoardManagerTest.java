package com.mycompany.app;

import com.mycompany.app.Support.DiceRollerForTests;
import com.mycompany.app.Support.DiceRollerResolverSwitcher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreasureHoardManagerTest {

    @Test
    public void testTreasureHoardManager_LocalTierBuild() {
        DiceRollerResolverSwitcher.mock(new DiceRollerForTests());
        DiceRollerForTests.mockMaximumRollResult();

        int tier = 1;
        TreasureHoard treasure_hoard = TreasureHoardManager.build(tier);

        assertEquals(3600, treasure_hoard.getCopperPieces());
        assertEquals(1800, treasure_hoard.getSilverPieces());
        assertEquals(120, treasure_hoard.getGoldPieces());
        assertEquals(0, treasure_hoard.getPlatinumPieces());
        assertEquals("Valuables: 12x 50 Po Gems", treasure_hoard.getValuables());
        assertEquals("Wings of flying\n", treasure_hoard.getMagicItems());

        tearDown();
    }

    @Test
    public void testTreasureHoardManager_RegionalTierBuild() {
        DiceRollerResolverSwitcher.mock(new DiceRollerForTests());
        DiceRollerForTests.mockMaximumRollResult();

        int tier = 2;
        TreasureHoard treasure_hoard = TreasureHoardManager.build(tier);

        assertEquals(1200, treasure_hoard.getCopperPieces());
        assertEquals(12000, treasure_hoard.getSilverPieces());
        assertEquals(3600, treasure_hoard.getGoldPieces());
        assertEquals(180, treasure_hoard.getPlatinumPieces());
        assertEquals("Valuables: 8x 250 Po Gems", treasure_hoard.getValuables());
        assertEquals("Tome of understanding\n", treasure_hoard.getMagicItems());

        tearDown();
    }

    @Test
    public void testTreasureHoardManager_NationalTierBuild() {
        DiceRollerResolverSwitcher.mock(new DiceRollerForTests());
        DiceRollerForTests.mockMaximumRollResult();

        int tier = 3;
        TreasureHoard treasure_hoard = TreasureHoardManager.build(tier);

        assertEquals(0, treasure_hoard.getCopperPieces());
        assertEquals(0, treasure_hoard.getSilverPieces());
        assertEquals(24000, treasure_hoard.getGoldPieces());
        assertEquals(3000, treasure_hoard.getPlatinumPieces());
        assertEquals("Valuables: 18x 1000 Po Gems", treasure_hoard.getValuables());
        assertEquals("Tome of the stilled tongue\n", treasure_hoard.getMagicItems());

        tearDown();
    }

    @Test
    public void testTreasureHoardManager_WorldTierBuild() {
        DiceRollerResolverSwitcher.mock(new DiceRollerForTests());
        DiceRollerForTests.mockMaximumRollResult();

        int tier = 4;
        TreasureHoard treasure_hoard = TreasureHoardManager.build(tier);

        assertEquals(0, treasure_hoard.getCopperPieces());
        assertEquals(0, treasure_hoard.getSilverPieces());
        assertEquals(72000, treasure_hoard.getGoldPieces());
        assertEquals(48000, treasure_hoard.getPlatinumPieces());
        assertEquals("Valuables: 8x 5000 Po Gems", treasure_hoard.getValuables());
        assertEquals("Tome of the stilled tongue\nTome of the stilled tongue\nTome of the stilled tongue\nTome of the stilled tongue\n", treasure_hoard.getMagicItems());

        tearDown();
    }

    private void tearDown() {
        DiceRollerResolverSwitcher.reset();
        DiceRollerForTests.resetMockMaximumRollResult();
        DiceRollerForTests.resetMockMinimalRollResult();
    }

}
