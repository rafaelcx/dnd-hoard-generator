package com.mycompany.app.HoardBuilder;

import com.mycompany.app.Support.DiceRollerForTests;
import com.mycompany.app.Support.DiceRollerResolverSwitcher;
import com.mycompany.app.TreasureHoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HoardBuilderForLocalTierTest {

    @Test
    public void testHoardBuilderForLocalTier_MinimalRoll() {
        DiceRollerResolverSwitcher.mock(new DiceRollerForTests());
        DiceRollerForTests.mockMinimalRollResult();

        HoardBuilderForLocalTier hoard_builder = new HoardBuilderForLocalTier();
        TreasureHoard treasure_hoard = hoard_builder.buildHoard();

        assertEquals(600, treasure_hoard.getCopperPieces());
        assertEquals(300, treasure_hoard.getSilverPieces());
        assertEquals(20, treasure_hoard.getGoldPieces());
        assertEquals(0, treasure_hoard.getPlatinumPieces());
        assertEquals("Valuables: 0x 0 Po Gems", treasure_hoard.getValuables());
        assertEquals("", treasure_hoard.getMagicItems());

        tearDown();
    }

    @Test
    public void testHoardBuilderForLocalTier_MaximumRoll() {
        DiceRollerResolverSwitcher.mock(new DiceRollerForTests());
        DiceRollerForTests.mockMaximumRollResult();

        HoardBuilderForLocalTier hoard_builder = new HoardBuilderForLocalTier();
        TreasureHoard treasure_hoard = hoard_builder.buildHoard();

        assertEquals(3600, treasure_hoard.getCopperPieces());
        assertEquals(1800, treasure_hoard.getSilverPieces());
        assertEquals(120, treasure_hoard.getGoldPieces());
        assertEquals(0, treasure_hoard.getPlatinumPieces());
        assertEquals("Valuables: 12x 50 Po Gems", treasure_hoard.getValuables());
        assertEquals("Wings of flying\n", treasure_hoard.getMagicItems());

        tearDown();
    }

    private void tearDown() {
        DiceRollerResolverSwitcher.reset();
        DiceRollerForTests.resetMockMaximumRollResult();
        DiceRollerForTests.resetMockMinimalRollResult();
    }

}