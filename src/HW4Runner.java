import java.awt.*;
import javax.swing.*;

/**
 * This class runs the code that starts a program that creates 5 hot air balloons
 * that move up and growing birds that move down on the computer screen. In
 * main, there are 3 main parts: setting up the hot air balloons, setting up the
 * birds, and setting up the frame.
 * 
 * @author Tian Low ttl2132 based on project uploaded by jrk
 */
public class HW4Runner {
	private static final int ICON_W = 3000;
	private static final int ICON_H = 1800;

	public static void main(String[] args) {
		// Making the hot air balloons
		BalloonGroup balloons = new BalloonGroup();
		balloons.massAdd(5);
		final MovingObject balloonGroup = balloons;
		final MyIcon balloonIcon = new MyIcon(balloonGroup, ICON_W / 3, ICON_H);
		final JLabel balloonLabel = new JLabel(balloonIcon);

		// Making the birds: this section is really long, because I wanted to
		// include how both kinds of Flock could work for the composite.
		BirdGroup birdies = new BirdGroup();
		Flock bird = new Bird(300, 200);
		birdies.add(new Bird(100, 100));
		BirdGroup combinedBirdies = new BirdGroup();
		combinedBirdies.add(bird);
		combinedBirdies.add(birdies);
		combinedBirdies.add(new Bird(400, 20));
		final MyIcon birdIcon = new MyIcon((Flock) combinedBirdies, ICON_W / 3, ICON_H);
		final JLabel birdLabel = new JLabel(birdIcon);

		// Setting up the frame
		JFrame myFrame = new JFrame();
		myFrame.setLayout(new FlowLayout());
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.add(balloonLabel);
		myFrame.add(birdLabel);

		SpeedSetter balloonSS = new SpeedSetter(myFrame, balloonGroup, balloonLabel);

		myFrame.setSize(ICON_W, ICON_H);
		myFrame.pack();
		myFrame.setVisible(true);

		// Running the animation!
		// This method was derived from:
		// https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/components/SliderDemoProject/src/components/SliderDemo.java
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				balloonSS.startAnimation();
				combinedBirdies.grow(birdLabel);
			}
		});

	}

}
