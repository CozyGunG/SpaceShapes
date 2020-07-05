package spaceshapes;

import java.awt.*;

public class DynamicShape extends Shape {
    private boolean _hitRLSide = false, _hitTBSide = false;
    private Color _newColor;
    private static final Color DEFAULT_COLOR = new Color(212, 212, 212);

    /**
     * Creates a DynamicShape object with default values for instance variables.
     * If no Color is passed in, then Default colour is chosen.
     */
    public DynamicShape() {
        super();
        _newColor = DEFAULT_COLOR;
    }

    public DynamicShape(Color color) {
        super();
        _newColor = color;
    }

    /**
     * Creates a DynamicShape object with a specified x and y position.
     * If no Color is passed in, then Default colour is chosen.
     */
    public DynamicShape(int x, int y) {
        super(x, y);
        _newColor = DEFAULT_COLOR;
    }

    public DynamicShape(int x, int y, Color color) {
        super(x, y);
        _newColor = color;
    }

    /**
     * Creates a DynamicShape object with specified x, y, deltaX and deltaY values.
     * The Shape object is created with a default width and height.
     * If no Color is passed in, then Default colour is chosen.
     */
    public DynamicShape(int x, int y, int deltaX, int deltaY) {
        super(x,y,deltaX,deltaY);
        _newColor = DEFAULT_COLOR;
    }

    public DynamicShape(int x, int y, int deltaX, int deltaY, Color color) {
        super(x,y,deltaX,deltaY);
        _newColor = color;
    }

    /**
     * Creates a DynamicShape object with specified x, y, deltaX, deltaY, width and
     * height values. If no Color is passed in, then Default colour is chosen.
     */
    public DynamicShape(int x, int y, int deltaX, int deltaY, int width, int height) {
        super(x,y,deltaX,deltaY,width,height);
        _newColor = DEFAULT_COLOR;
    }

    public DynamicShape(int x, int y, int deltaX, int deltaY, int width, int height, Color color) {
        super(x,y,deltaX,deltaY,width,height);
        _newColor = color;
    }

    /**
     * Moves this Shape object within the specified bounds. Upon hitting a boundary the
     * Shape instance bounces off and back into the two-dimensional world. The shape
     * starts off as an ordinary unfilled white rectangle shape. When it hits the left
     * or right wall, the shape will start painting itself as a filled rectangle with
     * the color specified (default if not specified). It will maintain this state until
     * it hits either the top or bottom wall. When it does so, it will go back to its
     * original unfilled shape with the default color and maintain this state until it
     * hits one of the right or left walls again. When the shape hits one of the four
     * corners, the 'color fill' is prioritised and the shape will be painted as a colored
     * filled shape.
     * @param width - width of two-dimensional world.
     * @param height - height of two-dimensional world.
     */
    public void move(int width, int height) {
        int nextX = _x + _deltaX;
        int nextY = _y + _deltaY;

        if (nextY <= 0) {
            nextY = 0;
            _deltaY = -_deltaY;
            _hitRLSide = false;
            _hitTBSide = true;

        } else if (nextY + _height >= height) {
            nextY = height - _height;
            _deltaY = -_deltaY;
            _hitRLSide = false;
            _hitTBSide = true;
        }

        if (nextX <= 0) {
            nextX = 0;
            _deltaX = -_deltaX;
            _hitRLSide = true;
            _hitTBSide = false;

        } else if (nextX + _width >= width) {
            nextX = width - _width;
            _deltaX = -_deltaX;
            _hitRLSide = true;
            _hitTBSide = false;
        }

        _x = nextX;
        _y = nextY;
    }

    /**
     * Paints the dynamicshape object using the supplied Painter object.
     * @param painter the Painter object used for drawing.
     */
    public void paintShape(Painter painter) {
        if (_hitTBSide) {
            if (painter.getColor() == _newColor) {
                painter.setColor(DEFAULT_COLOR);
            }
            painter.drawRect(_x,_y,_width,_height);
        }
        else if (_hitRLSide) {
            if (painter.getColor() != _newColor) {
                painter.setColor(_newColor);
            }
            painter.fillRect(_x,_y,_width,_height);
            painter.setColor(DEFAULT_COLOR);
        }
        else {
            painter.drawRect(_x, _y, _width, _height);
        }
    }
}

