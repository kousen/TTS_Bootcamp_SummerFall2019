import org.junit.Test;

import static org.junit.Assert.*;

public class HelloWorldTest {
    private HelloWorld helloWorld = new HelloWorld();
    public static final int MAX_VALUE = 5_000_000;

    @Test
    public void checkIntegerDivision() {
        assertEquals(2, 5/2);
    }

    @Test
    public void checkFloatingPointDivision() {
        assertEquals(2.5, 5/2., 0.01);
    }

    @Test
    public void isLengthGreaterThan() {
        int x = 5;
        assertTrue(helloWorld.isLengthGreaterThan("hello", x));
    }

    @Test
    public void verifyMethodWorksForNulls() {
        assertFalse(helloWorld.isLengthGreaterThan(null, 5));
    }
}