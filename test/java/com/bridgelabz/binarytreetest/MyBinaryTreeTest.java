package com.bridgelabz.binarytreetest;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.binarytree.MyBinaryNode;
import com.bridgelabz.binarytree.MyBinaryTree;
import com.bridgelabz.mylinkedlistjava.NodeNotFoundException;

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
	
	@Test
	public void givenBinaryTree_ShoudlReturnCorrectSize()
	{
		MyBinaryTree<Integer> myBinaryTree = new MyBinaryTree<>();
		myBinaryTree.add(56);
		myBinaryTree.add(30);
		myBinaryTree.add(70);
		myBinaryTree.add(22);
		myBinaryTree.add(40);
		myBinaryTree.add(60);
		myBinaryTree.add(95);
		myBinaryTree.add(11);
		myBinaryTree.add(65);
		myBinaryTree.add(3);
		myBinaryTree.add(16);
		myBinaryTree.add(63);
		myBinaryTree.add(67);
		
		int size = myBinaryTree.getSize();
		Assert.assertEquals(13, size);
	}
	
	@Test
	public void givenABinaryTree_WhenFindingAParticularNodeWithKey_ShouldReturnThatNode()
	{
		MyBinaryTree<Integer> myBinaryTree = new MyBinaryTree<>();
		myBinaryTree.add(56);
		myBinaryTree.add(30);
		myBinaryTree.add(70);
		myBinaryTree.add(22);
		myBinaryTree.add(40);
		myBinaryTree.add(60);
		myBinaryTree.add(95);
		myBinaryTree.add(11);
		myBinaryTree.add(65);
		myBinaryTree.add(3);
		myBinaryTree.add(16);
		myBinaryTree.add(63);
		myBinaryTree.add(67);
		
		MyBinaryNode<Integer> nodeToBeFound = myBinaryTree.findNode(63);
		Integer numToFind = Integer.valueOf(63);
		Assert.assertEquals(numToFind, nodeToBeFound.getKey());
	}
	
	@Test(expected = NodeNotFoundException.class)
	public void givenABinaryTree_WhenFindingAParticularNodeWithKey_ifNotPresentShouldThrowNodeNotFoundException()
	{
		MyBinaryTree<Integer> myBinaryTree = new MyBinaryTree<>();
		myBinaryTree.add(56);
		myBinaryTree.add(30);
		myBinaryTree.add(70);
		myBinaryTree.add(22);
		
		MyBinaryNode<Integer> nodeToBeFound = myBinaryTree.findNode(63);
	}
	
	@Test(expected = NodeNotFoundException.class)
	public void givenABinaryTree_WhenFindingANodeWithNullKey_ifNotPresentShouldThrowNodeNotFoundException()
	{
		MyBinaryTree<Integer> myBinaryTree = new MyBinaryTree<>();
		myBinaryTree.add(56);
		myBinaryTree.add(30);
		myBinaryTree.add(70);
		myBinaryTree.add(22);
		
		MyBinaryNode<Integer> nodeToBeFound = myBinaryTree.findNode(null);
	}
}
