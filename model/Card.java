package model;

import javax.swing.ImageIcon;

/**
 * 
 * @author syed rehman
 *
 */
public class Card {
	/**
	 * String suit of the card int rank of the card
	 */
	private String suit;// suit of the card
	private int rank;// rank of the card
	private ImageIcon img;

	public Card(String suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public Card(String suit, int rank, ImageIcon img) {
		super();
		this.suit = suit;
		this.rank = rank;
		this.img = img;
	}

	public ImageIcon getImg() {
		return img;
	}

	public void setImg(ImageIcon img) {
		this.img = img;
	}

	public int getRank() {
		return rank;
	}

	public String getSuit() {
		return suit;
	}

}
