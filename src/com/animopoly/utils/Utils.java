package com.animopoly.utils;

public class Utils
{

	public enum Piece {
		DOG,
		CAT,
		MOUSE,
		COCK
	}

	public static String pieceToChar(Piece piece)
	{
		switch(piece)
		{
			case DOG: return "\uD83D\uDC15";
			case CAT: return "\uD83D\uDC08";
			case MOUSE: return "\uD83D\uDC01";
			case COCK: return "\uD83D\uDC13";
			default:
				return "Symbol not Found";
		}
	}
}
