/**
 * 
 */
package Trees;

import java.util.ArrayList;

/**
 * @author Pritish
 *
 */
public class MorrisInorderTraversal {

	public static ArrayList<Integer> morrisTraversal(TreeNode root){
		ArrayList<Integer> ans = new ArrayList<Integer>();
		TreeNode curr = root;
		while(curr != null) {
			if(curr.left == null) {
				ans.add(curr.val);
				curr = curr.right;
			}else {
				TreeNode temp = curr.left;
				while(temp.right != null && temp.right != curr) {
					temp = temp.right;
				}
				if(temp.right == null) {
					temp.right = curr;
					curr = curr.left;
				}else if(temp.right == curr) {
					temp.right = null;
					ans.add(curr.val);
					curr = curr.right;
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
