

/**
 * Binary Tree Node
 * 
 * Tree node that has two children: left and right
 * 
 * @author db2nbm
 * @param <Comparable> The type of data this tree node stores
 */
public class TreeNode<T extends Comparable<T>> {

	/**
	 * Reference pointer to the left subtree
	 */
	private TreeNode<T> left;

	/**
	 * Reference pointer to the right subtree
	 */
	private TreeNode<T> right;

	/**
	 * Data stored at this node
	 */
	private T data;

	/**
	 * Default Constructor
	 * 
	 * Creates a binary tree node with null data and null children
	 */
	public TreeNode(){
		this(null,null,null);
	}

	/**
	 * Data-only Constructor
	 * 
	 * Creates a binary tree node with the given data and null children
	 * 
	 * @param theData The data to store at this node
	 */
	public TreeNode(T theData){
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
	public TreeNode(T theData, TreeNode<T> leftChild, TreeNode<T> rightChild){
		data = theData;
		left = leftChild;
		right = rightChild;
	}


	/**
	 * Left Child/Subtree getter
	 * 
	 * @return A reference pointer to the root of the left subtree
	 */
	public TreeNode<T> getLeft() {
		return left;
	}

	/**
	 * Left Child/Subtree Setter
	 * 
	 * @param left A reference pointer to the new left subtree's root node
	 */
	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}

	/**
	 * Right Child/Subtree getter
	 * 
	 * @return A reference pointer to the root of the right subtree
	 */
	public TreeNode<T> getRight() {
		return right;
	}

	/**
	 * Right Child/Subtree Setter
	 * 
	 * @param left A reference pointer to the new right subtree's root node
	 */
	public void setRight(TreeNode<T> right) {
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
	 * size recursively goes through the tree, returning the final size using the root as the initial caller
	 * @return integer amount of nodes in the tree
	 */
	public int size() {
		
		//if both left and right are null, returns 0. base case
		if (this.getLeft() == null && this.getRight() == null) {
			return 0;
		}
		
		//if left is null and right isnt null, will continue counting down the right tree
		if (this.getLeft() == null && !(this.getRight() == null)) {
			return 1 + this.getRight().size();
			
		//if the left is not null and the right is null, will continue counting down the left tree
		}else if(!(this.getLeft() == null) && this.getRight() == null) {
			return 1 + this.getLeft().size();
			
		//if both arent null, will continue counting down both sub trees
		}else {
			return 2 + this.getLeft().size() + this.getRight().size();
		}
	}

	/**
	 * height returns the furthest depth that the tree reaches 
	 * @return integer depth of the tree
	 */
	public int height() {
		
		//base case, if both left and right are null, return 0
		if (this.getLeft() == null && this.getRight() == null) {
			return 0;
		}
		
		//if left is null and right is not null, continues down the right tree
		if (!(this.getRight() == null) && this.getLeft()==null) {
			return 1 + this.getRight().height();
		
		//if left is not null and right is null, continues down the left tree
		}else if(!(this.getLeft() == null) && this.getRight() == null) {
			return 1 + this.getLeft().height();
			
		//if both are not null, compares which would return a higher height, and continues down the greater depth tree
		}else {
			if(this.getLeft().height() > this.getRight().height()) {
				return 1 + this.getLeft().height();
			}else {
				return 1 + this.getRight().height();
			}
		}

	}

	/**
	 * find, finds if a piece of data is in the tree
	 * @return returns true if the data is in the tree, false if not
	 */
	public boolean find(T val) {
		
		//if the current node is equal to the given data, returns true, base case
		if(this.data == val) {
			return true;
		}
		
		// if left and right are not null, returns true or false based on their paths
		else if(!(this.getLeft() == null) && !(this.getRight() == null)) {
			return this.getLeft().find(val) || this.getRight().find(val);
			
		//if left is not null and right is null, continues to find the piece of data in the left subtree
		}else if(!(this.getLeft() == null) && this.getRight() == null) {
			return this.getLeft().find(val);
			
		//if left is null and right is not null, continues to find the piece of data in the right subtree
		}else if (!(this.getRight() == null) && this.getLeft() == null) {
			return this.getRight().find(val);
			
		//otherwise, returns false
		}else {
			return false;
		}

	}

	/**
	 * insert puts a piece of data into a tree
	 * @return true if the piece of data was successfully insertted into the tree, false if not
	 */
	public boolean insert(T val) {
		
		//if the piece of data exists in the tree, automatically ends the insert call
		if (this.find(val)) {
			return false;
		}
		
		//if the current piece of data is equal to the given data, ends insert call
		if (this.data == val) {
			return false;
			
		//if the current node data is greater than the given data, continues down the right tree to insert 
		}else if (this.getData().compareTo(val) < 0) {
			
			//if the right subtree is null, then inserts here
			if (this.getRight() == null) {
				this.setRight(new TreeNode<T>(val));
				return true;
				
			//otherwise, continues down right subtree
			}else {
				return this.getRight().insert(val);
			}
			
		//otherwise, continues down the left subtree
		}else {
			
			//if the left subtree is null, inserts here
			if (this.getLeft() == null) {
				this.setLeft(new TreeNode<T>(val));
				return true;
				
			//otherwise, continues down the left subtree
			}else {
				return this.getLeft().insert(val);
			}
		}
	}
	
	/**
	 * inOrder displays the tree using in order traversal
	 * @return the string version of the tree
	 */
	public String inOrder() {
		
		//sets up the string
		String s = "";
		
		//left node
		if(this.left != null) {
			s += this.left.inOrder();
		}
		
		//root node
		s += "(" + this.data + ")";
		
		//right node
		if(this.right != null) {
			s += this.right.inOrder();
		}
		
		//base case
		return s;
	}
	
	/**
	 * postOrder displays the tree using post order traversal
	 * @return the string version of the tree in post order
	 */
	public String postOrder() {
		
		//sets up the string
		String s = "";
		
		//left node
		if(this.left != null) {
			s += this.left.postOrder();
		}
		
		//right node
		if(this.right != null) {
			s += this.right.postOrder();
		}
		
		//root node
		s += "(" + this.data + ")";
		return s;
	}


	/**
	 * Main method
	 * 
	 * For main method testing, etc
	 * 
	 * @param args Command-line arguments
	 */
	public static void main(String[] args) {

	}

}