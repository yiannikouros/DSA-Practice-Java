import java.util.HashMap;
import java.util.List;

public class SumPossible {
    public static boolean sumPossible(int amount, List<Integer> numbers) {
        return sumPossible(amount, numbers, new HashMap<>());
    }
    public static boolean sumPossible(int amount, List<Integer> numbers, HashMap<Integer, Boolean> memo) {
        if (amount == 0) {
            return true;
        }

        if (amount < 0) {
            return false;
        }

        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }

        for (int number : numbers) {
            int remainder = amount - number;
            if (sumPossible(remainder, numbers, memo)) {
                memo.put(amount, true);
                return true;
            }
        }

        memo.put(amount, false);
        return false;
    }
}
