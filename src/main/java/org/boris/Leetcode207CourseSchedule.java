package org.boris;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode207CourseSchedule {
    enum State {
        UNVISITED,
        VISITING,
        VISITED,
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] item : prerequisites) {
            adj.get(item[1]).add(item[0]);
        }

        State[] state = new State[numCourses];
        Arrays.fill(state, State.UNVISITED);

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == State.UNVISITED) {
                if (hasCycle(i, adj, state)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean hasCycle(int node, List<List<Integer>> adj, State[] state) {
        state[node] = State.VISITING;

        for (int neighbor : adj.get(node)) {
            if (state[neighbor] == State.VISITING) {
                return true;
            }
            if (state[neighbor] == State.UNVISITED) {
                if (hasCycle(neighbor, adj, state)) {
                    return true;
                }
            }
        }

        state[node] = State.VISITED;

        return false;
    }
}
