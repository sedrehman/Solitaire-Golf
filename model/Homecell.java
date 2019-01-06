package model;

/**
 * 
 * @author syed rehman
 *
 */
public class Homecell extends Pile {

	public Homecell() {
	}

	/**
	 * This methods determines what is legal for adding card into pile.
	 * 
	 * @param fromStock
	 * @param card
	 * @return dif
	 */
	public boolean legalAdding(Card card) {
		if (cards.size() == 0)
			return false;// first card should be add from stock
		int dif = Math.abs(card.getRank() - peek().getRank());
		return dif == 1 || dif == 12;// the only cases when dif = 12 are abs(king - ace) & abs(ace - king)
	}

	/**
	 * return if it's legal to add card to homecell
	 * 
	 * @param fromStock
	 * @param card
	 * @return
	 */
	public boolean legalAdding(boolean fromStock, Card card) {
		if (fromStock)
			return true;
		return legalAdding(card);
	}

	/**
	 * This method determines what is legal for removing a card from the pile.
	 * 
	 * @param card
	 * @return false because it always returns false.
	 */
	public boolean legalRemoving() {// always false
		return false; // why ? Do we need this ??
	}
}
