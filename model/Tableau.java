package model;

/**
 * 
 * @author syed rehman
 *
 */

public class Tableau extends Pile {

	public Tableau() {
	}

	/**
	 * This method determines what is legal for adding a card
	 * 
	 * @param card
	 * @return false because it is always false.
	 */
	public boolean legalAdding(Card card) {
		return false;
	}

	/**
	 * method return true when pile is not empty
	 * 
	 * @return the size of the pile.
	 */
	public boolean legalRemoving() {
		return cards.size() != 0;
	}

}
