package com.wpf.data.medium;

import com.wpf.data.common.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenpengfei on 2018/4/3.
 */
public class AllPathsSource2Target {

    public static List<List<Integer>> allPathsSource2TargetBFS(int[][] graph) {
        return null;
    }

    public static List<List<Integer>> allPathsSource2TargetDFS(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();

        List<Integer> path = new ArrayList<>();
        dfs(graph, 0, graph.length - 1, path, paths);

        return paths;
    }

    private static void dfs(int[][] graph, int start, int end, List<Integer> path, List<List<Integer>> paths) {
        if (start == end) {
            List<Integer> duplicate = new ArrayList<>();
            for (int i = 0; i < path.size(); ++i) {
                duplicate.add(path.get(i));
            }
            duplicate.add(end);
            paths.add(duplicate);
            return;
        }

        path.add(start);

        for (int i = 0; i < graph[start].length; ++i) {
            dfs(graph, graph[start][i], end, path, paths);
        }

        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        int[][] graph = new int[4][];

        graph[0] = new int[]{1, 2, 3};
        graph[1] = new int[]{3};
        graph[2] = new int[]{3};
        graph[3] = new int[]{};

        List<List<Integer>> paths = allPathsSource2TargetDFS(graph);

        for (List<Integer> path : paths) {
            PrintUtils.printList(path);
        }
    }
}
