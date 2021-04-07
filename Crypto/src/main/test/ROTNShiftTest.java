import org.junit.Test;

import static org.junit.Assert.*;

public class ROTNShiftTest {

    @Test
    public void rotateStringTest0() {
        // Given
        String s1 = "ABCDEF";
        String s2 = "BCDEFA";

        // When
        ROTNShift cipher = new ROTNShift();
        String actual = cipher.rotate(s1, 'B');

        // Then
        assertTrue(actual.equals(s2));
    }

    @Test
    public void rotateStringTest1() {
        // Given
        String s1 = "ABCDEF";
        String s2 = "DEFABC";

        // When
        ROTNShift cipher = new ROTNShift();
        String actual = ROTNShift.rotate(s1, 'D');

        // Then
        assertTrue(actual.equals(s2));
    }

    @Test
    public void rotateStringTest2() {
        // Given
        String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String s2 = "UVWXYZABCDEFGHIJKLMNOPQRST";

        // When
        ROTNShift cipher = new ROTNShift();
        String actual = cipher.rotate(s1, 'U');
        System.out.println(s1);
        System.out.println(actual);
        // Then
        assertTrue(actual.equals(s2));
    }

    @Test
    public void cryptTest1() {
        // Given
        ROTNShift cipher = new ROTNShift('A', 'N');

        String Q1 = "Why did the chicken cross the road?";
        String A1 = "Jul qvq gur puvpxra pebff gur ebnq?";

        String Q2 = "Gb trg gb gur bgure fvqr!";
        String A2 = "To get to the other side!";

        // When
        String actual = cipher.encrypt(Q1);
        System.out.println(Q1);
        System.out.println(A1);
        // Then
        assertTrue(actual.equals(A1));

        // When
        String actual2 = cipher.decrypt(Q2);
        System.out.println(Q2);
        System.out.println(A2);
        // Then
        assertTrue(actual2.equals(A2));
    }

    @Test
    public void calculateShift() {
        // Given
        int expected = 2;
        // When
        ROTNShift cipher = new ROTNShift();
        int returned = cipher.calculateShift('a', 'c');
        // Then
        assertEquals(expected, returned);
    }

    @Test
    public void calculateShift2() {
        // Given
        int expected = 2;
        // When
        ROTNShift cipher = new ROTNShift();
        int returned = cipher.calculateShift('Y', 'A');
        // Then
        assertEquals(expected, returned);
    }

    @Test
    public void shiftString() {
        // Given
        String expected = "CDAB";
        // When
        ROTNShift cipher = new ROTNShift();
        String returned = cipher.shiftString("ABCD");
        System.out.println(returned);
        // Then
        assertEquals(expected, returned);
    }


}