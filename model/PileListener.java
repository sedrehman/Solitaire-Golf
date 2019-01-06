package model;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

import view.GolfGame;

/**
 * 
 * @author syed rehman
 *
 */
public class PileListener implements MouseListener {

	GolfGame game;
	Pile pile;
	boolean highlighted;

	private static final Border UNSELECTED_BORDER = BorderFactory.createEmptyBorder(5, 5, 5, 5);
	private static final Border SELECTED_BORDER = BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK);

	public PileListener(GolfGame g, Pile p) {
		game = g;
		pile = p;
		highlighted = false;
	}

	/**
	 * highlight and selecte the param label
	 * 
	 * @param label
	 */
	public static void highlight(JLabel label) {
		label.setBorder(SELECTED_BORDER);
		label.repaint();
	}

	/**
	 * unhighlight and unselect the param label
	 * 
	 * @param label
	 */
	public static void unhighlight(JLabel label) {
		label.setBorder(UNSELECTED_BORDER);
		label.repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * perform all the actions related
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if (pile instanceof Stock)
			game.stockDealt();
		else if (pile instanceof Homecell && game.selected == null)
			game.homecellException();
		else if (pile instanceof Tableau) {
			if (game.selected == null) {
				highlight(pile.label);
				game.selected = pile;
			} else if (game.selected.equals(pile)) {
				unhighlight(pile.label);
				game.selected = null;
			} else
				game.tableauException();
		} else {
			game.makeMove(pile);
			unhighlight(game.selected.label);
			game.selected = null;
			// System.out.println("reach");
		}
	}

}
