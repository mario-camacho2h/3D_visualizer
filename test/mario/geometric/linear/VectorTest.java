/*
 * [Graficacion por Computadora]
 * This was a University project
 * U.M.S.S.
 */
package mario.geometric.linear;

import mario.geometric.matrix.Matrix;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mario Camacho
 */
public class VectorTest {

    @Test
    public void testVectorConstructor3Params() {

        Vector expected = new Vector(0, 0, 0);
        expected.setX(1);
        expected.setY(2);
        expected.setZ(3);

        Vector actual = new Vector(1, 2, 3);

        assertTrue(expected.equals(actual));
    }

    @Test
    public void testVectorConstructor4Params() {

        Vector expected = new Vector(0, 0, 0);
        expected.setX(1);
        expected.setY(2);
        expected.setZ(3);
        expected.setW(4);

        Vector actual = new Vector(1, 2, 3, 4);

        assertTrue(expected.equals(actual));
    }

    @Test
    public void testMultipliedBy() {
        Vector expected = new Vector(3, 6, 9);
        Vector actual = new Vector(1, 2, 3);
        actual.multipliedBy(3);

        assertTrue(expected.equals(actual));
    }

    @Test
    public void testDividedBy() {
        Vector expected = new Vector(1, 2, 3);
        Vector actual = new Vector(4, 8, 12);
        actual.dividedBy(4);

        assertTrue(expected.equals(actual));
    }

    @Test
    public void test2DividedBy() {
        Vector expected = new Vector(0.5, 1, 1.5);
        Vector actual = new Vector(1, 2, 3);
        actual.dividedBy(2);

        assertTrue(expected.equals(actual));
    }

    @Test
    public void testMultiply() {
        Vector expected = new Vector(1, 2, 3);
        Vector vector = new Vector(1, 2, 3);
        Matrix matrix = new Matrix(new Vector(1, 0, 0), new Vector(0, 1, 0), new Vector(0, 0, 1));
        Vector actual = vector.multiply(matrix);

        assertTrue(expected.equals(actual));
    }

    @Test
    public void test2Multiply() {
        Vector expected = new Vector(10, 13, 13);
        Vector vector = new Vector(3, 2, 1);
        Matrix matrix = new Matrix(new Vector(1, 3, 2), new Vector(2, 1, 3), new Vector(3, 2, 1));
        Vector actual = vector.multiply(matrix);

        assertTrue(expected.equals(actual));
    }
    
    @Test
    public void testMultiplyAndSet() {
        Vector expected = new Vector(1, 2, 3);
        Vector actual = new Vector(1, 2, 3);
        Matrix matrix = new Matrix(new Vector(1, 0, 0), new Vector(0, 1, 0), new Vector(0, 0, 1));
        actual.multiplyAndSet(matrix);

        assertTrue(expected.equals(actual));
    }

    @Test
    public void test2MultiplyAndSet() {
        Vector expected = new Vector(10, 13, 13);
        Vector actual = new Vector(3, 2, 1);
        Matrix matrix = new Matrix(new Vector(1, 3, 2), new Vector(2, 1, 3), new Vector(3, 2, 1));
        actual.multiplyAndSet(matrix);

        assertTrue(expected.equals(actual));
    }
}
