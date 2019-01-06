package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import control.*;
/**
 * 
 * @author syed rehman
 * 
 * This is class creates the Menu Bar and returns it.
 */

public class FT_MenuBar {
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem golf;
	private JMenuItem exit;
	
	public FT_MenuBar(JFrame frame, JPanel panel) {
	
		menuBar = new JMenuBar();
		menu = new JMenu("New Games..");
		
		golf = new JMenuItem("New Golf");
		golf.addActionListener(new GolfMenuListener(frame, panel));
		
		exit = new JMenuItem("Exit app");
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				System.exit(0);
			}
		});
		menu.add(golf);
		menu.add(exit);
		menuBar.add(menu);
		
	}

	public JMenuBar getMenuBar() {
		return menuBar;
	}

}
