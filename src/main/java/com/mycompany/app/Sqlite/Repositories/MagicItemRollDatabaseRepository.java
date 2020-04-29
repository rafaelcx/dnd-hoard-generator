package com.mycompany.app.Sqlite.Repositories;

import com.mycompany.app.Sqlite.Entities.MagicItemRoll;
import com.mycompany.app.Sqlite.SQLiteJDBCDriverConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MagicItemRollDatabaseRepository {

    public static MagicItemRoll loadMagicItemResolverByTierAndRollResult(int tier, int roll_result) throws Exception {
        String query = getQuery(tier, roll_result);
        ResultSet result_set = SQLiteJDBCDriverConnection.executeQuery(query);
        MagicItemRoll mir = getMagicItemResolverEntity(result_set);

        try {
            result_set.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mir;
    }

    private static String getQuery(int tier, int dice_result) {
        return "SELECT * FROM magic_item_resolver WHERE tier = " + tier + " AND roll_result = " + dice_result;
    }

    private static MagicItemRoll getMagicItemResolverEntity(ResultSet result_set) throws Exception {
        MagicItemRoll magic_item_roll_entity = null;
        try {
            magic_item_roll_entity = MagicItemRoll.create(
                    result_set.getInt("tier"),
                    result_set.getInt("roll_result"),
                    result_set.getString("magic_item_list")
            );
        } catch (SQLException e) {
            System.out.println("Something went wrong while creating the Valuables entity: " + e.getMessage());
        }

        return magic_item_roll_entity;
    }

}
