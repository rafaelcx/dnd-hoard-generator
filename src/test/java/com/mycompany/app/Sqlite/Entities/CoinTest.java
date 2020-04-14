package com.mycompany.app.Sqlite.Entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CoinTest {

    static Stream<Arguments> coinDataProvider() {
        return Stream.of(
                arguments(1, Coin.COPPER_TYPE),
                arguments(1, Coin.SILVER_TYPE),
                arguments(1, Coin.GOLD_TYPE),
                arguments(1, Coin.PLATINUM_TYPE),

                arguments(2, Coin.COPPER_TYPE),
                arguments(2, Coin.SILVER_TYPE),
                arguments(2, Coin.GOLD_TYPE),
                arguments(2, Coin.PLATINUM_TYPE),

                arguments(3, Coin.COPPER_TYPE),
                arguments(3, Coin.SILVER_TYPE),
                arguments(3, Coin.GOLD_TYPE),
                arguments(3, Coin.PLATINUM_TYPE),

                arguments(4, Coin.COPPER_TYPE),
                arguments(4, Coin.SILVER_TYPE),
                arguments(4, Coin.GOLD_TYPE),
                arguments(4, Coin.PLATINUM_TYPE)
        );
    }

    @ParameterizedTest
    @MethodSource("coinDataProvider")
    public void testCoinEntity_ShouldCreate(int tier, String coin_type) throws Exception {
        int dice_qnt = 1;
        int multiplier = 1000;

        Coin coin = Coin.create(tier, coin_type, dice_qnt, multiplier);

        assertEquals(dice_qnt, coin.getDiceQuantity());
        assertEquals(multiplier, coin.getMultiplier());
    }

    @Test
    public void testCoinEntity_WithInvalidTier_ShouldThrowException() {
        int dice_qnt = 1;
        int multiplier = 1000;
        int invalid_tier = 5;
        String coin_type = Coin.GOLD_TYPE;

        Exception e = assertThrows(Exception.class, () -> Coin.create(invalid_tier, coin_type, dice_qnt, multiplier));
        assertEquals("Error while building coin entity: Invalid tier provided", e.getMessage());
    }

    @Test
    public void testCoinEntity_WithInvalidCoinType_ShouldThrowException() {
        int dice_qnt = 1;
        int multiplier = 1000;
        int tier = 1;
        String invalid_coin_type = "invalid coin type";

        Exception e = assertThrows(Exception.class, () -> Coin.create(tier, invalid_coin_type, dice_qnt, multiplier));
        assertEquals("Error while building coin entity: Invalid coin_type provided", e.getMessage());
    }

}