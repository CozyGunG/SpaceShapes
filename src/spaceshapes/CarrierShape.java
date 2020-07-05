package spaceshapes;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CarrierShape extends Shape{
    protected List<Shape> _childrenShapes = new ArrayList<Shape>();

    /**
     * Creates a CarrierShape object with default values for instance variables.
     */
    public CarrierShape() {
        super();
    }

    /**
     * Creates a CarrierShape object with a specified x and y position.
     */
    public CarrierShape(int x, int y) {
        super(x, y);
    }

    /**
     * Creates a CarrierShape instance with specified x, y, deltaX and deltaY values.
     * The Shape object is created with a default width and height.
     */
    public CarrierShape(int x, int y, int deltaX, int deltaY) {
        super(x,y,deltaX,deltaY);
    }

    /**
     * Creates a CarrierShape instance with specified x, y, deltaX, deltaY, width and
     * height values.
     */
    public CarrierShape(int x, int y, int deltaX, int deltaY, int width, int height) {
        super(x,y,deltaX,deltaY,width,height);
    }

    /**
     * Moves this Shape object and the shapes inside it within the specified bounds. On hitting a
     * boundary the Shape instance bounces off and back into the two-dimensional world.
     * The child shapes inside move relative to the Carrier Shape and bounce withing the CarrierShape
     * width and height bounds.
     * @param width - width of two-dimensional world.
     * @param height - height of two-dimensional world.
     */
    public void move(int width, int height) {
        int nextX = _x + _deltaX;
        int nextY = _y + _deltaY;

        if (nextX <= 0) {
            nextX = 0;
            _deltaX = -_deltaX;
        } else if (nextX + _width >= width) {
            nextX = width - _width;
            _deltaX = -_deltaX;
        }

        if (nextY <= 0) {
            nextY = 0;
            _deltaY = -_deltaY;
        } else if (nextY + _height >= height) {
            nextY = height - _height;
            _deltaY = -_deltaY;
        }

        _x = nextX;
        _y = nextY;
    }

    /**
     * Paints this CarrierShape object using the supplied Painter object.
     */
    public void paintShape(Painter painter) {
        painter.drawRect(_x,_y,_width,_height);
        painter.translate(this._x, this._y);
        for (Shape s : _childrenShapes) {
            s.move(_width, _height);
            s.paint(painter);
        }
        painter.translate(-this._x, -this._y);
    }

    /**
     * Adds the specified shape as one of the CarrierShape's children shapes
     * on the condition that the shape does not already have a parent and that the shape
     * fits inside the CarrierShape. Otherwise, it will throw an IllegalArgumentException.
     * If the method runs successfully, a two way link will be made between the CarrierShape
     * and the child shape
     * @param shape the child shape that is being added
     */
    public void add(Shape shape) throws IllegalArgumentException {
        if (shape.parent() == null && shape._x >= 0 && shape._width + shape._x <= this._width &&
                shape._y >= 0 && shape._height + shape._y <= this._height) {
            _childrenShapes.add(shape);
            shape._parentShape = this;
            shape.addParent(this.path());
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Overridden method from Shape. This method cooperates with the add
     * method above such that when the child shape (that is being added to
     * the carrier shape) happens to be another carrier shape, the path must
     * be updated for all child shapes. This method will keep reiterating until
     * it reaches the child shape with no more child shapes.
     * @param shapeList
     */
    public void addParent(List<Shape> shapeList) {
        for (Shape s : shapeList) {
            _path.add(0, s);
        }
        for (Shape s : _childrenShapes) {
            s.addParent(shapeList);
        }
    }

    /**
     * Removes the specific shape from the CarrierShape and updates the path
     * of the child shape and removes the CarrierShape from as its parent and
     * updates it to null.
     * @param shape
     */
    public void remove(Shape shape) {
        if (_childrenShapes.contains(shape)) {
            _childrenShapes.remove(shape);
            shape._parentShape = null;
            shape._path.removeAll(this.path());
        }
    }

    /**
     * Finds the child shape specified at the index
     */
    public Shape shapeAt(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > _childrenShapes.size()-1) {
            throw new IndexOutOfBoundsException();
        }
        return _childrenShapes.get(index);
    }

    /**
     * Returns the number of childrenShapes the CarrierShape has
     */
    public int shapeCount() {
        return _childrenShapes.size();
    }

    /**
     * Returns the index of the child shape stored in the CarrierShape
     */
    public int indexOf(Shape shape) {
        return _childrenShapes.indexOf(shape);
    }

    /**
     * Checks if the CarrierShape contains the Child Shape specified
     */
    public boolean contains(Shape shape) {
        return _childrenShapes.contains(shape);
    }
}
