/**
 * 
 */
package Trees;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pritish
 *
 */
public class FindKthSmallestInBST {
	static List<Integer> list = new ArrayList<>();

	public static int kthSmallest(TreeNode root, int k) {
		if (root == null)
			return 0;
		help(root, k);
		return list.get(k - 1);

	}

	public static void help(TreeNode root, int k) {
		if (root == null) {
			return;
		}
		help(root.left, k);
		list.add(root.val);
		if (list.size() == k) {
			return;
		}
		help(root.right, k);
	}
	
	// A utility function to create a new BST node
	static TreeNode newNode(int item)
	{
		TreeNode temp = new TreeNode(item);
	    temp.val = item;
	    temp.left = null;
	    temp.right = null;
	    return temp;
	}
	
	/* A utility function to insert a new node with given key in BST */
	static TreeNode insert(TreeNode node, int key)
	{
	    /* If the tree is empty, return a new node */
	    if (node == null) return newNode(key);
	 
	    /* Otherwise, recur down the tree */
	    if (key < node.val)
	        node.left = insert(node.left, key);
	    else if (key > node.val)
	        node.right = insert(node.right, key);
	 
	    /* return the (unchanged) node pointer */
	    return node;
	}

	public static void main(String[] args) {
		TreeNode root = null;
	    root = insert(root, 50);
	    insert(root, 30);
	    insert(root, 20);
	    insert(root, 40);
	    insert(root, 70);
	    insert(root, 60);
	    insert(root, 80);
	 
	    for (int k=1; k<=7; k++)
	    System.out.print(kthSmallest(root, k) + " ");

	}

}
