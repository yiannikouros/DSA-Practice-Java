import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TribonnaciNumberTest {
    @Test
    public void findMaxSafeNumber() {
        int n = 0;
        try {
            // Start testing numbers until we either get a StackOverflowError
            // or reach a point where integer overflow would occur
            while (n < 10000) {  // reasonable upper limit for testing
                int result = TribonnaciNumber.trib(n);
                if (result < 0) {  // Check for integer overflow
                    break;
                }
                System.out.println("Successfully calculated trib(" + n + ") = " + result);
                n++;
            }
        } catch (StackOverflowError e) {
            System.out.println("Stack overflow occurred at n = " + n);
        }
        System.out.println("Last successful calculation was at n = " + (n-1));
    }

    @Test
    public void testTribBaseCases() {
        // Keep the original test cases for small numbers
        assertEquals(0, TribonnaciNumber.trib(0));
        assertEquals(0, TribonnaciNumber.trib(1));
        assertEquals(1, TribonnaciNumber.trib(2));
        assertEquals(1, TribonnaciNumber.trib(3));
        assertEquals(2, TribonnaciNumber.trib(4));
        assertEquals(4, TribonnaciNumber.trib(5));
        assertEquals(7, TribonnaciNumber.trib(6));
        assertEquals(13, TribonnaciNumber.trib(7));
        assertEquals(15902591, TribonnaciNumber.trib(30));
    }
}