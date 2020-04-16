package com.mycompany.app.Sqlite.Repositories;

import com.mycompany.app.Sqlite.Entities.MagicItem;
import com.mycompany.app.Sqlite.SQLiteJDBCDriverConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MagicItemDatabaseRepository {

    public static MagicItem loadMagicItemByCategoryAndRollResult(String category, int roll_result) {
        String query = getQuery(category, roll_result);
        ResultSet result_set = SQLiteJDBCDriverConnection.executeQuery(query);
        MagicItem magic_item = getMagicItemEntity(result_set);

        try {
            result_set.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return magic_item;
    }

    private static String getQuery(String category, int roll_result) {
        return "SELECT * FROM magic_item WHERE category = " + "'" + category + "'" + " AND roll_result = " + roll_result;
    }

    private static MagicItem getMagicItemEntity(ResultSet result_set) {
        MagicItem magic_item_entity = null;
        try {
            magic_item_entity = MagicItem.create(result_set.getString("name"));
        } catch (SQLException e) {
            System.out.println("Something went wrong while creating the MagicItem entity: " + e.getMessage());
        }
        return magic_item_entity;
    }

}
