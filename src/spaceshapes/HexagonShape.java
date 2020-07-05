package spaceshapes;

public class HexagonShape extends Shape {

    /**
     * Creates a HexagonShape object with default values for instance variables.
     * If no Color is passed in, then Default colour is chosen.
     */
    public HexagonShape() {
        super();
    }

    /**
     * Creates a HexagonShape object with a specified x and y position.
     */
    public HexagonShape(int x, int y) {
        super(x, y);
    }

    /**
     * Creates a HexagonShape object with specified x, y, deltaX and deltaY values.
     * The Shape object is created with a default width and height.
     */
    public HexagonShape(int x, int y, int deltaX, int deltaY) {
        super(x,y,deltaX,deltaY);
    }

    /**
     * Creates a HexagonShape object with specified x, y, deltaX, deltaY, width and
     * height values.
     */
    public HexagonShape(int x, int y, int deltaX, int deltaY, int width, int height) {
        super(x,y,deltaX,deltaY,width,height);
    }

    /**
     * Paints the Hexagon Shape using 6 lines
     * @param painter the Painter object used for drawing.
     */
    public void paintShape(Painter painter) {
        int leftRef, rightRef, midRef, downRef;
        if (_width < 40) {
            rightRef = _x + _width/2;
            leftRef = _x + _width/2;
        }
        else {
            leftRef = _x + 20;
            rightRef = _x + _width - 20;
        }
        midRef = _y + _height/2;
        downRef = _y + _height;

        painter.drawLine(_x, midRef, leftRef, _y);
        painter.drawLine(leftRef, _y, rightRef, _y);
        painter.drawLine(rightRef, _y, _x + _width, midRef);
        painter.drawLine(_x + _width, midRef, rightRef, downRef);
        painter.drawLine(rightRef, downRef, leftRef, downRef);
        painter.drawLine(leftRef, downRef, _x, midRef);
    }
}
