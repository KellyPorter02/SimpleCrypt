import org.junit.Test;

import static org.junit.Assert.*;

public class ROTCaesarTest {


    @Test
    public void cryptTest1() {
        // Given
        ROTCaesar cipher = new ROTCaesar('A', 'D');

        String input = "Why did the chicken cross the road?";
        String expected = "Tev afa qeb zefzhbk zolpp qeb olxa?";

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
        ROTCaesar cipher = new ROTCaesar('a', 'd');

        String encrypted = "Tev afa qeb zefzhbk zolpp qeb olxa?";
        String expected = "Why did the chicken cross the road?";

        // When
        String actual2 = cipher.decrypt(encrypted);
        System.out.println(encrypted);
        System.out.println(actual2);
        // Then
        assertEquals(expected, actual2);
    }
}