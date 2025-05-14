import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FibonnaciNumberTest {
    @Test
    public void testFib() {
        FibonnaciNumber fib = new FibonnaciNumber();
        assertEquals(0, fib.fib(0));
        assertEquals(1, fib.fib(1));
        assertEquals(1, fib.fib(2));
        assertEquals(2, fib.fib(3));
        assertEquals(3, fib.fib(4));
        assertEquals(5, fib.fib(5));
    }
}