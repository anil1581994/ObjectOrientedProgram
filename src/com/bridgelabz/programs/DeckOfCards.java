package com.bridgelabz.programs;

public class DeckOfCards {
	public static void main(String[] args) {
		String[] SUITS = { "Clubs", "Diamonds", "Hearts", "Spades" };

		String[] RANKS = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

		// initialize deck
		int n = SUITS.length * RANKS.length;
		String[] deck = new String[n];
		for (int i = 0; i < RANKS.length; i++)
		{
			for (int j = 0; j < SUITS.length; j++)
			{
				deck[SUITS.length * i + j] = RANKS[i] + " of " + SUITS[j];
			}
		}

		// shuffle the card
		for (int i = 0; i < n; i++) 
		{
			int r = i + (int) (Math.random() * (n - i));
			String temp = deck[r];
			deck[r] = deck[i];
			deck[i] = temp;
		}
		// print shuffled deck which must be different
		for (int i = 0; i < 4; i++) 
		{
			System.out.println("Player "+(i+1));//player count
			for (int j = 0; j < 9; j++) 
			{
				System.out.print(deck[i + j * 4] + " (Card " + (i + j * 4) + ")" + " ");
			}
			System.out.println();
		}
	}
}