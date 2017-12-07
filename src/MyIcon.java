import java.awt.*;
import javax.swing.*;

/**
 * MyIcon helps to draw the moving objects.
 * 
 * @author Tian Low ttl2132 based on project uploaded by jrk
 *
 */

public class MyIcon implements Icon {
	/**
	 * Constructs an icon with a type of moving object with specific width and
	 * height parameters.
	 * 
	 * @param obj
	 *            the object being drawn
	 * @param w
	 *            object width
	 * @param h
	 *            object height
	 */
	public MyIcon(MovingObject obj, int w, int h) {
		this.obj = obj;
		this.w = w;
		this.h = h;
	}

	/**
	 * Constructs an icon with a type of moving object with specific width and
	 * height parameters. This constructor is needed in order to remove the
	 * ambiguity of the Flock object.
	 * 
	 * @param obj
	 *            the object being drawn
	 * @param w
	 *            object width
	 * @param h
	 *            object height
	 */
	public MyIcon(Flock obj, int w, int h) {
		this.obj = (MovingObject) obj;
		this.w = w;
		this.h = h;
	}

	/**
	 * Gets the icon width.
	 */
	public int getIconWidth() {
		return w;
	}

	/**
	 * Gets the icon height.
	 */
	public int getIconHeight() {
		return h;
	}

	/**
	 * Paints the icon.
	 * 
	 * @param c
	 *            Component needed to draw on the screen.
	 * @param g
	 *            Graphics needed to draw on the component.
	 * @param x
	 *            the horizontal position of the icon.
	 * @param y
	 *            the vertical position of the icon.
	 */
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2D = (Graphics2D) g;
		obj.draw(g2D);
	}

	private int w;
	private int h;
	private MovingObject obj;
}
