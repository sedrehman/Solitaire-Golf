package model;

import javax.swing.ImageIcon;
/**
 * 
 * @author syed rehman
 *
 */
public class IconUtils {

	/**
	 * create image for param filename
	 * 
	 * @param fileNameRelativeToClassFile
	 * @return
	 */
	public ImageIcon createDisplayImage(String fileNameRelativeToClassFile) {
		java.net.URL imgURL = this.getClass().getResource(fileNameRelativeToClassFile);
		if (imgURL == null) {
			throw new IllegalArgumentException("Couldn't find file " + fileNameRelativeToClassFile);
		}
		ImageIcon cardImage = new ImageIcon(imgURL);
		// System.out.println(cardImage.getIconWidth() + " and " +
		// cardImage.getIconHeight());
		return cardImage;

		// retVal.setIcon(cardImage);
		// Dimension d = new Dimension(cardImage.getIconWidth() + 10,
		// cardImage.getIconHeight() + 10);
		// 83, 107
		//
		// retVal.setSize(d);
		// retVal.setPreferredSize(d);
		//
		// retVal.setMaximumSize(d);
		// retVal.setMinimumSize(d);
	}
}
