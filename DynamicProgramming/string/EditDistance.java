/**
 * 
 */
package DynamicProgramming.string;

import java.util.Arrays;

/**
 *Problem Description
Given two strings A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character

Problem Constraints
1 <= length(A), length(B) <= 450

Input Format
The first argument of input contains a string, A.
The second argument of input contains a string, B.

Output Format
Return an integer, representing the minimum number of steps required.

Example Input
Input 1:

 A = "abad"
 B = "abac"
Input 2:

 A = "Anshuman"
 B = "Antihuman

Example Output
Output 1: 1
Output 2: 2


Example Explanation
Exlanation 1:

 A = "abad" and B = "abac"
 After applying operation: Replace d with c. We get A = B.
 
Explanation 2:

 A = "Anshuman" and B = "Antihuman"
 After applying operations: Replace s with t and insert i before h. We get A = B.
 *
 */
public class EditDistance {

	//Solution 1: Bottom-up approach
	public static int minDistance(String word1, String word2) {
		int n = word1.length();
		int m = word2.length();
		int[][] dp = new int[n + 1][m + 1];
		// intialize the array
		for (int i = 0; i <= n; i++)
			dp[i][0] = i;
		for (int j = 0; j <= m; j++)											
			dp[0][j] = j;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];
				else {
					int min = Math.min(dp[i][j - 1], dp[i - 1][j]);
					dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], min);
				}
			}
		}
		return dp[n][m];
		//T.C: O(N*M), S.C: O(N*M)
	}

	public static void main(String[] args) {
		String A = "abad", B = "abac";
		System.out.println("Minimum number of steps required to convert A to B :: " + minDistance(A, B));
		
	}

}
