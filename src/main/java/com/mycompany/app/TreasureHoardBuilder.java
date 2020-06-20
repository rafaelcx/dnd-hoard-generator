package com.mycompany.app;

import com.mycompany.app.DiceRoller.DiceRollerResolver;
import com.mycompany.app.DiceRoller.Roller;
import com.mycompany.app.Sqlite.Entities.Coin;
import com.mycompany.app.Sqlite.Entities.MagicItem;
import com.mycompany.app.Sqlite.Entities.MagicItemRoll;
import com.mycompany.app.Sqlite.Entities.Valuable;
import com.mycompany.app.Sqlite.Repositories.CoinDatabaseRepository;
import com.mycompany.app.Sqlite.Repositories.MagicItemDatabaseRepository;
import com.mycompany.app.Sqlite.Repositories.MagicItemRollDatabaseRepository;
import com.mycompany.app.Sqlite.Repositories.ValuableDatabaseRepository;

public abstract class TreasureHoardBuilder {

    Roller dice_roller;

    public abstract TreasureHoard buildHoard();

    public TreasureHoardBuilder() {
        this.dice_roller = DiceRollerResolver.resolve();
    }

    public int generateCoinStashByTypeAndTier(String coin_type, int tier) {
        int dice_type = 6;
        Coin coin_entity = CoinDatabaseRepository.loadCoinEntityByTierAndCoinType(tier, coin_type);
        int dice_quantity = coin_entity.getDiceQuantity();
        int multiplier = coin_entity.getMultiplier();

        return this.dice_roller.makeRoll(dice_quantity, dice_type) * multiplier;
    }

    public String generateValuablesByTier(int tier) {
        int percentage_dice_result = this.dice_roller.makeRoll(1, 100);
        Valuable valuables_entity = ValuableDatabaseRepository.loadValuableEntityByTierAndDiceResult(tier, percentage_dice_result);

        int dice_quantity = valuables_entity.getDiceQnt();
        int dice_type = valuables_entity.getDiceType();
        String valuables_quantity = Integer.toString(this.dice_roller.makeRoll(dice_quantity, dice_type));

        String valuables_value = Integer.toString(valuables_entity.getValue());

        return valuables_value + " po Gems (x" + valuables_quantity + ")";
    }

    public String generateMagicItensByTier(int tier) {
        int percentage_dice_result = this.dice_roller.makeRoll(1, 100);
        MagicItemRoll mir = MagicItemRollDatabaseRepository.loadMagicItemResolverByTierAndRollResult(tier, percentage_dice_result);

        String magic_item_table_roll_string = mir.getMagicItemTableRoll();

        if (magic_item_table_roll_string == null) {
            return "";
        }

        String[] magic_item_resolver_rolls = magic_item_table_roll_string.split("[+]");

        String magic_items_list = "";
        for (int i = 0; i < magic_item_resolver_rolls.length; i++) {
            String[] roll_info = magic_item_resolver_rolls[0].split("[.]");

            int roll_dice_qnt = Integer.parseInt(roll_info[0]);
            int roll_dice_type = Integer.parseInt(roll_info[1]);
            String roll_magic_item_category = roll_info[2];

            int times_to_roll_at_magic_item_table = this.dice_roller.makeRoll(roll_dice_qnt, roll_dice_type);
            for (int j = 0; j < times_to_roll_at_magic_item_table; j++) {
                percentage_dice_result = this.dice_roller.makeRoll(1, 100);
                MagicItem mi = MagicItemDatabaseRepository.loadMagicItemByCategoryAndRollResult(roll_magic_item_category, percentage_dice_result);

                magic_items_list = magic_items_list + "            - " + mi.getName() + "\n";
            }
        }

        return magic_items_list;
    }

}