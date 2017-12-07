import java.awt.*;

/**
 * 
 * @author Tian Low ttl2132 based on project uploaded by jrk
 * This interface has subclasses that move on the screen.
 *
 */
public interface MovingObject {
	/**
	 * Draws the moving object(s).
	 * @param g2D  the 2D graphics that helps draw the moving object parts
	 */
	void draw(Graphics2D g2D);
	/**
	 * Moves the bird(s) in the bird group.
	 * 
	 * @param xChange
	 *            the horizontal change in position
	 * @param yChange
	 *            the vertical change in position
	 */
	void translate(int xChange, int yChange);
}