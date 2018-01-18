package com.bridgelabz.programs;

import com.bridgelabz.utility.Utility;

public class DeckOfCards {
public static void main(String[] args) {

		Utility utility=new Utility();
		String[] suits={"Clubs","Diamonds","Hearts","Spades"};
		String [] ranks={"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		
		String[] deck=utility.Deck(suits,ranks);
		System.out.println("Deck OF Cards : ");
		System.out.println("_______________\n");
		for(int i=0; i<deck.length; i++)
		{
			System.out.print(deck[i]+" ");
		}
		System.out.print("\n--------------------------");
        utility.distribute(deck);
}
}
