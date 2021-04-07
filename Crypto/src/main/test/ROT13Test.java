import org.junit.Test;

import static org.junit.Assert.*;

public class ROT13Test {


    @Test
    public void cryptTest1() {
        // Given
        ROTNShift cipher = new ROTNShift('A', 'N');

        String input = "Why did the chicken cross the road?";
        String expected = "Jul qvq gur puvpxra pebff gur ebnq?";

        // When
        String actual = cipher.encrypt(input);
        System.out.println(input);
        System.out.println(actual);
        // Then
        assertEquals(expected, actual);

    }

    @Test
    public void cryptTest2() {
        // Given
        ROT13 cipher = new ROT13('a', 'n');

        String encrypted = "Gb trg gb gur bgure fvqr!";
        String expected = "To get to the other side!";

        // When
        String actual2 = cipher.decrypt(encrypted);
        System.out.println(encrypted);
        System.out.println(actual2);
        // Then
        assertEquals(expected, actual2);
    }

    @Test
    public void crypt() {
        // Given
        ROT13 cipher = new ROT13('A', 'N');

        String inputText = "Why did the chicken cross the road?";
        // When
        String actual = cipher.crypt(cipher.crypt(inputText));
        System.out.println(actual);
        // Then
        assertTrue(actual.equals(actual));

    }

}