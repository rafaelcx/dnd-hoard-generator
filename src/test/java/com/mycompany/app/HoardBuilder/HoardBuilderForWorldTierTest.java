package com.mycompany.app.HoardBuilder;

import com.mycompany.app.Support.DiceRollerForTests;
import com.mycompany.app.Support.DiceRollerResolverSwitcher;
import com.mycompany.app.TreasureHoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HoardBuilderForWorldTierTest {

    @Test
    public void testHoardBuilderForLocalTier_MinimalRoll() {
        DiceRollerResolverSwitcher.mock(new DiceRollerForTests());
        DiceRollerForTests.mockMinimalRollResult();

        HoardBuilderForWorldTier hoard_builder = new HoardBuilderForWorldTier();
        TreasureHoard treasure_hoard = hoard_builder.buildHoard();

        assertEquals(0, treasure_hoard.getCopperPieces());
        assertEquals(0, treasure_hoard.getSilverPieces());
        assertEquals(12000, treasure_hoard.getGoldPieces());
        assertEquals(8000, treasure_hoard.getPlatinumPieces());
        assertEquals("0 po Gems (x0)", treasure_hoard.getValuables());
        assertEquals("", treasure_hoard.getMagicItems());

        tearDown();
    }

    @Test
    public void testHoardBuilderForLocalTier_MaximumRoll() {
        DiceRollerResolverSwitcher.mock(new DiceRollerForTests());
        DiceRollerForTests.mockMaximumRollResult();

        HoardBuilderForWorldTier hoard_builder = new HoardBuilderForWorldTier();
        TreasureHoard treasure_hoard = hoard_builder.buildHoard();

        assertEquals(0, treasure_hoard.getCopperPieces());
        assertEquals(0, treasure_hoard.getSilverPieces());
        assertEquals(72000, treasure_hoard.getGoldPieces());
        assertEquals(48000, treasure_hoard.getPlatinumPieces());
        assertEquals("5000 po Gems (x8)", treasure_hoard.getValuables());
        assertEquals(
            "            - Tome of the stilled tongue\n" +
            "            - Tome of the stilled tongue\n" +
            "            - Tome of the stilled tongue\n" +
            "            - Tome of the stilled tongue\n", treasure_hoard.getMagicItems()
        );

        tearDown();
    }

    private void tearDown() {
        DiceRollerResolverSwitcher.reset();
        DiceRollerForTests.resetMockMaximumRollResult();
        DiceRollerForTests.resetMockMinimalRollResult();
    }

}
