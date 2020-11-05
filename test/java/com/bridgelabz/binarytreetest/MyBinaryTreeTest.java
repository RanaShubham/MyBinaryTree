package com.bridgelabz.binarytreetest;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.binarytree.MyBinaryTree;

public class MyBinaryTreeTest 
{
	@Test
	public void given3Numbers_WhenAddedToBinaryTree_ShouldReturnSizeThree()
	{
		MyBinaryTree<Integer> myBinaryTree = new MyBinaryTree<>();
		myBinaryTree.add(56);
		myBinaryTree.add(30);
		myBinaryTree.add(70);
		
		int size = myBinaryTree.getSize();
		Assert.assertEquals(3, size);
	}
}
