package spaceshapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;



/**
 * Simple GUI program to show an animation of shapes in a confined space. Class spaceshapes.AnimationViewer is
 * a special kind of GUI component (JPanel), and as such an instance of 
 * spaceshapes.AnimationViewer can be added to a JFrame object. A JFrame object is a
 * window that can be closed, minimised, and maximised. The state of an
 * spaceshapes.AnimationViewer object comprises a list of Shapes and a Timer object. An
 * spaceshapes.AnimationViewer instance subscribes to events that are published by a Timer.
 * In response to receiving an event from the Timer, the spaceshapes.AnimationViewer iterates
 * through a list of Shapes requesting that each Shape paints and moves itself.
 * 
 * @author Paramvir Singh (Original Author - Ian Warren)
 * 
 */
@SuppressWarnings("serial")
public class AnimationViewer extends JPanel implements ActionListener {
	// Frequency in milliseconds for the Timer to generate events.
	private static final int DELAY = 20;

	// Collection of Shapes to animate.
	private List<Shape> _shapes;

	private Timer _timer = new Timer(DELAY, this);

	/**
	 * Creates an spaceshapes.AnimationViewer instance with a list of Shape objects and
	 * starts the animation.
	 */
	public AnimationViewer() {
		this.setBackground(Color.BLACK);
		_shapes = new ArrayList<Shape>();
		DynamicShape dynamicShape = new DynamicShape(300, 300, -5, 5, 39, 40, Color.CYAN);
		dynamicShape.setText("DynamicShape");

		RectangleShape rectangleShape = new RectangleShape();
		rectangleShape.setText("RectangleShape");
		// Populate the list of Shapes.
		_shapes.add(dynamicShape);
		_shapes.add(rectangleShape);
		_shapes.add(new RectangleShape(0, 0, 4, 2, 100, 100));
		_shapes.add(new OvalShape(20,20,3, 5));
		
		// Start the animation.
		_timer.start();
	}

	/**
	 * Called by the Swing framework whenever this spaceshapes.AnimationViewer object
	 * should be repainted. This can happen, for example, after an explicit 
	 * repaint() call or after the window that contains this spaceshapes.AnimationViewer
	 * object has been opened, exposed or moved.
	 * 
	 */
	public void paintComponent(Graphics g) {
		// Call inherited implementation to handle background painting.
		super.paintComponent(g);
		
		// Calculate bounds of animation screen area.
		int width = getSize().width;
		int height = getSize().height;
		
		// Create a GraphicsPainter that Shape objects will use for drawing.
		// The GraphicsPainter delegates painting to a basic Graphics object.
		Painter painter = new GraphicsPainter(g);
		
		// Progress the animation.
		for(Shape s : _shapes) {
			s.paint(painter);
			s.move(width, height);
		}
	}

	/**
	 * Notifies this spaceshapes.AnimationViewer object of an ActionEvent. ActionEvents are
	 * received by the Timer.
	 */
	public void actionPerformed(ActionEvent e) {
		// Request that the spaceshapes.AnimationViewer repaints itself. The call to
		// repaint() will cause the spaceshapes.AnimationViewer's paintComponent() method
		// to be called.
		repaint();
	}
	
	
	/**
	 * Main program method to create an spaceshapes.AnimationViewer object and display this
	 * within a JFrame window.
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("Animation viewer");
				frame.add(new AnimationViewer());
		
				// Set window properties.
				frame.setSize(500, 500);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}
}
