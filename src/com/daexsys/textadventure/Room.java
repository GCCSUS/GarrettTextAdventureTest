package com.daexsys.textadventure;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private String name;
    private String description;

    private List<String> items = new ArrayList<String>();

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getItems() {
        return items;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addItem(String itemName) {
        items.add(itemName);
    }

    public void removeItem(String itemName) {
        items.remove(itemName);
    }
}
