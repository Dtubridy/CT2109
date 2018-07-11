/**
 * A class that implements the ADT binary tree.
 * 
 * @author Frank M. Carrano
 * @version 2.0
 */
public class BinaryTree<T> implements BinaryTreeInterface<T>, java.io.Serializable
{
	private static final long serialVersionUID = -1932834476575953631L;
	private BinaryNodeInterface<T> root;
	

	public BinaryTree()
	{
		root = null;
	} // end default constructor

	public BinaryTree(T rootData)
	{
		root = new BinaryNode<T>(rootData);
	} // end constructor

	public BinaryTree(T rootData, BinaryTree<T> leftTree, 
			BinaryTree<T> rightTree)
	{
		privateSetTree(rootData, leftTree, rightTree);
	} // end constructor

	public void setTree(T rootData)
	{
		root = new BinaryNode<T>(rootData);
	} // end setTree

	public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
			BinaryTreeInterface<T> rightTree)
	{
		privateSetTree(rootData, (BinaryTree<T>)leftTree, 
				(BinaryTree<T>)rightTree);
	} // end setTree

	// 26.08
	private void privateSetTree(T rootData, BinaryTree<T> leftTree, 
			BinaryTree<T> rightTree)
	{
		root = new BinaryNode<T>(rootData);

		if ((leftTree != null) && !leftTree.isEmpty())
			root.setLeftChild(leftTree.root);

		if ((rightTree != null) && !rightTree.isEmpty())
		{
			if (rightTree != leftTree)
				root.setRightChild(rightTree.root);
			else
				root.setRightChild(rightTree.root.copy());
		} // end if

		if ((leftTree != null) && (leftTree != this))
			leftTree.clear(); 

		if ((rightTree != null) && (rightTree != this))
			rightTree.clear();
	} // end privateSetTree


	private BinaryNode<T> copyNodes() // not essential
	{
		return (BinaryNode<T>)root.copy();
	} // end copyNodes

	// 26.09
	public T getRootData()
	{
		T rootData = null;

		if (root != null)
			rootData = root.getData();

		return rootData;
	} // end getRootData

	// 26.09
	public boolean isEmpty()
	{
		return root == null;
	} // end isEmpty

	// 26.09
	public void clear()
	{
		root = null;
	} // end clear

	// 26.09
	protected void setRootData(T rootData)
	{
		root.setData(rootData);
	} // end setRootData

	// 26.09
	protected void setRootNode(BinaryNodeInterface<T> rootNode)
	{
		root = rootNode;
	} // end setRootNode

	// 26.09
	protected BinaryNodeInterface<T> getRootNode()
	{
		return root;
	} // end getRootNode

	// 26.10
	public int getHeight()
	{
		return root.getHeight();
	} // end getHeight

	// 26.10
	public int getNumberOfNodes()
	{
		return root.getNumberOfNodes();
	} // end getNumberOfNodes

	// 26.12
	public void inorderTraverse() 
	{
		inorderTraverse(root);
	} // end inorderTraverse
	
	public void postOrderTraverse() 
	{
		postOrderTraverse(root);
	}

	public void preOrderTraverse() 
	{
		preOrderTraverse(root);
	}
	public void bFTraversal() {
		bFTraversal(root);
	}


	private void inorderTraverse(BinaryNodeInterface<T> node) 
	{
		if (node != null)//check if node is not empty
		{
			
			inorderTraverse(node.getLeftChild());//traverse the left child
			System.out.println(node.getData());
			inorderTraverse(node.getRightChild());//print right child
		} // end if
	} // end inorderTraverse
	
	public void preOrderTraverse(BinaryNodeInterface<T> node) { 

		if (node != null) {//check if node is not empty
			System.out.println(node.getData());

			preOrderTraverse(node.getLeftChild());//traverse left node

			preOrderTraverse(node.getRightChild());// traverse right node

		}

	}

	public void postOrderTraverse(BinaryNodeInterface<T> node) {

		if (node != null) {//check is node is not empty

			postOrderTraverse(node.getLeftChild());//traverse left node
			postOrderTraverse(node.getRightChild());//traverse right node

			System.out.println(node.getData());

		}

	}
	
	private void bFTraversal(BinaryNodeInterface<T> node) {	
		Queue q = new ArrayQueue(); 			
		if (node == null){//check for null node and stop if from printing if null  
			return;
		}		while(! q.isEmpty()) { //loop through till queue is empty	    	
	    	
			q.dequeue();//starts dequeue to check if it is empty      
		}	    q.enqueue(root);// puts the root in the queue
		while(!q.isEmpty()){//loop through till queue is empty		 
			node = (BinaryNodeInterface<T>) q.dequeue();	 
			//stores dequeued node	     
			System.out.println(node.getData());	//print node  	       
			if(node.getLeftChild() != null){	 
				q.enqueue(node.getLeftChild());	//if left child add to queue       
				}	

			if(node.getRightChild() != null){	//if not empty enqueue right child        	
				q.enqueue(node.getRightChild());	     
			}	      	  
		}	
} 	
	

} // end BinaryTree




