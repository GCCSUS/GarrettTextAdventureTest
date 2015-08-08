package com.daexsys.textadventure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    public static List<Room> roomList = new ArrayList<Room>();

    public static Player player = new Player();

    public static void main(String[] args) {

        setupRooms();

        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLine()) {

            Room currentRoom = roomList.get(player.getCurrentRoomIndex());

            String line = scanner.nextLine();
            String[] words = line.split("\\s+");
            String commandName = words[0];

            if(commandName.equalsIgnoreCase("lookaround")) {
                System.out.println("You glance around: you are in the " + currentRoom.getName());
                System.out.println("It is " + currentRoom.getDescription());
                System.out.println("On the ground, there are " + currentRoom.getItems().size() + " items.");
            }

            else if(commandName.equalsIgnoreCase("items")) {
                if(currentRoom.getItems().size() == 0) {
                    System.out.println("Alas, there are no items on the ground! You shake your head.");
                } else {
                    System.out.println("The following items are on the ground: ");

                    for (String item : currentRoom.getItems()) {
                        System.out.println(item);
                    }
                }
            }

            else if(commandName.equalsIgnoreCase("pickup")) {
                int itemsPickedUp = 0;

                for(String item : currentRoom.getItems()) {
                    player.getInventory().addItem(item);
                    itemsPickedUp++;
                }

                System.out.println("You have picked up " + itemsPickedUp + " items");

                currentRoom.getItems().clear();
            }

            else if(commandName.equalsIgnoreCase("proceed")) {
                System.out.println("You walk into the next room.");

                player.proceedForward();
                currentRoom = roomList.get(player.getCurrentRoomIndex());

                System.out.println("You glance around: you are in the " + currentRoom.getName());
                System.out.println("It is " + currentRoom.getDescription());
                System.out.println("On the ground, there are " + currentRoom.getItems().size() + " items.");
            }

            else if(commandName.equalsIgnoreCase("inventory")) {
                System.out.println("Your inventory contains:");

                player.getInventory().print();
            }

            else {
                System.out.println("Unknown command!");
            }

            // Prints blank line
            System.out.println("");
        }
    }

    public static void setupRooms() {

        Room room = new Room("Torture Chamber", "Very Evil and Tortury");
        room.addItem("Fuzzy Handcuffs");
        room.addItem("Strange Sword");
        roomList.add(room);

        Room room2 = new Room("Long Hallway", "Very Long and Dark");
        room2.addItem("Rat");
        room2.addItem("Torch");
        roomList.add(room2);

        Room room3 = new Room("Goblins Camp", "A room with 3 goblins and scattered treasures");
        room3.addItem("28 gold");
        room3.addItem("Diamond Jewl");
        roomList.add(room3);

        // repeat for other rooms
    }
}
