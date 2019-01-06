package view;

/**
 * This class is the game logic of the golf version of solitaire. It creates
 * the different piles in the game and sets up the game itself.
 * @author William Wang (Ziliang)
 * @author Scott Wallace
 */

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.*;
import control.*;
/**
 * 
 * @author syed rehman
 *
 */
public class GolfGame {

	protected ArrayList<Tableau> tableaus;// 7 tableau piles instances
	protected Homecell homecell;// homecell pile instance
	protected Stock stock;// stock pile instance
	public Pile selected;
	protected int score;
	protected int moves;
	protected int multiplier;
	protected JLabel scoreLabel;
	protected JLabel movesLabel;
	protected JLabel multiplierLabel;
	protected int combo;

	/**
	 * This method sets up the game by introducing the piles and dealing out cards.
	 */
	public GolfGame() {
		Deck deck = new Deck();
		tableaus = new ArrayList<>();
		homecell = new Homecell();
		stock = new Stock();
		selected = null;
		score = 0;
		moves = 0;
		multiplier = 1;
		scoreLabel = new JLabel();
		movesLabel = new JLabel();
		multiplierLabel = new JLabel();

		for (int i = 0; i < 7; i++) {
			Tableau pile = new Tableau();
			for (int j = 0; j < 5; j++) {
				pile.add(deck.dealt());// dealt cards to tableau at index i
			}
			pile.label.addMouseListener(new PileListener(this, pile));
			tableaus.add(pile);
		}
		while (deck.size() != 0)
			stock.add(deck.dealt());
		stock.label.addMouseListener(new PileListener(this, stock));

		homecell.label.addMouseListener(new PileListener(this, homecell));

		update();
	}

	/**
	 * Dealt card from stock to homecell
	 */
	public void stockDealt() {
		if (stock.legalRemoving()) {
			homecell.add(stock.remove());
			++moves;
			update();
		} else
			JOptionPane.showMessageDialog(null, "There's no more card in stock!", "Ops", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * move top card from tableau instance SELECTED to param PILE
	 * 
	 * @param pile
	 */
	public void makeMove(Pile pile) {
		if (!selected.legalRemoving())
			JOptionPane.showMessageDialog(null, "No more card in this pile!", "Ops", JOptionPane.WARNING_MESSAGE);
		else if (!pile.legalAdding(selected.peek()))
			JOptionPane.showMessageDialog(null, "Card rank is to be 1 above or below!", "Ops",
					JOptionPane.WARNING_MESSAGE);
		else {
			pile.add(selected.remove());
			score += 10 * multiplier;
			++moves;
			update();
		}
	}

	/**
	 * update the Image label for each pile instance
	 */
	public void update() {

		IconUtils helper = new IconUtils();

		// tableaus
		for (int i = 0; i < tableaus.size(); i++) {
			Tableau pile = tableaus.get(i);
			if (pile.size() == 0)
				pile.label.setIcon(helper.createDisplayImage("../Cards/green.gif"));
			else
				pile.label.setIcon(pile.peek().getImg());
		}

		// stock
		stock.label.setIcon(helper.createDisplayImage("Cards/gold.gif"));

		// homecell
		if (homecell.size() == 0)
			homecell.label.setIcon(helper.createDisplayImage("Cards/green.gif"));
		else
			homecell.label.setIcon(homecell.peek().getImg());

		scoreLabel.setText("   Score: " + score + "          ");
		movesLabel.setText("Moves: " + moves + "          ");
		multiplierLabel.setText("Multiplier: " + multiplier + "X");

		if (homecell.size() == 52)
			JOptionPane.showMessageDialog(null, "Congratulations!! You Won The Game!!!", "WOOOHOO",
					JOptionPane.INFORMATION_MESSAGE);
	}

	// public void updateMultiplier() {
	// }

	/**
	 * show "cannot selected homecell" popup message
	 */
	public void homecellException() {
		JOptionPane.showMessageDialog(null, "Cannot select Homecell ! ! !", "Ops", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * show "cannot add to tableau" popup message
	 */
	public void tableauException() {
		JOptionPane.showMessageDialog(null, "Cannot add card to Tableau!", "Ops", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * return the panel with 7 Tableaus label
	 * 
	 * @return panel
	 */
	public JPanel getCenterPanel() {
		JPanel panel = new JPanel();
		for (int i = 0; i < tableaus.size(); i++) {
			Tableau pile = tableaus.get(i);
			panel.add(pile.label);
		}
		panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
		return panel;
	}

	/**
	 * return the panel with Stock and Homecell label
	 * 
	 * @return panel
	 */
	public JPanel getSouthPanel() {
		JPanel panel = new JPanel();
		panel.add(stock.label);
		panel.add(homecell.label);
		return panel;
	}

	/**
	 * return the panel with Score and Moves label
	 * 
	 * @return panel
	 */
	public JPanel getNorthPanel() {
		JPanel panel = new JPanel();
		panel.add(new JLabel());
		panel.add(scoreLabel);
		panel.add(movesLabel);
		panel.add(multiplierLabel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		return panel;
	}

	public ArrayList<Tableau> getTableaus() {
		return tableaus;
	}

	public Stock getStock() {
		return stock;
	}

	public Homecell getHomecell() {
		return homecell;
	}

}
