/**
 * 
 */
package graphs.bfsdfs;

import java.util.ArrayList;

/**
 * Problem Description

Given an directed graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].

Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.

NOTE:

The cycle must contain atleast two nodes.
There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.


Problem Constraints
2 <= A <= 105

1 <= M <= min(200000,A(A-1))

1 <= B[i][0], B[i][1] <= A



Input Format
The first argument given is an integer A representing the number of nodes in the graph.

The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].



Output Format
Return 1 if cycle is present else return 0.



Example Input
Input 1:

 A = 5
 B = [  [1, 2] 
        [4, 1] 
        [2, 4] 
        [3, 4] 
        [5, 2] 
        [1, 3] ]
Input 2:

 A = 5
 B = [  [1, 2]
        [2, 3] 
        [3, 4] 
        [4, 5] ]


Example Output
Output 1: 1
Output 2: 0


Example Explanation*
Explanation 1:  The given graph contain cycle 1 -> 3 -> 4 -> 1 or the cycle 1 -> 2 -> 4 -> 1
Explanation 2:  The given graph doesn't contain any cycle.
 */
public class CycleInDirectedGraph {

	static ArrayList<ArrayList<Integer>> graph;

	public static int solve(int A, int[][] B) {
		graph = new ArrayList<>();

		for (int i = 0; i < A; i++)
			graph.add(new ArrayList<>());

		for (int[] edge : B) {
			graph.get(edge[0] - 1).add(edge[1] - 1);
		}
		int[] visited = new int[A];
		for (int i = 0; i < A; i++) {
			if (visited[i] == 0) {
				if (dfs(i, visited))
					return 1;
			}
		}
		return 0;
	}

	private static boolean dfs(int cur, int[] visited) {
		visited[cur] = 1;
		for (int nbr : graph.get(cur)) {
			if (visited[nbr] == 0) { // not visited
				if (dfs(nbr, visited))
					return true;
			} else if (visited[nbr] == 1) { // visited
				return true;
			}
		}
		visited[cur] = 2;
		return false;
	}

	public static void main(String[] args) {
		int A = 5;
		int[][] B = {{1, 2},{4, 1},{2, 4},{3, 4},{5, 2},{1, 3}};
        System.out.println("Cycle exists in a graph :: "+ solve(A,B));
	}

}
