package de.data.structure.tree.binarysearchtree;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class BinarySearchTreeTest {

	@Test
	public void addElementsInOrder_Left_LeftLeft__RotatesTree() {
		BinarySearchTree searchTree = new BinarySearchTree(5);
		searchTree.insertNode(new SearchNodeImpl(4));
		searchTree.insertNode(new SearchNodeImpl(3));

		SearchNodeImpl rootNode = searchTree.getRootNode();
		Assertions.assertThat(rootNode.getValue()).isEqualTo(4);
		Assertions.assertThat(rootNode.getRightChild().getValue()).isEqualTo(5);
		Assertions.assertThat(rootNode.getLeftChild().getValue()).isEqualTo(3);
	}

	@Test
	public void addElementsInOrder_Left_LeftRight_RotatesTree() {
		BinarySearchTree searchTree = new BinarySearchTree(5);
		searchTree.insertNode(new SearchNodeImpl(2));
		searchTree.insertNode(new SearchNodeImpl(3));

		SearchNodeImpl rootNode = searchTree.getRootNode();
		Assertions.assertThat(rootNode.getValue()).isEqualTo(3);
		Assertions.assertThat(rootNode.getRightChild().getValue()).isEqualTo(5);
		Assertions.assertThat(rootNode.getLeftChild().getValue()).isEqualTo(2);
	}

	@Test
	public void addElementsInOrder_Right_RightRight_RotatesTree() {
		BinarySearchTree searchTree = new BinarySearchTree(3);
		searchTree.insertNode(new SearchNodeImpl(4));
		searchTree.insertNode(new SearchNodeImpl(5));

		SearchNodeImpl rootNode = searchTree.getRootNode();
		Assertions.assertThat(rootNode.getValue()).isEqualTo(4);
		Assertions.assertThat(rootNode.getRightChild().getValue()).isEqualTo(5);
		Assertions.assertThat(rootNode.getLeftChild().getValue()).isEqualTo(3);
		Assertions.assertThat(rootNode.getBalanceFactor()).isEqualTo(0);
		Assertions.assertThat(rootNode.getLeftChild().getBalanceFactor()).isEqualTo(0);
	}

	@Test
	public void addElementsInOrder_Right_RightLeft_RotatesTree() {
		BinarySearchTree searchTree = new BinarySearchTree(3);
		searchTree.insertNode(new SearchNodeImpl(5));
		searchTree.insertNode(new SearchNodeImpl(4));

		SearchNodeImpl rootNode = searchTree.getRootNode();
		Assertions.assertThat(rootNode.getValue()).isEqualTo(4);
		Assertions.assertThat(rootNode.getRightChild().getValue()).isEqualTo(5);
		Assertions.assertThat(rootNode.getLeftChild().getValue()).isEqualTo(3);
	}

	@Test
	public void balanceFactor() {
		BinarySearchTree searchTree = new BinarySearchTree(5);
		searchTree.insertNode(new SearchNodeImpl(4));
		searchTree.insertNode(new SearchNodeImpl(3));
	}

}
