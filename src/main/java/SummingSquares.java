import java.util.HashMap;
import java.util.List;

public class SummingSquares {
    public int summingSquares(int n) {
        return summingSquares(n, new HashMap<>());
    }
    public int summingSquares(int n, HashMap<Integer, Integer> memo) {
        if (n == 0) {
            return 0;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int minSquares = Integer.MAX_VALUE;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            int square = i * i;
            int numSquares = 1 + summingSquares(n - square, memo);
            if (numSquares < minSquares) {
                minSquares = numSquares;
            }
        }

        memo.put(n, minSquares);
        return minSquares;
    }
}
