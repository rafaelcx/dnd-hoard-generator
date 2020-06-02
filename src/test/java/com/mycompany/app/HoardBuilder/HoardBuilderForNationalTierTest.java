package com.mycompany.app.HoardBuilder;

import com.mycompany.app.Support.DiceRollerForTests;
import com.mycompany.app.Support.DiceRollerResolverSwitcher;
import com.mycompany.app.TreasureHoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HoardBuilderForNationalTierTest {

    @Test
    public void testHoardBuilderForLocalTier_MinimalRoll() {
        DiceRollerResolverSwitcher.mock(new DiceRollerForTests());
        DiceRollerForTests.mockMinimalRollResult();

        HoardBuilderForNationalTier hoard_builder = new HoardBuilderForNationalTier();
        TreasureHoard treasure_hoard = hoard_builder.buildHoard();

        assertEquals(0, treasure_hoard.getCopperPieces());
        assertEquals(0, treasure_hoard.getSilverPieces());
        assertEquals(4000, treasure_hoard.getGoldPieces());
        assertEquals(500, treasure_hoard.getPlatinumPieces());
        assertEquals("Valuables: 0x 0 Po Gems", treasure_hoard.getValuables());
        assertEquals("", treasure_hoard.getMagicItems());

        tearDown();
    }

    @Test
    public void testHoardBuilderForLocalTier_MaximumRoll() {
        DiceRollerResolverSwitcher.mock(new DiceRollerForTests());
        DiceRollerForTests.mockMaximumRollResult();

        HoardBuilderForNationalTier hoard_builder = new HoardBuilderForNationalTier();
        TreasureHoard treasure_hoard = hoard_builder.buildHoard();

        assertEquals(0, treasure_hoard.getCopperPieces());
        assertEquals(0, treasure_hoard.getSilverPieces());
        assertEquals(24000, treasure_hoard.getGoldPieces());
        assertEquals(3000, treasure_hoard.getPlatinumPieces());
        assertEquals("Valuables: 18x 1000 Po Gems", treasure_hoard.getValuables());
        assertEquals("Tome of the stilled tongue\n", treasure_hoard.getMagicItems());

        tearDown();
    }

    private void tearDown() {
        DiceRollerResolverSwitcher.reset();
        DiceRollerForTests.resetMockMaximumRollResult();
        DiceRollerForTests.resetMockMinimalRollResult();
    }

}
