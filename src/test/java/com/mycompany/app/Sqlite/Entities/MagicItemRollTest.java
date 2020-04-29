package com.mycompany.app.Sqlite.Entities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MagicItemRollTest {

    public static Stream<Arguments> tierAndMagicItemListProvider() {
        return Stream.of(
                arguments(1, "1.4.f"), arguments(2, "1.4.f"),
                arguments(1, "1.4.f"), arguments(2, "1.4.f"),
                arguments(1, "1.4.f"), arguments(2, "1.4.f"),
                arguments(1, "1.4.f"), arguments(2, "1.4.f"),
                arguments(1, "1.4.f"), arguments(2, "1.4.f"),
                arguments(1, "1.4.f"), arguments(2, "1.4.f"),
                arguments(1, "1.4.f"), arguments(2, "1.4.f"),
                arguments(1, "1.4.f"), arguments(2, "1.4.f"),
                arguments(1, "1.4.f"), arguments(2, "1.4.f"),

                arguments(3, "1.4.f"), arguments(4, "1.4.f"),
                arguments(3, "1.4.f"), arguments(4, "1.4.f"),
                arguments(3, "1.4.f"), arguments(4, "1.4.f"),
                arguments(3, "1.4.f"), arguments(4, "1.4.f"),
                arguments(3, "1.4.f"), arguments(4, "1.4.f"),
                arguments(3, "1.4.f"), arguments(4, "1.4.f"),
                arguments(3, "1.4.f"), arguments(4, "1.4.f"),
                arguments(3, "1.4.f"), arguments(4, "1.4.f"),
                arguments(3, "1.4.f"), arguments(4, "1.4.f")
        );
    }

    @ParameterizedTest
    @MethodSource("tierAndMagicItemListProvider")
    public void testMagicItemRollEntity(int tier, String magic_item_table_roll) throws Exception {
        int roll_result = 1;

        MagicItemRoll magic_item_roll = MagicItemRoll.create(tier, roll_result, magic_item_table_roll);

        assertEquals(tier, magic_item_roll.getTier());
        assertEquals(roll_result, magic_item_roll.getRollResult());
        assertEquals(magic_item_table_roll, magic_item_roll.getMagicItemTableRoll());
    }

    @Test
    public void testMagicItemRollEntity_WithInvalidTier_ShouldThrowException() {
        int invalid_tier = 7;
        int roll_result = 1;
        String magic_item_table_roll = "1.4.f";

        Exception e = assertThrows(Exception.class, () -> MagicItemRoll.create(invalid_tier, roll_result, magic_item_table_roll));
        assertEquals("Error while building MagicItemRoll entity: Invalid tier provided", e.getMessage());
    }

}