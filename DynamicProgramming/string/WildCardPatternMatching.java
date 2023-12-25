/**
 * 
 */
package DynamicProgramming.string;

/**
 * Problem Description
Implement wildcard pattern matching with support for ' ? ' and ' * ' for strings A and B.

' ? ' : Matches any single character.
' * ' : Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Problem Constraints
1 <= length(A), length(B) <= 104

Input Format
The first argument of input contains a string A.
The second argument of input contains a string B.

Output Format
Return 1 if the patterns match else return 0.

Example Input
Input 1:

 A = "aaa"
 B = "a*"
Input 2:

 A = "acz"
 B = "a?a"


Example Output
Output 1: 1
Output 2: 0


Example Explanation
Explanation 1:

 Since '*' matches any sequence of characters. Last two 'a' in string A will be match by '*'.
 So, the pattern matches we return 1.
Explanation 2:

 '?' matches any single character. First two character in string A will be match. 
 But the last character i.e 'z' != 'a'. Return 0.

 *
 */
public class WildCardPatternMatching {
	
	//bottom-up approach:

	public static int isMatch(final String A, final String B) {
		if (helper(A, B) == true)
			return 1;
		else {
			return 0;
		}
	}
	
	public static boolean helper(String s, String p) {
		if (s == null || p == null)
			return false;

		int N = s.length(), M = p.length();
		boolean[][] dp = new boolean[N + 1][M + 1];
		// dp[0][0] = true since Empty string matches empty pattern
		dp[0][0] = true;
		// 2.dp[0][i] = false, since empty pattern can-not match non-empty string
		// 3.dp[j][0] for any * will match empty string
		for (int j = 1; j <= M; j++) {
			if (p.charAt(j - 1) == '*') {
				dp[j][0] = dp[j - 1][0];
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
					dp[i][j] = dp[i - 1][j - 1];
				else if (p.charAt(j - 1) == '*')
					dp[i][j] = dp[i - 1][j] || dp[i][j - 1];

			}
		}
		return dp[N][M];
		// Time Complexity: O(N*M), Space Complexity: O(N*M)
	}
		
	

	public static void main(String[] args) {
		String s = "aa", p = "*";
		System.out.println("Bottom-up approch::" + isMatch(s, p));
	}

}
