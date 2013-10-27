/*
 * [Graficacion por Computadora]
 * This was a University project
 * U.M.S.S.
 */
package mario.geometric.linear;

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
}