package com.mycompany.app.Sqlite.Repositories;

import com.mycompany.app.Sqlite.Entities.Coin;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CoinDatabaseRepositoryTest {

    static Stream<Arguments> coinTierAndTypeProvider() {
        return Stream.of(
                arguments(1, Coin.COPPER_TYPE,   6,  100),
                arguments(1, Coin.SILVER_TYPE,   3,  100),
                arguments(1, Coin.GOLD_TYPE,     2,  10),
                arguments(1, Coin.PLATINUM_TYPE, 0,  0),

                arguments(2, Coin.COPPER_TYPE,   2,  100),
                arguments(2, Coin.SILVER_TYPE,   2,  1000),
                arguments(2, Coin.GOLD_TYPE,     6,  100),
                arguments(2, Coin.PLATINUM_TYPE, 3,  10),

                arguments(3, Coin.COPPER_TYPE,   0,  0),
                arguments(3, Coin.SILVER_TYPE,   0,  0),
                arguments(3, Coin.GOLD_TYPE,     4,  1000),
                arguments(3, Coin.PLATINUM_TYPE, 5,  100),

                arguments(4, Coin.COPPER_TYPE,   0,  0),
                arguments(4, Coin.SILVER_TYPE,   0,  0),
                arguments(4, Coin.GOLD_TYPE,     12, 1000),
                arguments(4, Coin.PLATINUM_TYPE, 8,  1000)
        );
    }

    @ParameterizedTest
    @MethodSource("coinTierAndTypeProvider")
    public void testCoinDatabaseRepositoryLoad(int tier, String coin_type, int expected_dice_qnt, int expected_multiplier) {
        Coin coin = CoinDatabaseRepository.loadCoinEntityByTierAndCoinType(tier, coin_type);
        assertEquals(expected_dice_qnt, coin.getDiceQuantity());
        assertEquals(expected_multiplier, coin.getMultiplier());
    }

}