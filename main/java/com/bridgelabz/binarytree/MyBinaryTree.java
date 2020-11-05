package com.bridgelabz.binarytree;

public class MyBinaryTree<K extends Comparable<K>> 
{
	private MyBinaryNode<K> root;
	
	/**
	 * Adding Binary node element to the Binary tree. Here we are replacing the root each time we add a new element.
	 * That means, each time we add something to the tree we create a whole new identical tree with new node added
	 * to it. This new tree replaces our old tree through this method.
	 * @param key
	 */
	public void add(K key)
	{
		this.root = this.addRecursively(root, key);
	}

	/**
	 * Adds Binary node into the Binary tree recursively.
	 * @param current
	 * @param key
	 * @return
	 */
	private MyBinaryNode<K> addRecursively(MyBinaryNode<K> current, K key) 
	{
		//If no node present in binary tree then create a new Binary node with key and return it.
		//In recursion, this method also checks if the right or left of our node exists or not. If not,
		//then it will create a new node and return it to the last recursive call made. Through that call
		//this node will be assigned as the left or right of our previous parent node.
		if(current == null)
			return new MyBinaryNode<>(key);
		
		int compareResult = key.compareTo(current.key);
		
		//If root node present in binary Node tree has same key as the given key, then return the root node back.
		//In case of recursion if let's say an end leaf node has same key compared to the key that we want to
		//add then the current end node will be returned in response to the previous call. Then parent node will
		//do same and return itself(through the last return statement in this method) to it's parent node.
		//This will continue all the way back to root node and in the end root node will be returned to add().
		if(compareResult == 0)
			return current;
		//If the current node in binaryNode tree has a key greater than the key to be added,
		//then take left node of current node as new current node and repeat. Otherwise, take
		//right node of current node as new current node and repeat.
		if(compareResult < 0)
			current.left = addRecursively(current.left, key);
		else
			current.right = addRecursively(current.right, key);
		//In case of recursion below line will return rest of the parent node from leaf end to until root end is reached.
		//Let's say, before reaching below statement we are in third generation of leave nodes. After adding a new 
		//child node at the end ,here we return the parent node to which this child node was added. Then by subsequent
		//returns are made until root node reaches, i.e. end of method call stack. At last we return a root node to add(),
		//whose end leaves were updated with a new node.
		return current;
	}

	
	/** To get the number of elements in a binary tree.
	 * @return
	 */
	public int getSize() 
	{
		return this.getSizeRecursively(root);
	}

	/**
	 * Traverses through each node, on the left and right of every parent node and keeps adding 1 until it gets null.
	 * @param current
	 * @return
	 */
	private int getSizeRecursively(MyBinaryNode<K> current) 
	{
		return current == null ? 0 : 1 + this.getSizeRecursively(current.left) + this.getSizeRecursively(current.right);
	}
}
