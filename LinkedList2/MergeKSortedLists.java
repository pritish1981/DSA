/**
 * 
 */
package LinkedList2;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
   Merge all the linked-lists into one sorted linked-list and return it.
 *
 */
public class MergeKSortedLists {

	static class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public static ListNode mergeKLists(ListNode[] lists) {
		//base condition
		if(lists == null || lists.length == 0) {
			return null;
		}
		return mergeKLists(lists, 0, lists.length-1);
	}
	
	public static ListNode mergeKLists(ListNode[] lists, int start, int end) {
		if(start == end) {
			return lists[start];
		}
		int mid = start + (end-start)/2;
		ListNode left = mergeKLists(lists, start, mid);
		ListNode right = mergeKLists(lists, mid+1, end);
		//merge left & right sub-lists
		return merge(left, right);
	}
	
	public static ListNode merge(ListNode left, ListNode right) {
		ListNode temp_node = new ListNode(0);
		ListNode cur_node = temp_node;
		while(left != null && right !=null) {
			if(left.val < right.val) {
				cur_node.next = left;
				left = left.next;
			}else {
				cur_node.next = right;
				right = right.next;
			}
			cur_node = cur_node.next;
		}
		if(left != null) {
			cur_node.next = left;
			left = left.next;
		}
		if(right != null) {
			cur_node.next = right;
			right = right.next;
		}
		return temp_node.next;
	}
	
	//Time complexity: O(N * log k)
	//Space complexity: O(1)
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
