import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SumPossibleTest {
    @Test
    public void testSumPossible() {
        // Basic cases
        assertTrue(SumPossible.sumPossible(8, Arrays.asList(5, 3)));
        assertTrue(SumPossible.sumPossible(15, Arrays.asList(6, 3, 9)));
        assertFalse(SumPossible.sumPossible(7, Arrays.asList(4, 8)));

        // Zero amount cases
        assertTrue(SumPossible.sumPossible(0, Arrays.asList(1, 2, 3)));
        assertTrue(SumPossible.sumPossible(0, Collections.emptyList()));

        // Negative amount case
        assertFalse(SumPossible.sumPossible(-5, Arrays.asList(1, 2, 3)));

        // Empty list case
        assertFalse(SumPossible.sumPossible(5, Collections.emptyList()));

        // Large number cases
        assertTrue(SumPossible.sumPossible(100, Arrays.asList(25, 25, 25, 25)));
        assertTrue(SumPossible.sumPossible(999, Arrays.asList(1, 2, 3)));
        assertTrue(SumPossible.sumPossible(500, Arrays.asList(2, 4, 6, 8, 10)));
        assertFalse(SumPossible.sumPossible(999, Arrays.asList(4, 6, 8)));

        // Repeated use cases
        assertTrue(SumPossible.sumPossible(8, List.of(2)));  // 2+2+2+2
        assertTrue(SumPossible.sumPossible(9, List.of(3)));  // 3+3+3

        // Complex cases
        assertTrue(SumPossible.sumPossible(12, Arrays.asList(1, 2, 3, 4, 5)));
        assertFalse(SumPossible.sumPossible(11, Arrays.asList(6, 8, 4)));
        assertTrue(SumPossible.sumPossible(20, Arrays.asList(5, 10, 15)));

        // Single number cases
        assertTrue(SumPossible.sumPossible(4, List.of(4)));
        assertFalse(SumPossible.sumPossible(7, List.of(4)));
    }

    @Test
    public void testPerformanceWithLargeInput() {
        assertTimeoutPreemptively(Duration.ofMillis(1000), () -> {
            assertTrue(SumPossible.sumPossible(500, Arrays.asList(2, 4, 6, 8, 10)));
            assertFalse(SumPossible.sumPossible(999, Arrays.asList(4, 6, 8)));
        });
    }
}
