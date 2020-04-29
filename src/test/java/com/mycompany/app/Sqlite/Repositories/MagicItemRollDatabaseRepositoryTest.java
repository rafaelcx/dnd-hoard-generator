package com.mycompany.app.Sqlite.Repositories;

import com.mycompany.app.Sqlite.Entities.MagicItemRoll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MagicItemRollDatabaseRepositoryTest {

    @Test
    public void testMagicItemRollDatabaseRepository_WithNotPopulatedMagicItemList() throws Exception {
        int tier = 1;
        int roll_result = 5;
        MagicItemRoll magic_item_roll = MagicItemRollDatabaseRepository.loadMagicItemResolverByTierAndRollResult(tier, roll_result);
        assertNull(magic_item_roll.getMagicItemTableRoll());
    }

    @Test
    public void testMagicItemRollDatabaseRepository_WithPopulatedMagicItemList() throws Exception {
        int tier = 1;
        int roll_result = 90;
        MagicItemRoll magic_item_roll = MagicItemRollDatabaseRepository.loadMagicItemResolverByTierAndRollResult(tier, roll_result);
        assertEquals("1.4.f", magic_item_roll.getMagicItemTableRoll());
    }

}