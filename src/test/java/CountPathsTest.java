import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class CountPathsTest {
    @Test
    public void testCountPaths() {
        // Basic 2x2 grid with all open paths
        List<List<String>> grid1 = Arrays.asList(
                Arrays.asList("O", "O"),
                Arrays.asList("O", "O")
        );
        assertEquals(2, CountPaths.countPaths(grid1));

        // 3x3 grid with all open paths
        List<List<String>> grid2 = Arrays.asList(
                Arrays.asList("O", "O", "O"),
                Arrays.asList("O", "O", "O"),
                Arrays.asList("O", "O", "O")
        );
        assertEquals(6, CountPaths.countPaths(grid2));

        // Grid with blocked paths
        List<List<String>> grid3 = Arrays.asList(
                Arrays.asList("O", "O", "X"),
                Arrays.asList("O", "O", "O"),
                Arrays.asList("O", "O", "O")
        );
        assertEquals(5, CountPaths.countPaths(grid3));

        // Grid with no valid paths
        List<List<String>> grid4 = Arrays.asList(
                Arrays.asList("O", "X", "O"),
                Arrays.asList("X", "O", "O"),
                Arrays.asList("O", "O", "O")
        );
        assertEquals(0, CountPaths.countPaths(grid4));

        // 1x1 grid
        List<List<String>> grid5 = List.of(
                List.of("O")
        );
        assertEquals(1, CountPaths.countPaths(grid5));

        // Starting position blocked
        List<List<String>> grid6 = Arrays.asList(
                Arrays.asList("X", "O", "O"),
                Arrays.asList("O", "O", "O"),
                Arrays.asList("O", "O", "O")
        );
        assertEquals(0, CountPaths.countPaths(grid6));

        // Ending position blocked
        List<List<String>> grid7 = Arrays.asList(
                Arrays.asList("O", "O", "O"),
                Arrays.asList("O", "O", "O"),
                Arrays.asList("O", "O", "X")
        );
        assertEquals(0, CountPaths.countPaths(grid7));

        // Grid with single path
        List<List<String>> grid8 = Arrays.asList(
                Arrays.asList("O", "X", "O"),
                Arrays.asList("O", "O", "X"),
                Arrays.asList("X", "O", "O")
        );
        assertEquals(1, CountPaths.countPaths(grid8));
    }

    @Test
    public void testPerformanceWithLargeGrid() {
        // Create a 15x15 grid with a pattern that forces many overlapping subproblems
        List<List<String>> largeGrid = Arrays.asList(
                Arrays.asList("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
                Arrays.asList("O", "X", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "X", "O"),
                Arrays.asList("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
                Arrays.asList("O", "O", "O", "X", "X", "O", "O", "O", "O", "O", "X", "X", "O", "O", "O"),
                Arrays.asList("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
                Arrays.asList("O", "O", "X", "O", "O", "O", "X", "X", "X", "O", "O", "O", "X", "O", "O"),
                Arrays.asList("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
                Arrays.asList("O", "X", "X", "O", "O", "O", "O", "O", "O", "O", "O", "O", "X", "X", "O"),
                Arrays.asList("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
                Arrays.asList("O", "O", "X", "X", "O", "O", "O", "O", "O", "O", "O", "X", "X", "O", "O"),
                Arrays.asList("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
                Arrays.asList("O", "X", "O", "O", "O", "X", "X", "O", "X", "X", "O", "O", "O", "X", "O"),
                Arrays.asList("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
                Arrays.asList("O", "O", "X", "O", "O", "O", "O", "O", "O", "O", "O", "O", "X", "O", "O"),
                Arrays.asList("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O")
        );

        assertTimeoutPreemptively(Duration.ofMillis(10), () -> {
            CountPaths.countPaths(largeGrid);
        });
    }
}