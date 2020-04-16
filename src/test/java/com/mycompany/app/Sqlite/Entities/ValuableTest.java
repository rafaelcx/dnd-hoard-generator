package com.mycompany.app.Sqlite.Entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValuableTest {

    private static final int DICE_QUANTITY = 1;
    private static final int DICE_TYPE = 1;
    private static final int VALUE = 100;

    @Test
    public void testValuableEntity() {
        Valuable valuable = Valuable.create(DICE_QUANTITY, DICE_TYPE, VALUE);

        assertEquals(DICE_QUANTITY, valuable.getDiceQnt());
        assertEquals(DICE_TYPE, valuable.getDiceType());
        assertEquals(VALUE, valuable.getValue());
    }

}
