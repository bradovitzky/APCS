/**********************************************************
 * Assignment: Elevens
 *
 * Authors: Ben Radovitzky
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from no one in designing and debugging
 * my program.
 **********************************************************/
package activity4;

import java.util.ArrayList;

/**
 * The Deck class represents a shuffled deck of cards.
 * It provides several operations including
 *      initialize, shuffle, deal, and check if empty.
 */
public class Deck 
{
	private ArrayList<Card> deck = new ArrayList<Card>();
	private ArrayList<Card> dealt = new ArrayList<Card>();
	
	/**
	 * Creates a new Deck instance.

	 * It pairs each element of ranks with each element of suits,
	 * and produces one of the corresponding card.
	 * @param ranks is an array containing all of the card ranks.
	 * @param suits is an array containing all of the card suits.
	 * @param values is an array containing all of the card point values.
	 */
	public Deck(String[] ranks, String[] suits, int[] values) 
	{
		
		ArrayList<Card> deck = new ArrayList<Card>();
		for(int i=0; i<ranks.length; i++)
		{
			for(int j=0; j<suits.length; j++)
			{
				Card e = new Card(ranks[i], suits[j], values[i]);
				deck.add(e);
			}
		}
		this.deck = deck;
		shuffle();
	}

	/**
	 * Determines if this deck is empty (no undealt cards).
	 * @return true if this deck is empty, false otherwise.
	 */
	public boolean isEmpty() 
	{
		if(deck.size() == 0)
		{
			return true;
		}
		else
			return false;
	}

	/**
	 * Accesses the number of undealt cards in this deck.
	 * @return the number of undealt cards in this deck.
	 */
	public int getCardsLeft() 
	{
		return deck.size();
	}

	/**
	 * Randomly permute the given collection of cards
	 * and reset the size to represent the entire deck.
	 */
	public void shuffle() 
	{
		int randNum;
		System.out.println(dealt.size());
		if(dealt.size() > 0)
		{
			for(Card c:dealt)
			{
				deck.add(c);
			}
		}
		dealt = new ArrayList<Card>();
		for(int i=0; i<deck.size(); i++)
		{
			randNum = (int)(Math.random()*deck.size());
			Card holder = deck.get(i);
			deck.set(i, deck.get(randNum));
			deck.set(randNum, holder);
		}
	}

	/**
	 * Deals a card from this deck.
	 * @return the card just dealt, or null if all the cards have been
	 *         previously dealt.
	 */
	public Card deal() 
	{
		if(deck.size()>0)
		{
			Card topCard = deck.get(0);
			dealt.add(topCard);
			deck.remove(0);
			return topCard;
		}
		else
			return null;
	}
}