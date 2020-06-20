package com.mycompany.app.HoardBuilder;

import com.mycompany.app.Support.DiceRollerForTests;
import com.mycompany.app.Support.DiceRollerResolverSwitcher;
import com.mycompany.app.TreasureHoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HoardBuilderForRegionalTierTest {

    @Test
    public void testHoardBuilderForLocalTier_MinimalRoll() {
        DiceRollerResolverSwitcher.mock(new DiceRollerForTests());
        DiceRollerForTests.mockMinimalRollResult();

        HoardBuilderForRegionalTier hoard_builder = new HoardBuilderForRegionalTier();
        TreasureHoard treasure_hoard = hoard_builder.buildHoard();

        assertEquals(200, treasure_hoard.getCopperPieces());
        assertEquals(2000, treasure_hoard.getSilverPieces());
        assertEquals(600, treasure_hoard.getGoldPieces());
        assertEquals(30, treasure_hoard.getPlatinumPieces());
        assertEquals("0 po Gems (x0)", treasure_hoard.getValuables());
        assertEquals("", treasure_hoard.getMagicItems());

        tearDown();
    }

    @Test
    public void testHoardBuilderForLocalTier_MaximumRoll() {
        DiceRollerResolverSwitcher.mock(new DiceRollerForTests());
        DiceRollerForTests.mockMaximumRollResult();

        HoardBuilderForRegionalTier hoard_builder = new HoardBuilderForRegionalTier();
        TreasureHoard treasure_hoard = hoard_builder.buildHoard();

        assertEquals(1200, treasure_hoard.getCopperPieces());
        assertEquals(12000, treasure_hoard.getSilverPieces());
        assertEquals(3600, treasure_hoard.getGoldPieces());
        assertEquals(180, treasure_hoard.getPlatinumPieces());
        assertEquals("250 po Gems (x8)", treasure_hoard.getValuables());
        assertEquals("            - Tome of understanding\n", treasure_hoard.getMagicItems());

        tearDown();
    }

    private void tearDown() {
        DiceRollerResolverSwitcher.reset();
        DiceRollerForTests.resetMockMaximumRollResult();
        DiceRollerForTests.resetMockMinimalRollResult();
    }

}
