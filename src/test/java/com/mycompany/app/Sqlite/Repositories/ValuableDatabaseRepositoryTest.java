package com.mycompany.app.Sqlite.Repositories;

import com.mycompany.app.Sqlite.Entities.Valuable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValuableDatabaseRepositoryTest {

    private static final int TIER = 1;
    private static final int LOW_ROLL = 1;
    private static final int HIGH_ROLL = 100;

    @Test
    public void testValuableDatabaseRepository_WithHighEnoughRoll_ShouldReturnPopulatedValuableEntity() {
        Valuable valuable = ValuableDatabaseRepository.loadValuableEntityByTierAndDiceResult(TIER, HIGH_ROLL);
        assertTrue(valuable.getDiceQnt() > 0);
        assertTrue(valuable.getDiceType() > 0);
        assertTrue(valuable.getValue() > 0);
    }

    @Test
    public void testValuableDatabaseRepository_WithLowEnoughRoll_ShouldReturnEmptyValuableEntity() {
        Valuable valuable = ValuableDatabaseRepository.loadValuableEntityByTierAndDiceResult(TIER, LOW_ROLL);
        assertTrue(valuable.getDiceQnt() == 0);
        assertTrue(valuable.getDiceType()== 0);
        assertTrue(valuable.getValue() == 0);
    }

}
