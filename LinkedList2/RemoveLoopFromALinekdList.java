/**
 * 
 */
package LinkedList2;

/**
 * @author Pritish
 *
 */
public class RemoveLoopFromALinekdList {
	class Node {
		public int val;
		public Node next;

		Node(int x) {
			val = x;
			next = null;
		}
	}

	static void detectAndRemoveLoop(Node head) {
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				break;// loop is present
		}
		if (slow == null || fast == null || fast.next == null) {
			System.out.println("Loop is not present");
		} else {
			System.out.println("Loop is present");
		}
		// remove the loop
		Node p1 = head; // reset pointer to head
		Node p2 = slow; // initialize pointer to intersection point
		while (p1.next != p2.next) {
			p1 = p1.next;
			p2 = p2.next;
		}
		p2.next = null;// break the loop
		System.out.println("loop has been removed from the list. ");

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
