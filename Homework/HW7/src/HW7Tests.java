import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class HW7Tests {

	private BinarySearchTree<Integer> tree;
	private ArrayList<Integer> list;
	
	@Before
	public void setUp() throws Exception{
		
		TreeNode<Integer> one = new TreeNode<Integer>(1);
		TreeNode<Integer> two = new TreeNode<Integer>(2);
	    TreeNode<Integer> three = new TreeNode<Integer>(3);
	    TreeNode<Integer> four = new TreeNode<Integer>(4);
	    TreeNode<Integer> five = new TreeNode<Integer>(5);
	    TreeNode<Integer> six = new TreeNode<Integer>(6);
	    TreeNode<Integer> seven = new TreeNode<Integer>(7);
	    TreeNode<Integer> eight = new TreeNode<Integer>(8);
	    TreeNode<Integer> nine = new TreeNode<Integer>(9);
	    TreeNode<Integer> ten = new TreeNode<Integer>(10);

		tree = new BinarySearchTree<Integer>(seven);
		
		seven.setLeft(three);
		seven.setRight(nine);
		three.setLeft(two);
		three.setRight(five);
		two.setLeft(one);
		five.setLeft(four);
		five.setRight(six);
		nine.setLeft(eight);
		nine.setRight(ten);
		
		list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);


	}

	@Test
	public void sizeSuccess() {
		assertEquals(10, tree.size());
	}
	
	@Test
	public void sizeSuccesstwo() {
		assertEquals(10, tree.size());
	}
	
	@Test
	public void heightSuccess() {
		assertEquals(4, tree.height());
	}
	
	@Test
	public void heightSuccesstwo() {
		assertEquals(3, tree.getRoot().height());
	}
	
	@Test
	public void findSuccess() {
		assertTrue(tree.find(4));
	}
	
	@Test 
	public void findFail() {
		assertFalse(tree.find(11));
	}
	
	@Test
	public void insertSuccess() {
		System.out.println(tree);
		assertTrue(tree.insert(11));
		System.out.println(tree);
	}
	
	@Test
	public void testInsertDuplicateFail() {
		assertFalse(tree.insert(4));
	}
	
	@Test
	public void inOrderSuccess() {
		assertEquals("(1)(2)(3)(4)(5)(6)(7)(8)(9)(10)", tree.inOrder());
	}
	
	@Test
	public void inOrderFail() {
		BinarySearchTree<Integer> yus = new BinarySearchTree<Integer>(new TreeNode<Integer>(89));
		assertEquals("(89)", yus.inOrder());
	}
	
	@Test
	public void toStringSuccess() {
		assertEquals("(1)(2)(3)(4)(5)(6)(7)(8)(9)(10)", tree.toString());
	}
	
	@Test
	public void toStringFail() {
		BinarySearchTree<Integer> yus = new BinarySearchTree<Integer>(new TreeNode<Integer>(89));
		assertEquals("(89)", yus.toString());
	}
	
	@Test
	public void postOrderSuccess() {
		assertEquals("(1)(2)(4)(6)(5)(3)(8)(10)(9)(7)", tree.postOrder());
	}
	
	@Test
	public void postOrderSuccess2() {
		BinarySearchTree<Integer> yus = new BinarySearchTree<Integer>(new TreeNode<Integer>(89));
		assertEquals("(89)", yus.postOrder());
	}
	
	@Test
	public void buildFromListSuccess() {
		assertTrue(tree.buildFromList(list));
	}
	
	@Test
	public void buildFromListInOrderSuccess() {
		tree.buildFromList(list);
		assertEquals("(1)(2)(3)(4)(5)(6)(7)(8)(9)(10)", tree.toString());
	}
}
