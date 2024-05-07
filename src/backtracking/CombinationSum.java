/**
 * 
 */
package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of candidate numbers A and a target number B, find all unique combinations in A where the candidate numbers sums to B.
 The same repeated number may be chosen from A unlimited number of times.
 *
 */
public class CombinationSum {

	public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> arr, int sum) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<>();

		// first do hashing since hashset does not always sort.
		// removing the duplicates using HashSet and Sorting the arrayList

		Set<Integer> set = new HashSet<>(arr);
		arr.clear();
		arr.addAll(set);
		Collections.sort(arr);

		findNumbers(ans, arr, sum, 0, temp);
		return ans;
	}

	static void findNumbers(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> arr, int sum, int index,
			ArrayList<Integer> temp) {

		if (sum == 0) {
			// Adding deep copy of list to ans
			ans.add(new ArrayList<>(temp));
			return;
		}

		for (int i = index; i < arr.size(); i++) {

			// checking that sum does not become negative

			if ((sum - arr.get(i)) >= 0) {

				// adding element which can contribute to  sum

				temp.add(arr.get(i)); // do the change

				findNumbers(ans, arr, sum - arr.get(i), i, temp); // recursive call

				// removing element from list (backtracking)
				temp.remove(arr.get(i)); // backtrack - undo the change
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(2);
		arr.add(4);
		arr.add(6);
		arr.add(8);

		int sum = 8;

		ArrayList<ArrayList<Integer>> ans = combinationSum(arr, sum);

		// If result is empty, then
		if (ans.size() == 0) {
			System.out.println("Empty");
			return;
		}

		// print all combinations stored in ans

		for (int i = 0; i < ans.size(); i++) {

			System.out.print("[");
			for (int j = 0; j < ans.get(i).size(); j++) {
				System.out.print(ans.get(i).get(j) + ", ");
			}
			System.out.print("] ");
		}
	}

}


