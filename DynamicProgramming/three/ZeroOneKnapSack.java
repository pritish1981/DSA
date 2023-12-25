/**
 * 
 */
package DynamicProgramming.three;

/** Given N toys with their happiness and weight. Find maximum total happiness that can be kept in a bag with capacity W.
 *  Note: toys can't be divided.
 *
 */
public class ZeroOneKnapSack {

	// Returns the maximum value that can be put in a knapsack of capacity W
	static int knapSack(int W, int wt[], int val[], int N) {
		int i, j;
		int dp[][] = new int[N + 1][W + 1];

		// Build table dp[][] in bottom up manner 

		for (i = 1; i <= N; i++) {
			for (j = 1; j <= W; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
				else if (wt[i - 1] <= j)
					dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
				else
					dp[i][j] = dp[i - 1][j];
			}
		}

		return dp[N][W];
	}

	// Driver code
	public static void main(String args[]) {
		int profit[] = new int[] { 60, 100, 120 };
		int weight[] = new int[] { 10, 20, 30 };
		int W = 50;
		int n = profit.length;
		System.out.println(knapSack(W, weight, profit, n));
	}

}
