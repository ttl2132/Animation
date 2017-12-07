import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 * 
 * This class is part of the Composite pattern required in Step 3. BirdGroup
 * combines any number of birds and enlarges them as a group (except nulls,
 * because I did not think there would be a reason to create a null bird).
 * 
 * @author Tian Low ttl2132
 *
 */
public class BirdGroup implements Flock, MovingObject {
	private ArrayList<Flock> birds;

	/**
	 * Constructs an empty bird group.
	 */
	public BirdGroup() {
		birds = new ArrayList<Flock>();
	}

	/**
	 * Adds the bird(s) to the bird group.
	 * 
	 * @param bird
	 *            any number of birds
	 */
	public void add(Flock bird) {
		birds.add(bird);
	}

	/**
	 * Draws the bird(s) in the bird group.
	 * 
	 * @param g2D
	 *            the 2D graphics that helps draw the bird parts
	 */
	public void draw(Graphics2D g2D) {
		for (Flock each : birds) {
			each.draw(g2D);
		}
	}

	/**
	 * Moves the bird(s) in the bird group.
	 * 
	 * @param xChange
	 *            the horizontal change in position
	 * @param yChange
	 *            the vertical change in position
	 */
	public void translate(int xChange, int yChange) {
		for (Flock each : birds) {
			each.translate(xChange, yChange);
		}
	}

	/**
	 * Enlarges the bird(s) in the bird group.
	 * 
	 * @param myLabel
	 *            the label the bird(s) are in
	 */
	public void grow(JLabel myLabel) {
		for (Flock each : birds) {
			each.grow(myLabel);
			myLabel.repaint();
		}

	}
}
