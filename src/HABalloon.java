import java.awt.*;
import java.awt.geom.*;

/**
 * HABalloon creates a hot air balloon that can float up. They can have a set
 * size, or a randomized size. The default unit for the balloon is size 20,
 * because it looks best that way.
 * 
 * @author Tian Low ttl2132 based on project uploaded by jrk
 */
public class HABalloon implements MovingObject {
	private int x;
	private int y;
	private int unit;
	private double angle;
	private double size;
	private final double STRINGLENGTH = 1.0;
	private final int UNIT = 20;
	private final double DEFAULTANGLE = 0.4;
	private final int ICON_W = 2000;
	private final int ICON_H = 1800;

	/**
	 * Constructs a hot air balloon with a user-set x position, unit, and angle
	 * 
	 * @param x
	 *            the horizontal position of the hot air balloon
	 * @param unit
	 *            the base unit
	 * @param angle
	 *            angle of the hot air balloon strings
	 */
	public HABalloon(int x, int unit, double angle) {
		this.x = x;
		this.y = ICON_H;
		this.unit = unit;
		this.size = unit;
		this.angle = angle;
	}

	/**
	 * Constructs a hot air balloon with an automatically set x position, unit,
	 * and angle
	 * 
	 */
	public HABalloon() {
		this.x = (int) (Math.random() * (ICON_W / 3.1));
		this.y = ICON_H;
		this.unit = UNIT;
		this.size = unit * (Math.random() * 1.5 + 0.5);
		this.angle = DEFAULTANGLE;
	}

	/**
	 * Moves the hot air balloon.
	 * 
	 * @param xChange
	 *            the horizontal change in position
	 * @param yChange
	 *            the vertical change in position
	 */
	public void translate(int xChange, int yChange) {
		x += xChange;
		y += yChange;
	}

	/**
	 * Draws the hot air balloon.
	 * 
	 * @param g2D
	 *            the 2D graphics that helps draw the bird parts
	 */
	public void draw(Graphics2D g2D) {
		int xTopLeft = x;
		int yTopLeft = y;
		double xCenter = x + size / 2;

		// draws the circular top of the hot air balloon
		int topXUpLeft = xTopLeft;
		int topYUpLeft = yTopLeft;
		double topSize = size;
		Ellipse2D.Double top = new Ellipse2D.Double(topXUpLeft, topYUpLeft, topSize, topSize);

		// draws the strings that hold up the balloon
		double stringXTop = xCenter;
		int stringYTop = y + (int) size;
		int stringXoffset = (int) (STRINGLENGTH * (size * .5) * Math.sin(angle));
		double stringXRTop = stringXTop - stringXoffset;
		double stringXLTop = stringXTop + stringXoffset;
		int stringYBot = stringYTop + (int) (STRINGLENGTH * (size * 0.5) * Math.cos(angle));
		Line2D.Double stringL = new Line2D.Double(stringXLTop, stringYTop, stringXTop, stringYBot);
		Line2D.Double stringR = new Line2D.Double(stringXRTop, stringYTop, stringXTop, stringYBot);

		// draws the box where the people stand
		int boxXTop = xTopLeft;
		double boxYTop = y + 1.5 * size;

		// aggregates all of the parts of the hot air balloon into one whole
		Rectangle2D.Double box = new Rectangle2D.Double(boxXTop, boxYTop, size, size);
		GeneralPath whole = new GeneralPath();
		whole.append(top, false);
		whole.append(stringL, false);
		whole.append(stringR, false);
		whole.append(box, false);

		// draws the hot air balloon
		g2D.draw(whole);
		g2D.fill(top);
		g2D.fill(box);
	}

}
