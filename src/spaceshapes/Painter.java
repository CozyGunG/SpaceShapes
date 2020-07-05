package spaceshapes;

//import java.awt.Color;

import java.awt.*;

/**
 * Interface to represent a type that offers primitive drawing methods.
 * 
 * @author Paramvir Singh (Original Author - Ian Warren)
 * 
 */
public interface Painter {
	/**
	 * Draws a rectangle. Parameters x and y specify the top left corner of the
	 * oval. Parameters width and height specify its width and height.
	 */
	public void drawRect(int x, int y, int width, int height);
	
	/**
	 * Draws an oval. Parameters x and y specify the top left corner of the
	 * oval. Parameters width and height specify its width and height.
	 */
	public void drawOval(int x, int y, int width, int height);
	
	/**
	 * Draws a line. Parameters x1 and y1 specify the starting point of the 
	 * line, parameters x2 and y2 the ending point.
	 */
	public void drawLine(int x1, int y1, int x2, int y2);

	/**
	 * Draws a Filled rectangle. Parameters x and y specify the top left corner of the
	 * rectangle. Parameters width and height specify its width and height.
	 */
	public void fillRect(int x, int y, int width, int height);

	/**
	 * Returns the color that is currently set for the graphics object
	 */
	public Color getColor();

	/**
	 * Sets the color as the drawing color
	 */
	public void setColor(Color c);

	/**
	 * Changes the coordinates of the reference point that it will draw from
	 * Shifted by x to the right and y down
	 */
	public void translate(int x, int y);

	/**
	 * Draws a text at the centre of the shape
	 */
	public int drawCentredText(Shape shape, String text);
}
