package com.bridgelabz.binarytree;

import com.bridgelabz.mylinkedlistjava.NodeNotFoundException;

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
		if(current == null)
			return new MyBinaryNode<>(key);
		
		int compareResult = key.compareTo(current.key);
		
		if(compareResult == 0)
			return current;
		if(compareResult < 0)
			current.left = addRecursively(current.left, key);
		else
			current.right = addRecursively(current.right, key);
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
	 * To get the node with given key.
	 * @param key
	 * @return Node with desired key.
	 */
	public MyBinaryNode<K> findNode(K key)
	{
		if(key == null)
			throw new NodeNotFoundException("A binary tree node cannot have null key");
		return  this.findNodeWithKey(this.root, key);
	}

	/**
	 * Finding the desired node recursively.
	 * @param current
	 * @param key
	 * @return Node with desired key.
	 */
	private MyBinaryNode<K> findNodeWithKey(MyBinaryNode<K> current, K key) 
	{
		if(current == null)
			throw new NodeNotFoundException("Node with key "+key+" not found.");
		int compareResult = key.compareTo(current.key);
		
		if(compareResult == 0)
			return current;
		if(compareResult < 0)
			current = findNodeWithKey(current.left, key);
		else
			current = findNodeWithKey(current.right, key);
		return current;
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
