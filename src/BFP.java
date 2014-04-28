/*
THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING 
CODE WRITTEN BY OTHER STUDENTS. Milap Naik & Sushmitha Radhakrishnan
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

public class BFP {
 private boolean[] marked;
 private int[] edgeTo; 
 private final int s;
 
 public BFP(HashSC g, String user) {
        marked = new boolean[1019];
        this.s = g.hash(user);
        edgeTo = new int[1019];
        bfs(g, user);
    }
 
 private void bfs(HashSC g, String s) {

        ArrayDeque<Integer> q= new ArrayDeque<Integer>();
        marked[g.hash(s)] = true;
        q.addLast(g.hash(s));
        String curr = s; 
         while (!q.isEmpty()) {
             int v = q.removeFirst();
             userProfile x = g.get(curr); 
             ArrayList<String> edges = x.friends; 
             for (int w = 0; w<edges.size();w++) {
              curr = edges.get(w);
              int i = g.hash(curr);
                 if (!marked[i]) {
                     edgeTo[i] = v;
                     marked[i] = true; 
                     q.addLast(i);
                 }
             }
         }
    }
 
  // is there a path between s (or sources) and v?
 public boolean hasPathTo(int v) {
        return marked[v];
    }
 
    // shortest path between s (or sources) and v; null if no such path
    public Stack<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        int x;
         for (x = v; x != s; x = edgeTo[x])
          path.push(x);
         path.push(x);
        return path;
    }
}