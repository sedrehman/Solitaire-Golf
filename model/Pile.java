package model;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JLabel;

/**
 * 
 * @author syed rehman
 *
 */
public abstract class Pile {
	protected ArrayList<Card> cards;
	public JLabel label;
	protected final Dimension labelSize = new Dimension(83, 107);

	public Pile() {
		cards = new ArrayList<>();
		label = new JLabel();
		label.setSize(labelSize);
		label.setPreferredSize(labelSize);
		label.setMaximumSize(new Dimension(93, 117));
	}
	

	/**
	 * add method add param card to the top
	 * 
	 * @param card
	 */
	public void add(Card card) {
		cards.add(card);
	}

	/**
	 * remove the top card and return it
	 * 
	 * @return topCard
	 */
	public Card remove() {
		return cards.remove(size() - 1);
	}

	/**
	 * peek return the top card of pile without removing
	 * 
	 * @return topCard
	 */
	public Card peek() {
		return cards.get(size() - 1);
	}

	/**
	 * return the size of the pile
	 * 
	 * @return size
	 */
	public int size() {
		return cards.size();
	}

	public abstract boolean legalAdding(Card card);

	public abstract boolean legalRemoving();
}
