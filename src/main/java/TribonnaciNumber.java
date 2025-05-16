import java.util.HashMap;

public class TribonnaciNumber {
    public static int trib(int n) {
        return trib(n, new HashMap<>());
    }

    public static int trib(int n, HashMap<Integer, Integer> memo) {
        if (n == 0 || n == 1) {
            return 0;
        }

        if (n == 2) {
            return 1;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int result = trib(n - 3, memo) + trib(n - 2, memo) + trib(n - 1, memo);
        memo.put(n, result);
        return memo.get(n);
    }
}
