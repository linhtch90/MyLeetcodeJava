package org.boris;

import java.util.Arrays;

public class Leetcode322CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -2);
        return dfs(coins, amount, memo);
    }

    private int dfs(int[] coins, int remaining, int[] memo) {
        if (remaining < 0) {
            return -1;
        }
        if (remaining == 0) {
            return 0;
        }
        if (memo[remaining] != -2) {
            return memo[remaining];
        }

        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int result = dfs(coins, remaining - coin, memo);
            if (result != -1) {
                minCoins = Math.min(minCoins, result + 1);
            }
        }

        memo[remaining] = minCoins == Integer.MAX_VALUE ? -1 : minCoins;
        return memo[remaining];
    }
}
