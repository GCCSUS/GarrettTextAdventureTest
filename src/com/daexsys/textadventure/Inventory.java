package com.daexsys.textadventure;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<String> items = new ArrayList<String>();

    public void addItem(String item) {
        items.add(item);
    }

    public void removeItem(String item) {
        items.remove(item);
    }

    public void print() {
        for(String item: items) {
            System.out.println(item);
        }
    }
}
