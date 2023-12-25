/**
 * 
 */
package Trees;

/**
 * @author Pritish
 *
 */
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode (int x){
		val = x;
		left = null;
		right = null;
	}
}

public class LCAInBinaryTree {
	static TreeNode root;

	public static TreeNode findLCA(int n1, int n2) {
		return findLCA(root, n1, n2);
	}

	public static TreeNode findLCA(TreeNode root, int p, int q) {
		if (root == null)
			return null;
		if (root.val == p || root.val == q)
			return root;
		TreeNode left = findLCA(root.left, p, q);
		TreeNode right = findLCA(root.right, p, q);
		if (left != null && right != null)
			return root;
		return left != null ? left : right;

	}

	public static void main(String[] args) {
		LCAInBinaryTree tree = new LCAInBinaryTree();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.right.left = new TreeNode(6);
		tree.root.right.right = new TreeNode(7);
		System.out.println("LCA(4, 5) = " + tree.findLCA(4, 5).val);
		System.out.println("LCA(4, 6) = " + tree.findLCA(4, 6).val);
		root = new TreeNode(1);

	}

}
