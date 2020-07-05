package spaceshapes;

public class OvalShape extends Shape {

    /**
     * Creates an Shape object with default values for instance variables.
     */
    public OvalShape() {
        super();
    }

    /**
     * Creates a Shape instance with a specified x and y position.
     */
    public OvalShape(int x, int y) {
        super(x, y);
    }

    /**
     * Creates a Shape instance with specified x, y, deltaX and deltaY values.
     */
    public OvalShape(int x, int y, int deltaX, int deltaY) {
        super(x,y,deltaX,deltaY);
    }

    /**
     * Creates a Shape instance with specified x, y, deltaX, deltaY, width and
     * height values.
     */
    public OvalShape(int x, int y, int deltaX, int deltaY, int width, int height) {
        super(x,y,deltaX,deltaY,width,height);
    }

    /**
     * Creates an ovalshape using the painter object
     * @param painter the Painter object used for drawing.
     */
    public void paintShape(Painter painter) {
        painter.drawOval(_x,_y,_width,_height);
    }
}
