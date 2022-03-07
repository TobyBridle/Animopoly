package com.animopoly.utils;

import java.util.ArrayList;

public class Position {

    String id;
    Animal animal;
    ArrayList<Player> activePlayers;

    public Position(String id, Animal animal)
    {
        this.id = id;
        this.animal = animal;
        this.activePlayers = new ArrayList<Player>();
    }

    public void buyAnimal(String owner)
    {
        if(this.animal.getOwner() != null)
        {
            this.animal.setOwner(owner);
        }
    }
}
