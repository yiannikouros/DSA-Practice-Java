import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FibonnaciNumberTest {
    @Test
    public void findMaxSafeNumber() {
        int n = 0;
        try {
            // Start testing numbers until we either get a StackOverflowError
            // or reach a point where integer overflow would occur
            while (n < 10000) {  // reasonable upper limit for testing
                int result = FibonnaciNumber.fib(n);
                if (result < 0) {  // Check for integer overflow
                    break;
                }
                System.out.println("Successfully calculated fib(" + n + ") = " + result);
                n++;
            }
        } catch (StackOverflowError e) {
            System.out.println("Stack overflow occurred at n = " + n);
        }
        System.out.println("Last successful calculation was at n = " + (n-1));
    }

    @Test
    public void testFibBaseCases() {
        // Keep the original test cases for small numbers
        assertEquals(0, FibonnaciNumber.fib(0));
        assertEquals(1, FibonnaciNumber.fib(1));
        assertEquals(1, FibonnaciNumber.fib(2));
        assertEquals(2, FibonnaciNumber.fib(3));
        assertEquals(3, FibonnaciNumber.fib(4));
        assertEquals(1836311903, FibonnaciNumber.fib(46));
    }
}