/**
 * 
 */
package Trees;

/**
 * @author Pritish
 *
 */
public class InsertIntoBST {
	static TreeNode root;
	public static TreeNode insert(TreeNode root, int k) {
		
		if(root == null) return new TreeNode(k);
		TreeNode temp = root, parent = null;
		while(temp != null) {
			parent = temp;
			if(k > temp.val) {
				temp = temp.right;
				continue;
			}
			if(k < temp.val) {
				temp = temp.left;
				continue;
			}
		}
		if(k > parent.val) {
			parent.right =new TreeNode(k);
		}else if(k <= parent.val) {
			parent.left = new TreeNode(k);
		}
		return root;
	}
	
	//recursive approach
	static TreeNode insertIntoBST(TreeNode root, int key) {
		if (root == null) {
			return new TreeNode(key);
		}
		if (key < root.val) {
			return insertIntoBST(root.left, key);
		}
		return insertIntoBST(root.right, key);

	}
	
	
	public static void main(String[] args) {
		root = new TreeNode(8);
		root.left = new TreeNode(4);
		root.right = new TreeNode(13);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(15);
		root.left.right.left = new TreeNode(6);
		root.right.right.right = new TreeNode(17);
		insert(root, 14);
		System.out.println(insert(root, 14));

	}

}
