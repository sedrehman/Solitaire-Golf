package control;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.GolfGame;
/**
 * 
 * @author Syed Rehman
 * this class is just to run Golf Game 
 *
 */
public class GolfMenuListener implements ActionListener {
	private JFrame frame;
	private JPanel panel;
	
	public GolfMenuListener (JFrame f, JPanel panel) {
		this.frame = f;
		this.panel = panel;
	}
	/**
	 * Clears out the frame and adds Little Spider game to the frame
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		GolfGame game = new GolfGame();
		frame.getContentPane().removeAll();
		frame.getContentPane().add(game.getCenterPanel(), BorderLayout.CENTER);
		frame.getContentPane().add(game.getSouthPanel(), BorderLayout.SOUTH);
		frame.getContentPane().add(game.getNorthPanel(), BorderLayout.NORTH);
		frame.repaint();
		frame.pack();

	}

}
