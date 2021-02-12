/**
 * Code and Comments by Eashver Elango, Daniel Gao, and Daniel Hu. 
 */

import java.util.*;

public class CousinsInBinaryTrees {
    /**
     * Essentially, this function utilizes BFS or Breadth First Search by traversing the 
     * tree horizontally. To make sure, we only do one horizontal pass through, we use a 
     * for loop to keep track. Each horizontal pass through we check whether x and y both exist
     * in the same layer. We also check whether x and y have a singular parent. 
     * 
     * Time Complexity: O(V+E)
     * Space Complexity: O(N)
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        // Since this is iterative BFS, we use a queue (aka LinkedList in Java)
        Queue<TreeNode> ll = new LinkedList<TreeNode>();
        // We add the root as the first node in LL
        ll.offer(root);
        while(!ll.isEmpty()){ // We iterate until all nodes are traveled over
            int size = ll.size(); // variable for horizontal traversal
            boolean xExists = false; // Notes down whether x is found
            boolean yExists = false; // Notes down whether y is found

            // This makes sure we traverse horizontally one at a time
            for(int i=0;i<size;i++){
                TreeNode curr = ll.poll(); // Get a node from the LL
                if(curr.val == x) xExists = true; // if x is on this horizontal, note it down
                if(curr.val == y) yExists = true; // if y is on this horizontal, note it down
                
                //We check if x and y have the same parent. Regardless of horizontal, if this is true, we must return false
                if(curr.left != null && curr.right != null){
                    if((curr.left.val == x && curr.right.val == y) || (curr.left.val == y && curr.right.val == x)){
                        return false;
                    }
                }

                // Add left node if exists to LL
                if(curr.left != null){
                    ll.offer(curr.left);
                }

                // Add right node if exists to LL
                if(curr.right != null){
                    ll.offer(curr.right);
                }
            }
            // If both x and y exist of the same horizontal plane as we noted down return true
            if(xExists && yExists) return true;    
        }
        // If you went through every node and didn't find anything, we return false
        return false;
    }

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
