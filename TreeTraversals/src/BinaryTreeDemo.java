/** CT2109 NUI Galway: 
 * Class to demonstrate the use of BinaryTree code. 
 * Based on code by Carrano & Savitch.
 * @author Michael Madden.
 */

public class BinaryTreeDemo 
{
	public static void main(String[] args) 
	{
		// Create a tree
		//System.out.println("Constructing a test tree ...");
		BinaryTree<String> testTree = new BinaryTree<String>();
		BinaryTree<String> testTree2 = new BinaryTree<String>();
		createTree1(testTree);
		//createTree2(testTree2);
		
		
		// Display some statistics about it
		//System.out.println("\nSome statistics about the test tree ...");
		//displayStats(testTree);
		System.out.println("\nTest 2 statistics");
		displayStats(testTree);
		
		
		System.out.println("\nPost order traversal ");
		//testTree2.postOrderTraverse();
		//testTree2.preOrderTraverse();
		//testTree2.bFTraversal();
		testTree.inorderTraverse();
		
		// Perform in-order traversal
		//System.out.println("\nIn-order traversal of the test tree, printing each node when visiting it ...");
		//testTree.inorderTraverse();
		
		//post order
		//System.out.println("\npost-order traversal of the test tree, printing each node when visiting it ...");
		//testTree.postOrderTraverse();
		
		//pre order
		//System.out.println("\npre-order traversal of the test tree, printing each node when visiting it ...");
		//testTree.preOrderTraverse();
		
	} // end of main
	
	
	private static void createTree2(BinaryTree<String> testTree2) {
		BinaryTree<String> oTree = new BinaryTree<String>("O");
		BinaryTree<String> nTree = new BinaryTree<String>("N");
		BinaryTree<String> mTree = new BinaryTree<String>("M");
		BinaryTree<String> lTree = new BinaryTree<String>("L");
		BinaryTree<String> kTree = new BinaryTree<String>("K");
		BinaryTree<String> jTree = new BinaryTree<String>("J");
		BinaryTree<String> iTree = new BinaryTree<String>("I");
		BinaryTree<String> hTree = new BinaryTree<String>("H");
	

		BinaryTree<String> gTree = new BinaryTree<String>("G", nTree, oTree);
		BinaryTree<String> fTree = new BinaryTree<String>("F", lTree, mTree);
		BinaryTree<String> eTree = new BinaryTree<String>("E", jTree, kTree);
		BinaryTree<String> dTree = new BinaryTree<String>("D", hTree, iTree);
		BinaryTree<String> cTree = new BinaryTree<String>("C", fTree, gTree);
		BinaryTree<String> bTree = new BinaryTree<String>("B", dTree, eTree);
		
		testTree2.setTree("A", bTree, cTree);
	}
	//}


	public static void createTree1(BinaryTree<String> tree)
	{
		// To create a tree, build it up from the bottom:
		// create subtree for each leaf, then create subtrees linking them,
		// until we reach the root.
		
	  	System.out.println("\nCreating a treee that looks like this:\n");
	  	System.out.println("     A      ");
	    System.out.println("   /   \\   "); // '\\' is the escape character for backslash
	    System.out.println("  B      C   ");
	    System.out.println(" / \\   / \\");
	    System.out.println("D  E  F   G ");
	    System.out.println();

	    // First the leaves
		BinaryTree<String> dTree = new BinaryTree<String>();
		dTree.setTree("D");
		// neater to use the constructor the initialisation ...
		BinaryTree<String> eTree = new BinaryTree<String>("E");
		BinaryTree<String> fTree = new BinaryTree<String>("F");
		BinaryTree<String> gTree = new BinaryTree<String>("G");
		
		// Now the subtrees joining leaves:
		BinaryTree<String> bTree = new BinaryTree<String>("B", dTree, eTree);
		BinaryTree<String> cTree = new BinaryTree<String>("C", fTree, gTree);

		// Now the root
		tree.setTree("A", bTree, cTree);
	} // end createTree1
	
	public static void displayStats(BinaryTree<String> tree)
	{
		if (tree.isEmpty())
			System.out.println("The tree is empty");
		else
			System.out.println("The tree is not empty");
		
		System.out.println("Root of tree is " + tree.getRootData());
		System.out.println("Height of tree is " + tree.getHeight());
		System.out.println("No. of nodes in tree is " + tree.getNumberOfNodes());
	} // end displayStats 
}