package com.bridgelabz.binarytree;

public class MyBinaryNode<K extends Comparable<K>> 
{
	K key;
	MyBinaryNode<K> left;
	MyBinaryNode<K> right;
	
	public MyBinaryNode(K key)
	{
		this.key = key;
		this.left = null;
		this.right = null;
	}
	
	public K getKey()
	{
		return this.key;
	}
}
