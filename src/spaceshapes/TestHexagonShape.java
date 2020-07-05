package spaceshapes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestHexagonShape {
    private MockPainter _painter;

    /**
     * Setup the painter
     */
    @Before
    public void setUp() {
        _painter = new MockPainter();
    }

    /**
     * Test if the hexagon with width < 40 paints correctly
     */
    @Test
    public void testSmallHexagonShapePaint() {
        HexagonShape shape = new HexagonShape(100, 20, 12, 15, 39, 40);
        shape.paint(_painter);

        assertEquals("(line 100,40,119,20)(line 119,20,119,20)(line 119,20,139,40)" +
                "(line 139,40,119,60)(line 119,60,119,60)(line 119,60,100,40)", _painter.toString());
    }

    /**
     * Test if the hexagon with width >= 40 paints correctly
     */
    @Test
    public void testNormalHexagonShapePaint() {
        HexagonShape shape = new HexagonShape(100, 20, 12, 15, 80, 80);
        shape.paint(_painter);

        assertEquals("(line 100,60,120,20)(line 120,20,160,20)(line 160,20,180,60)" +
                "(line 180,60,160,100)(line 160,100,120,100)(line 120,100,100,60)", _painter.toString());
    }

    /**
     * Test to perform a simple (non-bouncing) movement, and to ensure that the
     * 'small' hexagon's position after the movement is correct.
     */
    @Test
    public void testSmallHexagonShapeSimpleMove() {
        HexagonShape shape = new HexagonShape(100, 20, 12, 15, 39, 40);
        shape.paint(_painter);
        shape.move(500, 500);
        shape.paint(_painter);
        assertEquals("(line 100,40,119,20)(line 119,20,119,20)(line 119,20,139,40)" +
                        "(line 139,40,119,60)(line 119,60,119,60)(line 119,60,100,40)" +
                        "(line 112,55,131,35)(line 131,35,131,35)(line 131,35,151,55)" +
                        "(line 151,55,131,75)(line 131,75,131,75)(line 131,75,112,55)",
                _painter.toString());
    }

    /**
     * Test to perform a simple (non-bouncing) movement, and to ensure that the
     * 'normal' hexagon's position after the movement is correct.
     */
    @Test
    public void testNormalHexagonShapeSimpleMove() {
        HexagonShape shape = new HexagonShape(100, 20, 12, 15, 80, 80);
        shape.paint(_painter);
        shape.move(500, 500);
        shape.paint(_painter);
        assertEquals("(line 100,60,120,20)(line 120,20,160,20)(line 160,20,180,60)" +
                        "(line 180,60,160,100)(line 160,100,120,100)(line 120,100,100,60)" +
                        "(line 112,75,132,35)(line 132,35,172,35)(line 172,35,192,75)" +
                        "(line 192,75,172,115)(line 172,115,132,115)(line 132,115,112,75)",
                _painter.toString());
    }

    /**
     * Test to perform a bounce movement off the bottom right corner and to
     * ensure that the 'small' hexagon's position after the movement is correct.
     */
    @Test
    public void testSmallHexagonShapeMoveWithBounceOffBottomAndRight() {
        HexagonShape shape = new HexagonShape(80, 90, 12, 15, 39, 40);
        shape.paint(_painter);
        shape.move(125, 135);
        shape.paint(_painter);
        shape.move(125, 135);
        shape.paint(_painter);

        assertEquals("(line 80,110,99,90)(line 99,90,99,90)(line 99,90,119,110)" +
                        "(line 119,110,99,130)(line 99,130,99,130)(line 99,130,80,110)" +

                        "(line 86,115,105,95)(line 105,95,105,95)(line 105,95,125,115)" +
                        "(line 125,115,105,135)(line 105,135,105,135)(line 105,135,86,115)" +

                        "(line 74,100,93,80)(line 93,80,93,80)(line 93,80,113,100)" +
                        "(line 113,100,93,120)(line 93,120,93,120)(line 93,120,74,100)"
                , _painter.toString());
    }

    /**
     * Test to perform a bounce movement off the bottom right corner and to
     * ensure that the 'normal' hexagon's position after the movement is correct.
     */
    @Test
    public void testNormalHexagonShapeMoveWithBounceOffBottomAndRight() {
        HexagonShape shape = new HexagonShape(70, 80, 25, 15, 50, 50);
        shape.paint(_painter);
        shape.move(125, 135);
        shape.paint(_painter);
        shape.move(125, 135);
        shape.paint(_painter);

        assertEquals("(line 70,105,90,80)(line 90,80,100,80)(line 100,80,120,105)" +
                        "(line 120,105,100,130)(line 100,130,90,130)(line 90,130,70,105)" +

                        "(line 75,110,95,85)(line 95,85,105,85)(line 105,85,125,110)" +
                        "(line 125,110,105,135)(line 105,135,95,135)(line 95,135,75,110)" +

                        "(line 50,95,70,70)(line 70,70,80,70)(line 80,70,100,95)" +
                        "(line 100,95,80,120)(line 80,120,70,120)(line 70,120,50,95)"
                , _painter.toString());
    }
}
