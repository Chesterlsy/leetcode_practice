package com.chester.leetcode_practice.datastructures.graph;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Author: Chester
 * Date: 05/07/2019
 * TIME: 23:41
 * Description:
 */
public class Graph {

    private int vertices;
    private LinkedList<Integer>[] adj;

    public Graph(int vertices) {
        this.vertices = vertices;
        adj = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public void breadthFirstSearch(int v) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[v] = true;
        queue.offer(v);

        while (!queue.isEmpty()) {
            int s = queue.poll();
            System.out.println(s + " ");
            for (int i = 0; i < adj[s].size(); i++) {
                int n = adj[s].get(i);
                if (!visited[n]) {
                    visited[n] = true;
                    queue.offer(n);
                }
            }
        }
    }

    public void depthFirstSearch(int v) {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();

        stack.push(v);

        while (!stack.empty()) {
            int s = stack.pop();

            if (!visited[s]) {
                System.out.println(s + " ");
                visited[s] = true;
            }

            for (int i = 0; i < adj[s].size(); i++) {
                int n = adj[s].get(i);
                if (!visited[n]) {
                    stack.push(n);
                }
            }
        }
    }

}
