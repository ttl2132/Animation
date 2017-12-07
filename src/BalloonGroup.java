import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * Balloon group combines any number of hot air balloons and moves them as a
 * group (except nulls, because I did not think there would be a reason to
 * create a null hot air balloon).
 * 
 * @author Tian Low ttl2132
 *
 */
public class BalloonGroup implements MovingGroup {
	private ArrayList<MovingObject> balloons;

	/**
	 * Constructs an empty hot air balloon group.
	 */
	public BalloonGroup() {
		balloons = new ArrayList<MovingObject>();
	}

	/**
	 * Adds the hot air balloon(s) to the hot air balloon group.
	 * 
	 * @param balloon
	 *            any number of hot air balloons
	 */
	public void add(MovingObject balloon) {
		balloons.add((HABalloon) balloon);
	}

	/**
	 * Draws the hot air balloon(s) in the hot air balloon group.
	 * 
	 * @param g2D
	 *            the 2D graphics that helps draw the hot air balloon parts
	 */
	public void draw(Graphics2D g2D) {
		for (MovingObject each : balloons) {
			each.draw(g2D);
		}
	}

	/**
	 * Adds any amount of hot air balloons.
	 * 
	 * @param numObjs
	 *            the number of hot air balloons the user wants to add
	 */
	public void massAdd(int numObjs) {
		for (int i = 0; i < numObjs; i++) {
			balloons.add(new HABalloon());
		}
	}

	/**
	 * Moves the hot air balloon(s) in the hot air balloon group.
	 * 
	 * @param xChange
	 *            the horizontal change in position
	 * @param yChange
	 *            the vertical change in position
	 */
	public void translate(int xChange, int yChange) {
		for (MovingObject each : balloons) {
			each.translate(xChange, yChange);
		}
	}
}
