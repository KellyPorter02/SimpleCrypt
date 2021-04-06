import org.junit.Test;

import static org.junit.Assert.*;

public class ROTCaesarTest {

    @Test
    public void rotateStringTest0() {
        // Given
        String s1 = "ABCDEF";
        String s2 = "ABCDEF";

        // When
        ROTCaesar cipher = new ROTCaesar();
        String actual = cipher.rotate(s1, 'A');

        // Then
        assertTrue(actual.equals(s2));
    }

    @Test
    public void rotateStringTest1() {
        // Given
        String s1 = "ABCDEF";
        String s2 = "DEFABC";

        // When
        ROTCaesar cipher = new ROTCaesar();
        String actual = cipher.rotate(s1, 'D');

        // Then
        assertTrue(actual.equals(s2));
    }

    @Test
    public void rotateStringTest2() {
        // Given
        String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String s2 = "XYZABCDEFGHIJKLMNOPQRSTUVW";

        // When
        ROTCaesar cipher = new ROTCaesar();
        String actual = cipher.rotate(s1, 'X');
        System.out.println(s1);
        System.out.println(actual);
        // Then
        assertTrue(actual.equals(s2));
    }

    @Test
    public void cryptTest1A() {
        // Given
        ROTCaesar cipher = new ROTCaesar('a', 'x');

        String Q1 = "Why did the chicken cross the road?";
        String A1 = "Jul qvq gur puvpxra pebff gur ebnq?";

        // When
        String actual = cipher.encrypt(Q1);
        System.out.println(Q1);
        System.out.println(actual);
        // Then
        assertTrue(actual.equals(A1));

    }

    @Test
    public void cryptTest1B() {
        // Given
        ROTCaesar cipher = new ROTCaesar('a', 'x');

        String Q2 = "Gb trg gb gur bgure fvqr!";
        String A2 = "To get to the other side!";

        // When
        String actual2 = cipher.decrypt(Q2);
        System.out.println(Q2);
        System.out.println(A2);
        // Then
        assertTrue(actual2.equals(A2));
    }

    @Test
    public void cryptTest2() {
        // Given
        ROTCaesar cipher = new ROTCaesar('a', 'x');

        String Q1 = "Why did the chicken cross the road?";
//        System.out.println(Q1);

        // When
        String actual = cipher.crypt(cipher.crypt(Q1));
        System.out.println(actual);
        // Then
        assertTrue(actual.equals(Q1));
    }

}