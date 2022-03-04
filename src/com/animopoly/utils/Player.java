package com.animopoly.utils;

import jdk.jshell.execution.Util;

import java.util.Arrays;

public class Player
{

	public Utils.Piece piece;
	public String name;
	public long money;

	public String[] position;
	public int location;
	
	public Player(String name, long initialCash, Utils.Piece piece)
	{
		this.name = name;
		this.money = initialCash;
		this.piece = piece;

		this.position = new String[26];
		Arrays.fill(this.position, " "); // Set Initial Value for all Elements as " "

		this.position[0] = Utils.pieceToChar(this.piece);
		this.location = 0;
	}
	
	void changeMoney(long amount)
	{
		this.money += amount;
	}

	void setPosition(int offset) {
		this.position[this.location] = " ";
		this.location += offset;
		this.position[this.location] = Utils.pieceToChar(this.piece);
	}

	public String toString()
	{
		return "Name: " + this.name + " --- Cash: " + this.money + " --- Piece: " + this.piece;
	}
}
