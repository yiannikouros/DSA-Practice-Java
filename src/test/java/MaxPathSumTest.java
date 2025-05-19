import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxPathSumTest {
    @Test
    public void testMaxPathSum() {
        // Basic 2x2 grid
        List<List<Integer>> grid1 = Arrays.asList(
                Arrays.asList(1, 3),
                Arrays.asList(2, 4)
        );
        assertEquals(8, new MaxPathSum().maxPathSum(grid1)); // Path: 1 -> 3 -> 4

        // 3x3 grid
        List<List<Integer>> grid2 = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );
        assertEquals(29, new MaxPathSum().maxPathSum(grid2)); // Path: 1 -> 4 -> 7 -> 8 -> 9

        // Grid with negative numbers
        List<List<Integer>> grid3 = Arrays.asList(
                Arrays.asList(-1, -2, -3),
                Arrays.asList(-4, 5, -6),
                Arrays.asList(-7, -8, 10)
        );
        assertEquals(6, new MaxPathSum().maxPathSum(grid3)); // Path: -1 -> -2 -> 5 -> -6 -> 10

        // 1x1 grid
        List<List<Integer>> grid4 = List.of(
                List.of(5)
        );
        assertEquals(5, new MaxPathSum().maxPathSum(grid4));

        // Grid with large numbers
        List<List<Integer>> grid5 = Arrays.asList(
                Arrays.asList(100, 0, 0),
                Arrays.asList(1000, 0, 0),
                Arrays.asList(10000, 50000, 100000)
        );
        assertEquals(161100, new MaxPathSum().maxPathSum(grid5)); // Path: 100 -> 1000 -> 10000 -> 50000 -> 100000

        // Non-square grid
        List<List<Integer>> grid6 = Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(5, 6, 7, 8),
                Arrays.asList(9, 10, 11, 12)
        );
        assertEquals(48, new MaxPathSum().maxPathSum(grid6)); // Path: 1 -> 5 -> 9 -> 10 -> 11 -> 12
    }

    // Add these test cases to MaxPathSumTest.java
    @Test
    public void testNegativePaths() {
        // All negative numbers
        List<List<Integer>> allNegative = Arrays.asList(
                Arrays.asList(-5, -4, -2),
                Arrays.asList(-10, -3, -6),
                Arrays.asList(-8, -9, -1)
        );
        assertEquals(-18, new MaxPathSum().maxPathSum(allNegative)); // Path: -5 -> -4 -> -2 -> -6 -> -1

        // Negative path with positive destination
        List<List<Integer>> negativePathPositiveEnd = Arrays.asList(
                Arrays.asList(-2, -3, -4),
                Arrays.asList(-8, -5, -2),
                Arrays.asList(-3, -2, 10)
        );
        assertEquals(-1, new MaxPathSum().maxPathSum(negativePathPositiveEnd)); // Path: -2 -> -3 -> -4 -> -2 -> 10

        // Mixed positive/negative with optimal negative path
        List<List<Integer>> mixedWithNegativeOptimal = Arrays.asList(
                Arrays.asList(-1, -100, 3),
                Arrays.asList(-4, -5, -1),
                Arrays.asList(-3, -2, -2)
        );
        assertEquals(-12, new MaxPathSum().maxPathSum(mixedWithNegativeOptimal)); // Path: -1 -> -4 -> -3 -> -2 -> -2

        // Single row negative
        List<List<Integer>> singleRowNegative = List.of(
                Arrays.asList(-1, -2, -3)
        );
        assertEquals(-6, new MaxPathSum().maxPathSum(singleRowNegative)); // Path: -1 -> -2 -> -3

        // Single column negative
        List<List<Integer>> singleColumnNegative = Arrays.asList(
                List.of(-1),
                List.of(-2),
                List.of(-3)
        );
        assertEquals(-6, new MaxPathSum().maxPathSum(singleColumnNegative)); // Path: -1 -> -2 -> -3
    }

    @Test
    public void testPerformanceWithLargeGrid() {
        // Create a 15x15 grid with numbers that force exploration of many paths
        List<List<Integer>> largeGrid = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < 15; j++) {
                // Create a pattern where multiple paths look promising
                // but only one is optimal
                row.add(1000 - Math.abs(i - j) * 10);
            }
            largeGrid.add(row);
        }

        assertTimeoutPreemptively(Duration.ofMillis(10), () -> {
            new MaxPathSum().maxPathSum(largeGrid);
        });
    }
}