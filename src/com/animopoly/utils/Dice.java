package com.animopoly.utils;

import java.util.Random;
import java.security.SecureRandom;

public class Dice
{
    private SecureRandom seedGen; // Used for Seed
    private byte seed[]; // Stores the Seed
    private Random randomRoll; // Random Number Generator
    
    private int[] rolls;
    private boolean doubles;
    
    public Dice()
    {
        this.seedGen = new SecureRandom();
        this.seed = this.seedGen.generateSeed(12);
        this.randomRoll = new Random(new java.math.BigInteger(this.seed).longValue());

        this.doubles = false;
        this.rolls = new int[2];
    }
    
    private int getRandom()
    {
        return this.randomRoll.nextInt(6) + 1;
    }
    
    public int rollDice()
    {
        this.doubles = false;
        this.rolls[0] = this.getRandom();
        this.rolls[1] = this.getRandom();
        
        if(this.rolls[0] == this.rolls[1])
        {
            this.doubles = true;
        }
        return this.rolls[0] + this.rolls[1];
    }
    
}
