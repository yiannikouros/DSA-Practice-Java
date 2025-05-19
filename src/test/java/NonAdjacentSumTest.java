import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NonAdjacentSumTest {
    private NonAdjacentSum solver = new NonAdjacentSum();

    @Test
    public void testNonAdjacentSum() {
        // Basic cases
        assertEquals(11, solver.nonAdjacentSum(Arrays.asList(2, 4, 5, 3, 4)));  // 2 + 5 + 4
        assertEquals(7, solver.nonAdjacentSum(List.of(7)));
        assertEquals(8, solver.nonAdjacentSum(Arrays.asList(5, 8)));

        // Cases with negative numbers
        assertEquals(0, solver.nonAdjacentSum(Arrays.asList(-1, -2, -3)));  // Better to take no elements
        assertEquals(13, solver.nonAdjacentSum(Arrays.asList(-1, 5, -3, 8, -4)));  // 5 + 8

        // Alternating patterns
        assertEquals(24, solver.nonAdjacentSum(Arrays.asList(8, 1, 8, 1, 8)));  // 8 + 8 + 8
        assertEquals(20, solver.nonAdjacentSum(Arrays.asList(2, 1, 6, 3, 12, 4)));  // 2 + 6 + 12

        // Edge cases
        assertEquals(0, solver.nonAdjacentSum(Collections.emptyList()));
        assertEquals(0, solver.nonAdjacentSum(Arrays.asList(0, 0, 0, 0)));
        assertEquals(2000000000,
                solver.nonAdjacentSum(Arrays.asList(1000000000, 1, 1000000000)));  // 1000000000+ 1000000000

        // Complex patterns
        assertEquals(33, solver.nonAdjacentSum(Arrays.asList(7, 5, 15, 3, 6, 8, 5)));  // 7 + 15 + 6 + 5
        assertEquals(18, solver.nonAdjacentSum(Arrays.asList(6, 3, 6, 3, 6, 3)));  // all 6s
    }

    @Test
    public void testPerformanceWithLargeInput() {
        List<Integer> sequence = new ArrayList<>();
        // Create a sequence with 1000 repetitions of [5, 3, 5, 3, 5, 3, 5, 3, 5, 3]
        for (int i = 0; i < 1000; i++) {
            sequence.addAll(Arrays.asList(5, 3, 5, 3, 5, 3, 5, 3, 5, 3));
        }

        assertTimeoutPreemptively(Duration.ofMillis(1000), () -> {
            int expectedSum = sequence.size() / 10 * 25; // Each group of 10 contributes sum of 25 (five 5s)
            assertEquals(expectedSum, solver.nonAdjacentSum(sequence));
        });
    }
}