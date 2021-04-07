import org.junit.Test;

import static org.junit.Assert.*;

public class ROTKPTest {

    @Test
    public void cryptTest1() {
        // Given
        ROTKP cipher = new ROTKP('K', 'P');

        String input = "Why did the chicken cross the road?";
        String expected = "Rct ydy ocz xcdxfzi xmjnn ocz mjvy?";

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
        ROTKP cipher = new ROTKP('k', 'p');

        String encrypted = "Rct ydy ocz xcdxfzi xmjnn ocz mjvy?";
        String expected = "Why did the chicken cross the road?";

        // When
        String actual2 = cipher.decrypt(encrypted);
        System.out.println(encrypted);
        System.out.println(actual2);
        // Then
        assertEquals(expected, actual2);
    }

}