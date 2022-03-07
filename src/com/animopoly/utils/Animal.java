package com.animopoly.utils;
public class Animal {

    private String animal, owner;

    private int level;
    private int[] prices;

    public Animal(String animal, int[] prices)
    {
        this.animal = animal;
        this.prices = prices;
        this.owner = null;

        this.level = -1;
    }

    public void increaseLevel()
    {
        this.level += 1;
    }

    public void setOwner(String owner) {
        if(this.owner == null) this.owner = owner;
    }

    public String getOwner()
    {
        return this.owner;
    }
}
