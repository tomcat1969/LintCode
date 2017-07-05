法一:      
Recursive: Divide and Conquer, with helper(dfs) method

法二:   
Stack: 
Add left nodes all the way   
Print curr   
Move to right, add right if possible.   
  
注意stack.pop()在加完left-most child 的后，一定要curr = curr.right.

若不右移，很可能发生窘境：    
curr下一轮还是去找自己的left-most child，不断重复curr and curr.left, 会infinite loop, 永远在左边上下上下。

/*
Given a binary tree, return the inorder traversal of its nodes' values.

Example
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3
 

return [1,3,2].

Challenge
Can you do it without recursion?

Tags Expand 
Recursion Binary Tree Binary Tree Traversal

*/

/*
    Recursive
*/
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if (root == null) {
            return rst;
        }
        helper(rst, root);
        
        return rst;
    }

    private void helper(ArrayList<Integer> rst, TreeNode node) {
        if (node != null) {
	        	helper(rst, node.left);
	        	rst.add(node.val);
	        	helper(rst, node.right);
        }
 
    }
}

/*
    2. Non-recursive
   
*/

/*

 Inorder traversal: use 1 stack, push left till end; pirnt/store curr; push right to stack

    Note: after curr = curr.right, curr could be null; this will skip the while loop, and move on to next element.

    Trick: in Inorder, we care the right node least. So we keep going with left and curr; 
    only when there is a right node, we add it;
    even after this, we go deep into that right node's left children all the way down.
    
This method just like : "Binary Search Tree Iterator.java"
The code that how to Traversa the tree is very worth to learn. How smart way!!!

*/

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
         ArrayList<Integer> rst = new ArrayList<Integer>();
        if (root == null) {
            return rst;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            rst.add(curr.val);
            curr = curr.right;   
        }   
        return rst;
    } 
}
