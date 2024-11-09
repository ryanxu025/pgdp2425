package pgdp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pgdp.triangles.Point2D;
import pgdp.triangles.Triangle;
import pgdp.triangles.TriangleFactory;
import pgdp.triangles.Vector2D;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

    // ***********************************
    // DO NOT DELETE OR CHANGE THE FOLLOWING LINES
    // ***********************************
    @BeforeEach
    void setup() {
        PinguLib.setup();
    }

    @AfterEach
    void reset() {
        PinguLib.reset();
    }
    // ***********************************
    @Test
    public void testValidTriangle1() {
        TriangleFactory triangleFactory = TriangleFactory.getInstance();
        Triangle triangle = triangleFactory.createTriangle(new Point2D(1,1),new Point2D(1,1),new Point2D(2,3));
        assertEquals(PinguLib.getConsoleOutput(),  "Ungültiges Dreieck!");
    }
    @Test
    public void testValidTriangle2() {
        TriangleFactory triangleFactory = TriangleFactory.getInstance();
        Triangle triangle = triangleFactory.createTriangle(new Point2D(1,1),new Point2D(2,2),new Point2D(3,3));
        assertEquals(PinguLib.getConsoleOutput(),  "Ungültiges Dreieck!");
    }
    @Test
    public void testValidTriangle3() {
        TriangleFactory triangleFactory = TriangleFactory.getInstance();
        Triangle triangle = triangleFactory.createTriangle(new Point2D(0,0),new Point2D(2,2),new Point2D(1,2));
        assertEquals(PinguLib.getConsoleOutput(),  "");
    }
    @Test
    public void testValidTriangle4() {
        TriangleFactory triangleFactory = TriangleFactory.getInstance();
        Triangle triangle = triangleFactory.createTriangle(new Point2D(0,1),new Point2D(3,2),new Point2D(3,1));
        assertEquals(PinguLib.getConsoleOutput(),  "");
    }
//    @Test
//    public void testGetA() {
//        TriangleFactory triangleFactory = TriangleFactory.getInstance();
//        Triangle triangle = triangleFactory.createTriangle(new Point2D(0,0),new Point2D(2,2),new Point2D(1,2));
//        assertEquals(new Point2D(0,0),  triangle.getA());
//    }
    @Test
    public void testGetAB() {
        TriangleFactory triangleFactory = TriangleFactory.getInstance();
        Triangle triangle = triangleFactory.createTriangle(new Point2D(1,1),new Point2D(2,2),new Point2D(1,2));
        assertEquals(new Vector2D(1,1),  triangle.getAB());
    }

    @Test
    public void testSetA1() {
        TriangleFactory triangleFactory = TriangleFactory.getInstance();
        Triangle triangle = triangleFactory.createTriangle(new Point2D(1,0),new Point2D(2,2),new Point2D(3,3));
        triangle.setA(new Point2D(1,1));
        assertEquals(PinguLib.getConsoleOutput(),  "Ungültiges Dreieck!");
        assertNotEquals(new Point2D(1,1),  triangle.getA());
    }
    @Test
    public void testSetA2() {
        TriangleFactory triangleFactory = TriangleFactory.getInstance();
        Triangle triangle = triangleFactory.createTriangle(new Point2D(1,0),new Point2D(2,2),new Point2D(3,3));
        triangle.setA(new Point2D(1,2));
        assertEquals(PinguLib.getConsoleOutput(),  "");
        assertEquals(new Point2D(1,2),  triangle.getA());
    }

    @Test
    public void testAngle() {
        TriangleFactory triangleFactory = TriangleFactory.getInstance();
        Triangle triangle = triangleFactory.createTriangle(new Point2D(2,0),new Point2D(-1,0),new Point2D(1,1));
        assertEquals(0.7853981633974484, triangle.getAngleAtA(), 1e-12);
    }

    @Test
    public void testArea() {
        TriangleFactory triangleFactory = TriangleFactory.getInstance();
        Triangle triangle = triangleFactory.createTriangle(new Point2D(2,0),new Point2D(-1,0),new Point2D(1,1));
//        PinguLib.write(triangle.getArea());
        assertEquals(1.5000000000000002, triangle.getArea(), 1e-12);
    }
    @Test
    public void testIsScalene1() {
        TriangleFactory triangleFactory = TriangleFactory.getInstance();
        Triangle triangle = triangleFactory.createTriangle(new Point2D(1,0),new Point2D(-1,0),new Point2D(1,1));
        assertTrue(triangle.isScalene());
    }
    @Test
    public void testIsScalene2() {
        TriangleFactory triangleFactory = TriangleFactory.getInstance();
        Triangle triangle = triangleFactory.createTriangle(new Point2D(0,0),new Point2D(1,0),new Point2D(0,1));
        assertFalse(triangle.isScalene());
    }

    @Test
    public void testIsIsosceles1() {
        TriangleFactory triangleFactory = TriangleFactory.getInstance();
        Triangle triangle = triangleFactory.createTriangle(new Point2D(0,0),new Point2D(1,0),new Point2D(0,1));
        assertTrue(triangle.isIsosceles());
    }
    @Test
    public void testIsIsosceles2() {
        TriangleFactory triangleFactory = TriangleFactory.getInstance();
        Triangle triangle = triangleFactory.createTriangle(new Point2D(1,0),new Point2D(0,0),new Point2D(0,1));
        assertTrue(triangle.isIsosceles());
    }
    @Test
    public void testIsIsosceles3() {
        TriangleFactory triangleFactory = TriangleFactory.getInstance();
        Triangle triangle = triangleFactory.createTriangle(new Point2D(0,1),new Point2D(1,0),new Point2D(0,0));
        assertTrue(triangle.isIsosceles());
    }
    @Test
    public void testIsIsosceles4() {
        TriangleFactory triangleFactory = TriangleFactory.getInstance();
        Triangle triangle = triangleFactory.createTriangle(new Point2D(0,1),new Point2D(2,0),new Point2D(0,0));
        assertFalse(triangle.isIsosceles());
    }
    @Test
    public void testIsIsosceles5() {
        TriangleFactory triangleFactory = TriangleFactory.getInstance();
        Triangle triangle = triangleFactory.createTriangle(new Point2D(1,0),new Point2D(-1,0),new Point2D(0,Math.sqrt(3)));
        assertTrue(triangle.isIsosceles());
    }

    @Test
    public void testIsEquilateral1() {
        TriangleFactory triangleFactory = TriangleFactory.getInstance();
        Triangle triangle = triangleFactory.createTriangle(new Point2D(1,0),new Point2D(-1,0),new Point2D(0,Math.sqrt(3)));
        assertTrue(triangle.isEquilateral());
    }
    @Test
    public void testIsEquilateral2() {
        TriangleFactory triangleFactory = TriangleFactory.getInstance();
        Triangle triangle = triangleFactory.createTriangle(new Point2D(0,0),new Point2D(-1,0),new Point2D(0,1));
        assertFalse(triangle.isEquilateral());
    }
}
