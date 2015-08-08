package com.daexsys.textadventure;

public class Player {

    private Inventory inventory;
    private int currentRoomIndex = 0;

    public Player() {
        inventory = new Inventory();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getCurrentRoomIndex() {
        return currentRoomIndex;
    }

    public void proceedForward() {
        currentRoomIndex++;
    }
}
