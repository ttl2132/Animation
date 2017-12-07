import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;

import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * This class is part of the Composite pattern required in Step 3. Bird creates
 * a bird that can move down and grow.
 * 
 * @author Tian Low ttl2132
 *
 */
public class Bird implements Flock, MovingObject {
	private int x;
	private int y;
	private int unit;
	private double size;
	private final double WINGSPAN = 0.5;
	private final double DEFAULTANGLE = 0.4;
	private final int DELAY = 100;

	/**
	 * Constructs a bird with a user-set x position and unit.
	 * 
	 * @param x
	 *            the horizontal position of the bird
	 * @param unit
	 *            the base size of the bird
	 */
	public Bird(int x, int unit) {
		this.x = x;
		this.y = 0;
		this.unit = unit;
		this.size = unit;
	}

	/**
	 * Moves the bird.
	 * 
	 * @param xChange
	 *            the horizontal change in position
	 * @param yChange
	 *            the vertical change in position
	 */
	public void translate(int xChange, int yChange) {
		x += xChange;
		y -= yChange;
	}

	/**
	 * Draws the bird.
	 * 
	 * @param g2D
	 *            the 2D graphics that helps draw the bird parts
	 */
	public void draw(Graphics2D g2D) {
		double xCenter = x + unit / 2;
		int wingXoffset = (int) (WINGSPAN * (size * .5) * Math.sin(DEFAULTANGLE));
		double wingXTop = xCenter;
		int wingYTop = y + (int) size;
		double wingXRTop = wingXTop - wingXoffset;
		double wingXLTop = wingXTop + wingXoffset;
		int wingYBot = wingYTop + (int) (WINGSPAN * (size * 0.5) * Math.cos(DEFAULTANGLE));
		Line2D.Double wingL = new Line2D.Double(wingXLTop, wingYTop, wingXTop, wingYBot);
		Line2D.Double wingR = new Line2D.Double(wingXRTop, wingYTop, wingXTop, wingYBot);
		GeneralPath whole = new GeneralPath();
		whole.append(wingL, false);
		whole.append(wingR, false);
		g2D.draw(whole);
	}

	/**
	 * Changes the size of the bird. The value c is 0.0000001 because it
	 * allows the bird to grow at a good-looking rate.
	 */
	public void changeSize() {
		final double c = 0.0000001;
		this.size += 1 / (1 - DELAY * c);
	}

	/**
	 * Enlarges the bird gradually by each millisecond.
	 * 
	 * @param myLabel
	 *            the label that contains the bird.
	 */
	public void grow(JLabel myLabel) {

		Timer myTimer = new Timer(DELAY, new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				changeSize();
				myLabel.repaint();
			}
		});
		myTimer.start();
	}
}
