import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;

public class SummingSquaresTest {
    private SummingSquares solver = new SummingSquares();

    @Test
    public void testBasicCases() {
        // Base case
        assertEquals(0, solver.summingSquares(0));
        assertEquals(1, solver.summingSquares(1));  // 1²
        assertEquals(2, solver.summingSquares(2));  // 1² + 1²
        assertEquals(3, solver.summingSquares(3));  // 1² + 1² + 1²
        assertEquals(1, solver.summingSquares(4));  // 2²
        assertEquals(2, solver.summingSquares(5));  // 2² + 1²
    }

    @Test
    public void testMediumNumbers() {
        assertEquals(2, solver.summingSquares(8));   // 2² + 2²
        assertEquals(1, solver.summingSquares(9));   // 3²
        assertEquals(2, solver.summingSquares(10));  // 3² + 1²
        assertEquals(3, solver.summingSquares(11));  // 3² + 1² + 1²
        assertEquals(3, solver.summingSquares(12));  // 2² + 2² + 2²
    }

    @Test
    public void testLargerNumbers() {
        assertEquals(1, solver.summingSquares(16));  // 4²
        assertEquals(2, solver.summingSquares(17));  // 4² + 1²
        assertEquals(2, solver.summingSquares(18));  // 3² + 3²
        assertEquals(3, solver.summingSquares(19));  // 3² + 3² + 1²
        assertEquals(1, solver.summingSquares(25));  // 5²
    }

    @Test
    public void testOptimalSolutions() {
        // Cases where taking larger squares isn't always optimal
        assertEquals(3, solver.summingSquares(6));   // 2² + 1² + 1² (not 2² + 2²)
        assertEquals(4, solver.summingSquares(7));   // 2² + 1² + 1² + 1² (not 2² + 2² + 1²)
        assertEquals(4, solver.summingSquares(15));  // 3² + 2² + 1² + 1² (not 3² + 3²)
    }

    @Test
    public void testPerformanceWithLargeInput() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            // Test with numbers that would require exploring many combinations
            assertEquals(4, solver.summingSquares(999));    // 31² + 8² + 4² + 2²
            assertEquals(2, solver.summingSquares(1234));   // 35² + 2²

            // Numbers that could trick greedy approaches
            assertEquals(2, solver.summingSquares(98));     // 7² + 7²
            assertEquals(3, solver.summingSquares(297));    // 17² + 4² + 2²
        });
    }
}