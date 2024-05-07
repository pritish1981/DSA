/**
 * 
 */
package math.bitmaniulation;

/**
 * Given an array of positive integers, find the total sum after performing the bit wise OR operation on all the sub arrays of a given array.
 *
 */
public class SumOfBitwiseORofSubrray {

	static int totalSum(int A[]) {
		int n = A.length;
        int[] idx = new int[32];
        long ans = 0;
        for (int i = 1; i <= n; ++i) {
            long tmp = A[i - 1];
            for (int j = 0; j <= 31; ++j) {
                long pw = 1 << j;
                if ((tmp & pw) != 0) { //if jth bit is set
                    ans += pw * i; // add its contribution in ans for all subarrays ending at index i
                    idx[j] = i; // store the index for next elements
                } else if (idx[j] != 0) // if jth bit is not set
                {
                    ans += pw * idx[j]; // add its contribution in ans for all subarrays ending at index i using 
                } // the information of last element having jth bit set
            }
        }
        return (int)(ans % 1000000007);
	}
	
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5 };
	    int n = a.length;
	    System.out.println(totalSum(a));
	}

}
