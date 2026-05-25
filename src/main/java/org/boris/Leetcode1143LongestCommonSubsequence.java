package org.boris;

public class Leetcode1143LongestCommonSubsequence {
    private String text1;
    private String text2;
    private Integer[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;
        int m = text1.length();
        int n = text2.length();
        memo = new Integer[m][n];

        return dfs(m - 1, n - 1);
    }

    private int dfs(int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            memo[i][j] = dfs(i - 1, j - 1) + 1;
        } else {
            memo[i][j] = Math.max(dfs(i, j - 1), dfs(i - 1, i));
        }
        return memo[i][j];
    }
}
