package spaceshapes;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class TestDynamicShape {
    private MockPainter _painter;

    /**
     * Setup the painter
     */
    @Before
    public void setUp() {
        _painter = new MockPainter();
    }

    /**
     * Test how the DynamicShape behaves after it bounces off the right wall
     * The test should show that the dynamic shape paints to the color specified at
     * construction time and reset back to the default color after the filled rectangle
     * shape is painted. Then it gets painted again as the 'new' color as a filled rectangle
     * then switch back to the default colour.
     */
    @Test
    public void testDynamicShapeMoveWithBounceOffRight() {
        DynamicShape shape = new DynamicShape(100, 20, 12, 15, Color.CYAN);
        shape.paint(_painter);
        shape.move(135, 10000);
        shape.paint(_painter);
        shape.move(135, 10000);
        shape.paint(_painter);
        assertEquals("(rectangle 100,20,25,35)(color java.awt.Color[r=0,g=255,b=255])" +
                "(filled rectangle 110,35,25,35)(color java.awt.Color[r=212,g=212,b=212])" +
                "(color java.awt.Color[r=0,g=255,b=255])(filled rectangle 98,50,25,35)" +
                "(color java.awt.Color[r=212,g=212,b=212])", _painter.toString());
    }

    /**
     * Test how the DynamicShape behaves after it bounces off the left wall
     * The test should show that the dynamic shape paints to the color specified at
     * construction time and reset back to the default color after the filled rectangle
     * shape is painted. Then it gets painted again as the 'new' color as a filled rectangle
     * then switch back to the default colour.
     */
    @Test
    public void testDynamicShapeMoveWithBounceOffLeft() {
        DynamicShape shape = new DynamicShape(10, 20, -12, 15, Color.CYAN);
        shape.paint(_painter);
        shape.move(10000, 10000);
        shape.paint(_painter);
        shape.move(10000, 10000);
        shape.paint(_painter);
        assertEquals("(rectangle 10,20,25,35)(color java.awt.Color[r=0,g=255,b=255])" +
                "(filled rectangle 0,35,25,35)(color java.awt.Color[r=212,g=212,b=212])" +
                "(color java.awt.Color[r=0,g=255,b=255])(filled rectangle 12,50,25,35)" +
                "(color java.awt.Color[r=212,g=212,b=212])", _painter.toString());
    }

    /**
     * Test how the DynamicShape behaves after it bounces the top wall.
     * The test should show that the dynamic shape does not change color and
     * remains unfilled.
     */
    @Test
    public void testDynamicShapeMoveWithBounceOffTop() {
        DynamicShape shape = new DynamicShape(10, 10, 15, -20, Color.CYAN);
        shape.paint(_painter);
        shape.move(10000, 10000);
        shape.paint(_painter);
        shape.move(10000, 10000);
        shape.paint(_painter);
        assertEquals("(rectangle 10,10,25,35)(rectangle 25,0,25,35)(rectangle 40,20,25,35)", _painter.toString());
    }

    /**
     * Test how the DynamicShape behaves after it bounces the bottom wall.
     * The test should show that the dynamic shape does not change color and
     * remains unfilled.
     */
    @Test
    public void testDynamicShapeMoveWithBounceOffBottom() {
        DynamicShape shape = new DynamicShape(100, 10, 12, -15, Color.CYAN);
        shape.paint(_painter);
        shape.move(10000, 10000);
        shape.paint(_painter);
        shape.move(10000, 10000);
        shape.paint(_painter);
        assertEquals("(rectangle 100,10,25,35)(rectangle 112,0,25,35)(rectangle 124,15,25,35)", _painter.toString());
    }

    /**
     * The next four tests should show that the coloring and filling takes priority.
     * All tests should behave the same (coloring and filling)
     */
    @Test
    public void testDynamicShapeMoveWithBounceOffBottomAndLeft() {
        DynamicShape shape = new DynamicShape(10, 90, -12, 15, Color.CYAN);
        shape.paint(_painter);
        shape.move(125, 135);
        shape.paint(_painter);
        shape.move(125, 135);
        shape.paint(_painter);
        assertEquals("(rectangle 10,90,25,35)(color java.awt.Color[r=0,g=255,b=255])" +
                "(filled rectangle 0,100,25,35)(color java.awt.Color[r=212,g=212,b=212])" +
                "(color java.awt.Color[r=0,g=255,b=255])(filled rectangle 12,85,25,35)" +
                "(color java.awt.Color[r=212,g=212,b=212])", _painter.toString());
    }

    @Test
    public void testDynamicShapeMoveWithBounceOffBottomAndRight() {
        DynamicShape shape = new DynamicShape(90, 90, 20, 15, Color.CYAN);
        shape.paint(_painter);
        shape.move(125, 135);
        shape.paint(_painter);
        shape.move(125, 135);
        shape.paint(_painter);
        assertEquals("(rectangle 90,90,25,35)(color java.awt.Color[r=0,g=255,b=255])" +
                "(filled rectangle 100,100,25,35)(color java.awt.Color[r=212,g=212,b=212])" +
                "(color java.awt.Color[r=0,g=255,b=255])(filled rectangle 80,85,25,35)" +
                "(color java.awt.Color[r=212,g=212,b=212])", _painter.toString());
    }

    @Test
    public void testDynamicShapeMoveWithBounceOffTopAndRight() {
        DynamicShape shape = new DynamicShape(90, 10, 20, -15, Color.CYAN);
        shape.paint(_painter);
        shape.move(125, 10000);
        shape.paint(_painter);
        shape.move(125, 10000);
        shape.paint(_painter);
        assertEquals("(rectangle 90,10,25,35)(color java.awt.Color[r=0,g=255,b=255])" +
                "(filled rectangle 100,0,25,35)(color java.awt.Color[r=212,g=212,b=212])" +
                "(color java.awt.Color[r=0,g=255,b=255])(filled rectangle 80,15,25,35)" +
                "(color java.awt.Color[r=212,g=212,b=212])", _painter.toString());
    }

    @Test
    public void testDynamicShapeMoveWithBounceOffTopAndLeft() {
        DynamicShape shape = new DynamicShape(10, 10, -20, -15, Color.CYAN);
        shape.paint(_painter);
        shape.move(10000, 10000);
        shape.paint(_painter);
        shape.move(10000, 10000);
        shape.paint(_painter);
        assertEquals("(rectangle 10,10,25,35)(color java.awt.Color[r=0,g=255,b=255])" +
                "(filled rectangle 0,0,25,35)(color java.awt.Color[r=212,g=212,b=212])" +
                "(color java.awt.Color[r=0,g=255,b=255])(filled rectangle 20,15,25,35)" +
                "(color java.awt.Color[r=212,g=212,b=212])", _painter.toString());
    }
}
