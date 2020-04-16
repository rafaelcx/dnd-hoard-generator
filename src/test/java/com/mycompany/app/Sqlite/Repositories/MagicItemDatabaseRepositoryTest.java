package com.mycompany.app.Sqlite.Repositories;

import com.mycompany.app.Sqlite.Entities.MagicItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MagicItemDatabaseRepositoryTest {

    private static final String CATEGORY = "a";
    private static final int ROLL = 1;

    @Test
    public void testMagicItemDatabaseRepository() {
        MagicItem magic_item = MagicItemDatabaseRepository.loadMagicItemByCategoryAndRollResult(CATEGORY, ROLL);
        assertFalse(magic_item.getName().equals(""));
    }

}