/**
 * 
 */
package MergeSort;

import java.util.ArrayList;

/**
 * Given an array arr[]. The task is to find the inversion count of arr[]. 
 * Where two elements arr[i] and arr[j] form an inversion if a[i] > a[j] and i < j.
 *
 */
public class CountInversionPairs {

	public static int merge(int[] arr, int low, int mid, int high) {
		ArrayList<Integer> temp = new ArrayList<>(); 
		int left = low; 
		int right = mid + 1; 
		int cnt = 0;

		// storing elements in the temporary array in a sorted manner//

		while (left <= mid && right <= high) {
			if (arr[left] <= arr[right]) {
				temp.add(arr[left]);
				left++;
			} else {
				temp.add(arr[right]);
				cnt += (mid - left + 1); // Modification 2
				right++;
			}
		}

		// if elements on the left half are still left //

		while (left <= mid) {
			temp.add(arr[left]);
			left++;
		}

		// if elements on the right half are still left //
		while (right <= high) {
			temp.add(arr[right]);
			right++;
		}

		// transfering all elements from temporary to arr //
		
		for (int i = low; i <= high; i++) {
			arr[i] = temp.get(i - low);
		}
		return cnt; // Modification 3
	}
	
	public static int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        if (low >= high) return cnt;
        int mid = (low + high) / 2 ;
        cnt += mergeSort(arr, low, mid);  // left half
        cnt += mergeSort(arr, mid + 1, high); // right half
        cnt += merge(arr, low, mid, high);  // merging sorted halves
        return cnt;
    }
	
	public static int numberOfInversions(int[] a, int n) {
        // Count the number of pairs:
        return mergeSort(a, 0, n - 1);
    }
	
	
	public static void main(String[] args) {
		int[] a = { 5, 4, 3, 2, 1 };
		int n = 5;
		int count = numberOfInversions(a, n);
		System.out.println("The number of inversions are: " + count);

	}

}
