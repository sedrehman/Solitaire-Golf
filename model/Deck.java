package model;

import java.util.ArrayList;
import java.util.Collections;
/**
 * 
 * @author syed rehman
 *
 */
public class Deck {

	private ArrayList<Card> cards;// a list of 52 cards
	private static final String[] suits = { "diamonds", "clubs", "hearts", "spades" };// helper when initializing deck

	/**
	 * creates a brand new deck
	 */
	public Deck() {// create a NEW deck of 52 cards

		cards = new ArrayList<>();

		IconUtils helper = new IconUtils();

		for (int i = 0; i < 4; i++)
			for (int j = 1; j < 14; j++) {
				String filename = "Cards/" + j + suits[i].charAt(0) + ".gif";
				cards.add(new Card(suits[i], j, helper.createDisplayImage(filename)));
			}
		// suits[0] is diamonds,
		// suits[1] is clubs etc..
		shuffle();

	}

	/**
	 * removes and return the top card of the deck
	 * 
	 * @return top Card
	 */
	public Card dealt() {// return the top card and remove it from deck
		return cards.remove(cards.size() - 1);
	}

	/**
	 * 
	 * @return deck's size()
	 */
	public int size() {// return the amount of card left
		return cards.size();
	}

	/**
	 * randomizes the deck
	 */
	public void shuffle() {// shuffle the deck
		Collections.shuffle(cards);

	}

}