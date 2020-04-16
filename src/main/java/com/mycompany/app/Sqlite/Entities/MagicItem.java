package com.mycompany.app.Sqlite.Entities;

public class MagicItem {

    private String name;

    public static MagicItem create(String name) {
        return new MagicItem(name);
    }

    private MagicItem(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
