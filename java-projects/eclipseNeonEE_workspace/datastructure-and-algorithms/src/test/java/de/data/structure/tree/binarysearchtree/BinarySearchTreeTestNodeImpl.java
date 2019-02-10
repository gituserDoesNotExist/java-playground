package de.data.structure.tree.binarysearchtree;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class BinarySearchTreeTestNodeImpl {

	@Test
	public void addElementsInOrder_Left_LeftLeft_Rotates_LeftLeftLeft_LeftLeftLeftLeft_RotatesTree() {
		BinarySearchTree searchTree = new BinarySearchTree(5);
		searchTree.insertNode(new SearchNodeImpl(4));
		searchTree.insertNode(new SearchNodeImpl(3));

		SearchNodeImpl rootNode = searchTree.getRootNode();
		Assertions.assertThat(rootNode.getValue()).isEqualTo(4);
		Assertions.assertThat(rootNode.getRightChild().getValue()).isEqualTo(5);
		Assertions.assertThat(rootNode.getLeftChild().getValue()).isEqualTo(3);

		searchTree.insertNode(new SearchNodeImpl(2));
		searchTree.insertNode(new SearchNodeImpl(1));

		searchTree.getRootNode();
		Assertions.assertThat(rootNode.getValue()).isEqualTo(4);
		Assertions.assertThat(rootNode.getRightChild().getValue()).isEqualTo(5);
		Assertions.assertThat(rootNode.getLeftChild().getValue()).isEqualTo(2);
		Assertions.assertThat(rootNode.getLeftChild().getLeftChild().getValue()).isEqualTo(1);
		Assertions.assertThat(rootNode.getLeftChild().getRightChild().getValue()).isEqualTo(3);
	}

}
