import java.util.ArrayList;

/**
 * Binary Search Tree Class
 * 
 * The head class for a binary search tree implementation.
 * 
 * @author db2nb
 * @param <Comparable> Type of data to store in the binary tree
 */
public class BinarySearchTree<T extends Comparable<T>> {

	/**
	 * A reference pointer to the root of the tree
	 */
	private TreeNode<T> root;

	/**
	 * Default constructor
	 * 
	 * Creates a binary tree object with null root note (empty tree)
	 */
	public BinarySearchTree() {
		this(null);
	}

	/**
	 * Constructor
	 * 
	 * Creates a binary tree object with the given node as root
	 * 
	 * @param newRoot The root of the tree
	 */
	public BinarySearchTree(TreeNode<T> newRoot) {
		this.root = newRoot;
	}
	
	/**
	 * Get the root of the tree
	 * 
	 * @return The root of the tree
	 */
	public TreeNode<T> getRoot() {
		return root;
	}

	/**
	 * size returns the size of the entire tree
	 * @return integer of how many nodes are in the tree
	 */
	public int size() {
		
		//if the root is null, the tree isnt viable
		if (this.root == null) {
			return 0;
		}
		
		//if both of the children are not null, adds them up plus the root as part of the tree size
		if (this.root.getLeft() != null && this.root.getRight() != null) {
			return 3 + this.root.getLeft().size() + this.root.getRight().size();
			
		//if the left child is not null, adds it up plus the root as part of the tree size
		}else if (this.root.getLeft() != null && this.root.getRight() == null) {
			return 2 + this.root.getLeft().size();
			
		//if the right child is not null, adds it up plus the root as part of the tree size
		}else if (this.root.getLeft() == null && this.root.getRight() != null) {
			return 2 + this.root.getRight().size();
			
		//if both of the children are null, returns the root as the only node in the tree
		}else {
			return 1;
		}
		
	}
	
	/**
	 * height counts the furthest depth of a tree
	 * @return integer depth of the tree
	 */
	public int height() {
		//if the root is null, the tree isnt viable and thus is height zero
		if (this.root == null) {
			return 0;
		}
		
		//if the root isnt null, it will continue to count the rest of the tree plus the initial height 1
		return 1 + this.root.height();
	}
	
	/**
	 * Set the root of the tree
	 * 
	 * @param root  The new root of this tree
	 */
	public void setRoot(TreeNode<T> root) {
		this.root = root;
	}
	
	/**
	 * inOrder calls the TreeNode class inorder to get the tree to display in order traversal
	 * @return the tree in string, in order traversal
	 */
	public String inOrder() {
		return this.root.inOrder();
	}
	
	/**
	 * postOrder calls the TreeNode class postOrder to get the tree to be traversed and displayed post order
	 * @return the string format of the tree in post order traversal
	 */
	public String postOrder() {
		return this.root.postOrder();
	}
	
	/**
	 * Find if an element exists
	 * 
	 * Checks to see if the value val appears in the
	 * tree (recursively).  Returns true if it appears
	 * and false otherwise.
	 * 
	 * @param val The value to find
	 * @return True if the tree contains the value, false otherwise
	 */
	public boolean find(T val) {
		if(this.root == null) {
			return false;
		}
	    return this.root.find(val);
	}
	
	/**
	 * Insert an element
	 * 
	 * Inserts val into the tree where it should appear, returning
	 * true on success and false otherwise
	 * 
	 * @param val The value to insert
	 * @return True on success, false otherwise
	 */
	public boolean insert(T val) {
		if (this.root == null) {
			this.setRoot(new TreeNode<T>(val));
		}
		return this.root.insert(val);
	}

	   
    /**
     * Delete an element from the tree
     * 
     * Deletes val from the tree if it appears, returning
     * true on success and false otherwise
     * 
     * @param val The value to delete
     * @return True on success, false otherwise
     */
    public boolean delete(T val) {
        return false;
    }

	
	/**
	 * Build from a list
	 * 
	 * Build the tree from the given list, overwriting any tree data
	 * previously stored in this tree.  Should read from beginning to
	 * end of the list and repeatedly call insert() to build the tree.
	 * 
	 * @param list The list from which to build the tree
	 * @return True if successfully built, false otherwise
	 */
	public boolean buildFromList(ArrayList<T> list) {
		
		//if the list is empty, will return false
		if (list.isEmpty()) {
			return false;
		}
		
		//sets the root to the initial item in the list, resetting the tree
		this.setRoot(new TreeNode<T>(list.get(0)));
		
		//iterates through the list, inserting each item into the tree
	    for (T data:list) {
	    	this.insert(data);
	    }
	    return true;
	}
	   
    /**
     * toString method
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return this.root.inOrder();
    }
	
	/**
	 * Main method
	 * 
	 * For testing, etc
	 * 
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {

	}
}