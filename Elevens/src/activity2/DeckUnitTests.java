/**********************************************************
 * Assignment: Elevens
 *
 * Authors: Ben Radovitzky
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from no one in designing and debugging
 * my program.
 **********************************************************/
package activity2;

import org.junit.Test;
import testHelp.verify;
import java.util.*;


public class DeckUnitTests
{
	private String[] suits = {"Clubs", "Hearts", "Spades", "Diamonds"};
	private String[] ranks = {"Jack", "Queen", "King", "Ace"};
	private int[] values = {11, 12, 13, 1};

	private String[] suits1 = {"Hearts"};
	private String[] ranks1 = {"Seven"};
	private int[] values1 = {7};
	

	private String[] suits2 = new String[0];
	private String[] ranks2 = new String[0];
	private int[] values2 = new int[0];
	
	@Test
	public void DeckConstructorShouldNotCrash()
	{
		Deck test = new Deck(ranks, suits, values);
        verify.that(test).isOfType(Deck.class);
	}

	@Test
	public void DeckConstructorShouldHandleSingleCard()
	{
		Deck test = new Deck(ranks1, suits1, values1);
		verify.that(test.getCardsLeft()).isEqualTo(1);
	}
	
	@Test
	public void DeckShouldBeCorrectSize()
	{
		Deck test = new Deck(ranks, suits, values);
		verify.that(test.getCardsLeft()).isEqualTo(suits.length*ranks.length);
	}
	
	@Test
	public void DealReturnsCorrectCard()
	{
		Card expected = new Card("Seven", "Hearts", 7);
		Deck d = new Deck(ranks1, suits1, values1);
		Card dealt = d.deal();
		verify.that(dealt.equals(expected)).isTrue();
	}
 	
	@Test
	public void SizeIsZeroAfterDealingAllCards()
	{
		Deck d = new Deck(ranks, suits, values);
		while(d.getCardsLeft()>0)
		{
			d.deal();
		}
		verify.that(d.getCardsLeft() == 0).isTrue();
	}
	
 	@Test
	public void CorrectSizeAfterDealingOneCard()
	{
 		Deck original = new Deck(ranks, suits, values);
		Deck d = new Deck(ranks, suits, values);
		Card c = d.deal();
		verify.that(d.getCardsLeft()).isEqualTo(original.getCardsLeft()-1);
	}
	@Test
	public void DealReturnsNullForEmptyDeck()
	{
		Deck test = new Deck(ranks2, suits2, values2);
		Card nope = test.deal();
		verify.that(nope).isEqualTo(null);
	}
	
	@Test
	public void DeckShouldBeEmptyAfterDealing()
	{
		Deck test = new Deck(ranks1, suits1, values1);
		test.deal();
		verify.that(test.isEmpty()).isTrue();
	}
	@Test
	public void isEmptyReturnsTrueIfEmpty()
	{
		Deck emptyDeck = new Deck(ranks2, suits2, values2);
		verify.that(emptyDeck.isEmpty()).isTrue();
	}
	@Test
	public void isEmptyReturnsFalseIfNotEmpty()
	{
		Deck emptyDeck = new Deck(ranks, suits, values);
		verify.that(emptyDeck.isEmpty()).isFalse();
	}
	
	@Test
	public void ShuffleShouldRearrangeCards()
	{
		Deck original = new Deck(ranks, suits, values);
		Deck shuffled = new Deck(ranks, suits, values);
		int shuffledCardsLeft = shuffled.getCardsLeft();
		int originalCardsLeft = original.getCardsLeft();
		
		boolean isShuffled = false;
		shuffled.shuffle();

		ArrayList<Card> shuffledCards = new ArrayList<Card>();
		for(int i=0; i<shuffledCardsLeft; i++)
		{
			shuffledCards.add(shuffled.deal());
		}
		ArrayList<Card> unshuffledCards = new ArrayList<Card>();
		for(int i=0; i<originalCardsLeft; i++)
		{
			unshuffledCards.add(original.deal());
		}
		
		for(int i=0; i<unshuffledCards.size(); i++)
		{
			if(!unshuffledCards.get(i).equals(shuffledCards.get(i)))
			{
				isShuffled = true;
			}
			else
			{
				isShuffled = false;
			}
		}
		verify.that(isShuffled).isTrue(); 
	}
	@Test
	public void ShuffleCreatesEquivalentDeck()
	{
		Deck original = new Deck(ranks, suits, values);
		Deck shuffled = new Deck(ranks, suits, values);
		int shuffledCardsLeft = shuffled.getCardsLeft();
		int originalCardsLeft = original.getCardsLeft();
		
		shuffled.shuffle();

		ArrayList<Card> shuffledCards = new ArrayList<Card>();
		for(int i=0; i<shuffledCardsLeft; i++)
		{
			shuffledCards.add(shuffled.deal());
		}
		ArrayList<Card> unshuffledCards = new ArrayList<Card>();
		for(int i=0; i<originalCardsLeft; i++)
		{
			unshuffledCards.add(original.deal());
		}
		verify.that(shuffledCards).isEquivalentTo(unshuffledCards);
	}
	@Test
	public void ShuffleShouldResetDeckSize()
	{
		Deck d = new Deck(ranks, suits, values);
		int originalSize = d.getCardsLeft();
		d.deal();
		d.deal();
		d.shuffle();
		verify.that(d.getCardsLeft()).isEqualTo(originalSize);
	}
}
