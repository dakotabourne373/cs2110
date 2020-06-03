
/**
 * Binary Tree Node
 * 
 * Tree node that has two children: left and right
 * 
 * @author CS2110 - Spring 2019
 * @param <T> The type of data this tree node stores
 */
/**
 * @author jrhott
 *
 * @param <T>
 */
public class BinaryTreeNode<T> {
	
	/**
	 * Reference pointer to the left subtree
	 */
	private BinaryTreeNode<T> left;
	
	/**
	 * Reference pointer to the right subtree
	 */
	private BinaryTreeNode<T> right;
	
	/**
	 * Data stored at this node
	 */
	private T data;
	
	/**
	 * Default Constructor
	 * 
	 * Creates a binary tree node with null data and null children
	 */
	public BinaryTreeNode(){
		this(null,null,null);
	}
	
	/**
	 * Data-only Constructor
	 * 
	 * Creates a binary tree node with the given data and null children
	 * 
	 * @param theData The data to store at this node
	 */
	public BinaryTreeNode(T theData){
		this(theData,null,null);
	}
	
	
	/**
	 * Full Constructor
	 * 
	 * Creates a binary tree node with the given data and child reference pointers
	 * 
	 * @param theData The data to store at this node
	 * @param leftChild A reference pointer to the left subtree
	 * @param rightChild A reference pointer to the right subtree
	 */
	public BinaryTreeNode(T theData, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild){
		data = theData;
		left = leftChild;
		right = rightChild;
	}


	/**
	 * Left Child/Subtree getter
	 * 
	 * @return A reference pointer to the root of the left subtree
	 */
	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	/**
	 * Left Child/Subtree Setter
	 * 
	 * @param left A reference pointer to the new left subtree's root node
	 */
	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

    /**
     * Right Child/Subtree getter
     * 
     * @return A reference pointer to the root of the right subtree
     */
	public BinaryTreeNode<T> getRight() {
		return right;
	}

    /**
     * Right Child/Subtree Setter
     * 
     * @param left A reference pointer to the new right subtree's root node
     */
	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}

	/**
	 * Get the data at this node
	 * 
	 * @return The data stored at this node
	 */
	public T getData() {
		return data;
	}

	/**
	 * Set the data at this node
	 * 
	 * @param data The data to be stored at this node
	 */
	public void setData(T data) {
		this.data = data;
	}
	
	/**
	 * toString method
	 *
	 */
	@Override
	public String toString() {
	    String retVal = "";
	    if (left != null)
	        retVal += left.toString(); // recursive call on left
	    retVal += "("+data+")"; // add this node's data
	    if (right != null) 
	        retVal += right.toString(); // recursive call on right
	    return retVal;
	}
	
	/**
	 * Main method
	 * 
	 * Your code should go here
	 * 
	 * @param args Command-line arguments
	 */
	public static void main(String[] args) {
	    BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1);
	    
	    //TODO Your code should go here
	    BinaryTreeNode one = new BinaryTreeNode(1);
	    BinaryTreeNode two = new BinaryTreeNode(2);
	    BinaryTreeNode three = new BinaryTreeNode(3);
	    BinaryTreeNode four = new BinaryTreeNode(4);
	    BinaryTreeNode five = new BinaryTreeNode(5);
	    BinaryTreeNode six = new BinaryTreeNode(6);
	    BinaryTreeNode seven = new BinaryTreeNode(7);
	    BinaryTreeNode eight = new BinaryTreeNode(8);

	    one.setRight(three);
	    one.setLeft(two);
	    two.setRight(five);
	    two.setLeft(four);
	    four.setLeft(six);
	    five.setLeft(seven);
	    five.setRight(eight);
	    
        System.out.println(one.toString());
	}

}