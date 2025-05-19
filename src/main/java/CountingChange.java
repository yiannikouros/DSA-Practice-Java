import java.util.HashMap;
import java.util.List;

public class CountingChange {
    public int countingChange(int amount, List<Integer> coins) {
        return countingChange(amount, 0, coins, new HashMap<>());
    }
    public int countingChange(int amount, int coinIdx, List<Integer> coins, HashMap<List<Integer>, Integer> memo) {
        if (amount == 0) {
            return 1;
        }

        if (coinIdx >= coins.size()) {
            return 0;
        }

        List<Integer> key = List.of(amount, coinIdx);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int totalWays = 0;
        int value = coins.get(coinIdx);
        for (int qty = 0; qty * value <= amount; qty++) {
            int subAmount = amount - (qty * value);
            totalWays += countingChange(subAmount, coinIdx++, coins, memo);
        }

        memo.put(key, totalWays);
        return totalWays;
    }
}
