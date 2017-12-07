import java.awt.Graphics2D;

import javax.swing.JLabel;

/**
 * Flock is a part of the Composite pattern required in Step 3. It lists the
 * methods needed any kind of number of birds.
 * 
 * @author Tian Low ttl2132
 *
 */
public interface Flock {
	/**
	 * Enlarges the bird(s).
	 * 
	 * @param myLabel
	 *            the label the bird(s) are in
	 */
	public void grow(JLabel myLabel);

	/**
	 * Draws the bird(s).
	 * 
	 * @param g2D
	 *            the 2D graphics that helps draw the bird parts
	 */
	void draw(Graphics2D g2D);

	/**
	 * Moves the bird(s).
	 * 
	 * @param xChange
	 *            the horizontal change in position
	 * @param yChange
	 *            the vertical change in position
	 */
	public void translate(int xChange, int yChange);
}
