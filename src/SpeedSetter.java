import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This class creates a JSlider that can change the speed of the hot air
 * balloon(s) in the main runner. 0 makes the hot air balloons stop moving.
 * 
 * @author Tian Low ttl2132 derived from
 *         https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/components/SliderDemoProject/src/components/SliderDemo.java
 * 
 */
public class SpeedSetter extends JPanel implements ActionListener, ChangeListener {
	private static JSlider speedSlider = new JSlider(JSlider.VERTICAL, 0, 10, 5);
	private static JLabel sliderLabel = new JLabel("Speed", JLabel.CENTER);
	private static Timer myTimer;
	private int delay;
	private static final int DELAY = 30;
	private boolean frozen;
	private MovingObject myObj;
	private JLabel mOLabel;

	/**
	 * Constructs the JSlider that sets the speed for the hot air balloons
	 * 
	 * @param myFrame
	 *            the frame that the slider will be placed in
	 * @param myObj
	 *            which object the slider will affect
	 * @param mOLabel
	 *            which label the affected object will be in
	 */
	public SpeedSetter(JFrame myFrame, MovingObject myObj, JLabel mOLabel) {
		this.myObj = myObj;
		this.mOLabel = mOLabel;
		speedSlider.setMajorTickSpacing(5);
		speedSlider.setMinorTickSpacing(1);
		speedSlider.setPaintTicks(true);
		speedSlider.setPaintLabels(true);
		speedSlider.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		sliderLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		Font font = new Font("Serif", Font.BOLD, 40);
		speedSlider.setFont(font);
		myFrame.add(speedSlider);
		myFrame.add(sliderLabel);
		myTimer = new Timer(DELAY, this);
		speedSlider.addChangeListener(this);
	}

	/**
	 * Whenever the sliding occurs at a nonzero value, the objects will move up.
	 */
	public void actionPerformed(ActionEvent event) {
		myObj.translate(0, -10);
		mOLabel.repaint();
	}

	/**
	 * When this method is called, the timer to keep track of the mass ascension
	 * begins, and frozen, the value that determines whether the objects are
	 * moving or not is set to false (the objects move at the start).
	 */
	public void startAnimation() {
		// Start (or restart) animating!
		myTimer.start();
		frozen = false;
	}

	/**
	 * When the value of the JSlider starts to change, the method waits until
	 * the slider value stops getting adjusted. Then, the method determines what
	 * speed the objects will be moving at if at all.
	 */
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider) e.getSource();
		if (!source.getValueIsAdjusting()) {
			int denominator = (int) source.getValue();
			if (denominator == 0) {
				if (!frozen)
					stopAnimation();
			} else {
				delay = DELAY / denominator;
				myTimer.setDelay(delay);
				myTimer.setInitialDelay(delay * 10);
				if (frozen)
					startAnimation();
			}
		}
	}

	/**
	 * When this method is called, the timer to keep track of the mass ascension
	 * stop, and frozen, the value that determines whether the objects are
	 * moving or not is set to true. This is used when the slider value is 0.
	 */
	public void stopAnimation() {
		// Stop the animating thread.
		myTimer.stop();
		frozen = true;
	}
}
