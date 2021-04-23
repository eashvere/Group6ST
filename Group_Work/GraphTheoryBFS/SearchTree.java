//importSearchTreeNode;

// Class SearchTree stores and prints a binary search tree of
// objects of type E.  E must implement the Comparable<E>
// interface.

/*
Contributions: 
Eashver Elango did coding
Daniel Gao did coding
Daniel Hu did commenting
Puvith did commenting
*/

import java.util.LinkedList;

public class SearchTree<E extends Comparable<E>> {
    private SearchTreeNode<E> overallRoot; // root of overall tree

    // post: constructs an empty search tree
    public SearchTree() {
        overallRoot = null;
    }

    // post: value added to tree so as to preserve binary search tree
    public void add(E value) {
        overallRoot = add(overallRoot, value);
    }

    // post: value added to tree so as to preserve binary search tree
    private SearchTreeNode<E> add(SearchTreeNode<E> root, E value) {
        if (root == null) {
            root = new SearchTreeNode<E>(value);
        } else if (root.data.compareTo(value) >= 0) {
            root.left = add(root.left, value);
        } else {
            root.right = add(root.right, value);
        }
        return root;
    }

    // post: returns true if tree contains value, returns false otherwise
    public boolean contains(E value) {
        return contains(overallRoot, value);
    }   

    // post: returns true if given tree contains value, returns false otherwise
    private boolean contains(SearchTreeNode<E> root, E value) {
        if (root == null) {
            return false;
        } else {
            int compare = value.compareTo(root.data);
            if (compare == 0) {
                return true;
            } else if (compare < 0) {
                return contains(root.left, value);
            } else {   // compare > 0
                return contains(root.right, value);
            }
        }
    }

    // post: prints the data of the tree, one per line
    public void print() {
        printInorder(overallRoot);
    }

    // post: prints the data of the tree using an inorder traversal
    private void printInorder(SearchTreeNode<E> root) {
        if (root != null) {
            printInorder(root.left);
            System.out.println(root.data);
            printInorder(root.right);
        }
    }

    private static class SearchTreeNode<E> {
        public E data;                   // data stored in this node
        public SearchTreeNode<E> left;   // left subtree
        public SearchTreeNode<E> right;  //  right subtree

        // post: constructs a leaf node with given data
        public SearchTreeNode(E data) {
            this(data, null, null);
        }

        // post: constructs a node with the given data and links
        public SearchTreeNode(E data, SearchTreeNode<E> left,
                              SearchTreeNode<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }


    // post: value removed from tree so as to preserve binary search tree
    public void remove(E value) {
    	overallRoot = remove(overallRoot, value);
    }
    
    
 // post: value removed to tree so as to preserve binary search tree
    private SearchTreeNode<E> remove(SearchTreeNode<E> root, E value) {
    	if (root == null) {
    		return null;
    	} 
    	int comp = root.data.compareTo(value);
    	if (comp > 0) {
    		root.left = remove(root.left, value);
    	} else if (comp < 0) {
    		root.right = remove(root.right, value);
    	} else {
    		if (root.right == null) {
    			return root.left;
    		} else if (root.left == null) {
    			return root.right;
    		} else {
    			root.data = findSmallest(root.right);
    			root.right = remove(root.right, root.data);
    		}
    	}
    	return root;
    }
    
	
	// post: return the smallest value in the binary search tree  
    private E findSmallest(SearchTreeNode<E> root) {
    	if (root.left == null) {
    		return root.data;
    	} else {
    		return findSmallest(root.left);
    	}
    	
    }

    /*
    * printByLevel uses a BFS algorithm to iteratively print out each level of the 
    * search tree. The time complexity of BFS is always O(E) but since E = V-1 we
    * can simplify this O(V-1) or O(V) to simply O(n). Space complexity is at worst
    * also O(n) because the queue can never be larger than the amount of nodes in 
    * the graph. 
    */
	public void printByLevel() {
        // First we make our queue (which is a LinkedList in java)
		LinkedList<SearchTreeNode<E>> q = new LinkedList<>();

        // We add the first (top) node to the queue
		q.add(overallRoot);

        // We'll only end when the queue is fully empty
        while(!q.isEmpty()){
            // Size essentially keeps track of the amount of nodes on the current level
            int size = q.size();

            // So we iterate over each node at the current level
            while(size > 0){
                // For each node on the level, we poll it
                SearchTreeNode<E> cur = q.poll();
                // Print out the data
                System.out.print(cur.data + " ");

                // Add that node's corresponding left and right nodes if they exist
                if(cur.left != null)
                    q.add(cur.left);
                if(cur.right != null)
                    q.add(cur.right);
                
                // This statement is part of the level iteration process    
                size--;
            }
            // Once we're done iterating over a level, we create a new line to start the next level.
            System.out.println();
        }
	}
}
