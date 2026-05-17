package org.boris;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode51NQueens {
    private final List<List<String>> ans = new ArrayList<>();
    private int n;
    private boolean[] cols;
    private boolean[] diags;
    private boolean[] antiDiags;
    private char[][] board;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.cols = new boolean[n];
        this.diags = new boolean[2 * n - 1];
        this.antiDiags = new boolean[2 * n - 1];
        this.board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtrack(0);

        return ans;
    }

    private void backtrack(int row) {
        if (row == n) {
            ans.add(constructBoard());
            return;
        }

        for (int col = 0; col < n; col++) {
            int diagIdx = row + col;
            int antiDiagIdx = n - 1 - row + col;

            if (cols[col] || diags[diagIdx] || antiDiags[antiDiagIdx]) {
                continue;
            }

            board[row][col] = 'Q';
            cols[col] = true;
            diags[diagIdx] = true;
            antiDiags[antiDiagIdx] = true;

            backtrack(row + 1);

            board[row][col] = '.';
            cols[col] = false;
            diags[diagIdx] = false;
            antiDiags[antiDiagIdx] = false;
        }
    }

    private List<String> constructBoard() {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            result.add(new String(board[i]));
        }

        return result;
    }
}
