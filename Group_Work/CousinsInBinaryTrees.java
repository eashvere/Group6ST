/**
 * Code and Comments by Eashver Elango, Daniel Gao, and Daniel Hu. 
 */

import java.util.*;

public class CousinsInBinaryTrees {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> ll = new LinkedList<TreeNode>();
        ll.offer(root);
        while(!ll.isEmpty()){
            int size = ll.size();
            boolean xExists = false;
            boolean yExists = false;

            for(int i=0;i<size;i++){
                TreeNode curr = ll.poll();
                if(curr.val == x) xExists = true;
                if(curr.val == y) yExists = true;
                if(curr.left != null && curr.right != null){
                    if((curr.left.val == x && curr.right.val == y) || (curr.left.val == y && curr.right.val == x)){
                        return false;
                    }
                }
                if(curr.left != null){
                    ll.offer(curr.left);
                }
                if(curr.right != null){
                    ll.offer(curr.right);
                }
            }
            if(xExists && yExists) return true;    
        }
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
