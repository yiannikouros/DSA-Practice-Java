import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinChangeTest {
    @Test
    public void testMinChange() {
        // Basic cases with exact matches
        assertEquals(1, MinChange.minChange(4, List.of(4)));
        assertEquals(2, MinChange.minChange(8, List.of(4)));
        assertEquals(3, MinChange.minChange(9, List.of(3)));

        // Cases with multiple coin combinations
        assertEquals(2, MinChange.minChange(7, Arrays.asList(3, 4)));
        assertEquals(1, MinChange.minChange(5, Arrays.asList(1, 2, 5)));
        assertEquals(2, MinChange.minChange(6, Arrays.asList(1, 3, 4)));

        // Edge cases
        assertEquals(0, MinChange.minChange(0, Arrays.asList(1, 2, 3)));
        assertEquals(-1, MinChange.minChange(7, Collections.emptyList()));
        assertEquals(-1, MinChange.minChange(-5, Arrays.asList(1, 2, 3)));

        // Larger amounts with efficient solutions
        assertEquals(4, MinChange.minChange(100, List.of(25)));
        assertEquals(2, MinChange.minChange(15, Arrays.asList(5, 10)));

        // Cases with no solution
        assertEquals(-1, MinChange.minChange(7, Arrays.asList(4, 6, 8)));
        assertEquals(-1, MinChange.minChange(3, Arrays.asList(2, 4, 6)));
    }

    @Test
    public void testPerformanceWithLargeInput() {
        assertTimeoutPreemptively(Duration.ofMillis(2000), () -> {
            MinChange.minChange(500, Arrays.asList(1, 5, 10, 25));
        });
    }
}