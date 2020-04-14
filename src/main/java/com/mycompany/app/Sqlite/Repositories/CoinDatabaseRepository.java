package com.mycompany.app.Sqlite.Repositories;

import com.mycompany.app.Sqlite.Entities.Coin;
import com.mycompany.app.Sqlite.SQLiteJDBCDriverConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CoinDatabaseRepository {

    public static Coin loadCoinEntityByTierAndCoinType(int tier, String coin_type) {
        String query = getQuery(tier, coin_type);
        ResultSet result_set = SQLiteJDBCDriverConnection.executeQuery(query);
        Coin coin_entity = getCoinEntity(result_set);

        try {
            result_set.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return coin_entity;
    }

    private static String getQuery(int tier, String coin_type) {
        return "SELECT * FROM coin WHERE tier = " + tier + " AND coin_type = '" + coin_type + "'";
    }

    private static Coin getCoinEntity(ResultSet result_set) {
        Coin coin_entity = null;

        try {
            coin_entity = Coin.create(
                    result_set.getInt("tier"),
                    result_set.getString("coin_type"),
                    result_set.getInt("dice_qnt"),
                    result_set.getInt("multiplier")
            );
        } catch (Exception e) {
            System.out.println("Something went wrong while creating the Coin entity: " + e.getMessage());
        }

        return coin_entity;
    }

}
