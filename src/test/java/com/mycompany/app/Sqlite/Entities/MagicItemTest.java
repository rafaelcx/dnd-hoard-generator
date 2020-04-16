package com.mycompany.app.Sqlite.Entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MagicItemTest {

    private static final String NAME = "Magic Item Name";

    @Test
    public void testMagicItemEntity() {
        MagicItem magic_item = MagicItem.create(NAME);
        assertFalse(magic_item.getName().equals(""));
    }

}
