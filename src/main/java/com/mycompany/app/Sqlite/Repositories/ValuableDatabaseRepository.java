package com.mycompany.app.Sqlite.Repositories;

import com.mycompany.app.Sqlite.Entities.Valuable;
import com.mycompany.app.Sqlite.SQLiteJDBCDriverConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ValuableDatabaseRepository {

    public static Valuable loadValuableEntityByTierAndDiceResult(int tier, int dice_result) {
        String query = getQuery(tier, dice_result);
        ResultSet result_set = SQLiteJDBCDriverConnection.executeQuery(query);
        Valuable valuable_entity = getValuableEntity(result_set);

        try {
            result_set.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return valuable_entity;
    }

    private static String getQuery(int tier, int dice_result) {
        return "SELECT * FROM valuables WHERE tier = " + tier + " AND roll_result = " + dice_result;
    }

    private static Valuable getValuableEntity(ResultSet result_set) {
        Valuable valuable_entity = null;
        try {
            valuable_entity = Valuable.create(
                    result_set.getInt("dice_qnt"),
                    result_set.getInt("dice_type"),
                    result_set.getInt("value")
            );
        } catch (SQLException e) {
            System.out.println("Something went wrong while creating the Valuable entity: " + e.getMessage());
        }
        return valuable_entity;
    }

}
