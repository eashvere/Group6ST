public class BinaryTreePracticePart2 {
    
    //height Daniel Hu
    public int height(IntTreeNode overallRoot){
        return recursiveHeight(overallRoot);
    }

    private int recursiveHeight(IntTreeNode root){
        if(root == null){
            return 0;
        }
	// recurse left and right and compare
        return Math.max(recursiveHeight(root.left),recursiveHeight(root.right)) + 1; 
    }

    
    //isBalanced Daniel Gao
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
	// store the lengths
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
	// at the end or conditions met
        if (left == -1 || right == -1 || Math.abs(left-right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    //lowestCommonAncestor Eashver
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	// if is itself, it is found
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
	// return depending on which one is found
        if(left == null){
            return right;
        } else {
            return right == null ? left : root;
        }
    }

    //searchBST Eashver
    public TreeNode searchBST(TreeNode root, int val){
	// when found or end
        if(root == null || root.val == val){
            return root;
        }
	// if less, search left, if more, search right
        return val<root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public class IntTreeNode {
        int data;
        IntTreeNode left;
        IntTreeNode right;
        IntTreeNode() {}
        IntTreeNode(int data) { this.data = data; }
        IntTreeNode(int data, IntTreeNode left, IntTreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

}