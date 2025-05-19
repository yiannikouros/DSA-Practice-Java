import java.util.HashMap;
import java.util.List;

public class MaxPathSum {
    public int maxPathSum(List<List<Integer>> grid) {
        return maxPathSum(0, 0, grid, new HashMap<>());
    }

    public int maxPathSum(int r, int c, List<List<Integer>> grid, HashMap<List<Integer>, Integer> memo) {
        if (r == grid.size() || c == grid.get(0).size()) {
            return Integer.MIN_VALUE;
        }

        if (r == grid.size() - 1 && c == grid.get(0).size() - 1) {
            return grid.get(r).get(c);
        }

        List<Integer> pos = List.of(r, c);
        if (memo.containsKey(pos)) {
            return memo.get(pos);
        }

        int result = grid.get(r).get(c) + Math.max(
                maxPathSum(r + 1, c, grid, memo),
                maxPathSum(r, c + 1, grid, memo)
        );
        memo.put(pos, result);
        return result;
    }
}
