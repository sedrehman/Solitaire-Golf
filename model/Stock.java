package model;

/**
 * 
 * @author syed rehman
 *
 */
public class Stock extends Pile {

	public Stock() {
	}

	/**
	 * This method determines what is legal for adding card.
	 * 
	 * @param card
	 * @return false, will always be false.
	 */
	public boolean legalAdding(Card card) {
		return false;
	}

	/**
	 * return true when pile is not empty
	 * 
	 * @return size is not 0
	 */
	public boolean legalRemoving() {// when pile is not empty
		return cards.size() != 0;
	}

}
