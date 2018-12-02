package de.data.structure.tree.binarysearchtree;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchArbBalanceTreeTest {

	private BinarySearchArbBalanceTree searchTree;

	@Before
	public void setUp() {
		searchTree = new BinarySearchArbBalanceTree(50);
	}

	@Test
	public void insert() {
		searchTree.insertNode(new SearchNodeArbBalanceImpl(21));
		searchTree.insertNode(new SearchNodeArbBalanceImpl(76));

		Assertions.assertThat(searchTree.getRootNode().getValue()).isEqualTo(50);
		Assertions.assertThat(searchTree.getRootNode().getLeftChild().getValue()).isEqualTo(21);
		Assertions.assertThat(searchTree.getRootNode().getRightChild().getValue()).isEqualTo(76);
	}

	@Test
	public void insert_ResultDoesNotDependOnInsertOrder() {
		searchTree.insertNode(new SearchNodeArbBalanceImpl(76));
		searchTree.insertNode(new SearchNodeArbBalanceImpl(21));

		Assertions.assertThat(searchTree.getRootNode().getValue()).isEqualTo(50);
		Assertions.assertThat(searchTree.getRootNode().getLeftChild().getValue()).isEqualTo(21);
		Assertions.assertThat(searchTree.getRootNode().getRightChild().getValue()).isEqualTo(76);
	}

	@Test
	public void insert_BuildTreeCorrectly() {
		searchTree.insertNode(new SearchNodeArbBalanceImpl(76));
		searchTree.insertNode(new SearchNodeArbBalanceImpl(21));
		searchTree.insertNode(new SearchNodeArbBalanceImpl(32));
		searchTree.insertNode(new SearchNodeArbBalanceImpl(64));
		searchTree.insertNode(new SearchNodeArbBalanceImpl(52));
		searchTree.insertNode(new SearchNodeArbBalanceImpl(4));
		searchTree.insertNode(new SearchNodeArbBalanceImpl(100));

		Assertions.assertThat(searchTree.getRootNode().getValue()).isEqualTo(50);
		Assertions.assertThat(searchTree.getRootNode().getLeftChild().getValue()).isEqualTo(21);
		Assertions.assertThat(searchTree.getRootNode().getRightChild().getValue()).isEqualTo(76);
		Assertions.assertThat(searchTree.getRootNode().getLeftChild().getLeftChild().getValue()).isEqualTo(4);
		Assertions.assertThat(searchTree.getRootNode().getLeftChild().getRightChild().getValue()).isEqualTo(32);
		Assertions.assertThat(searchTree.getRootNode().getRightChild().getLeftChild().getValue()).isEqualTo(64);
		Assertions.assertThat(searchTree.getRootNode().getRightChild().getRightChild().getValue()).isEqualTo(100);
		Assertions.assertThat(searchTree.getRootNode().getRightChild().getLeftChild().getLeftChild().getValue()).isEqualTo(52);
	}

	@Test
	public void balanceFactor() {
		BinarySearchArbBalanceTree searchTree = new BinarySearchArbBalanceTree(10);
		Assertions.assertThat(searchTree.insertNode(new SearchNodeArbBalanceImpl(9))).isEqualTo(-1);
		Assertions.assertThat(searchTree.insertNode(new SearchNodeArbBalanceImpl(11))).isEqualTo(-0);
		Assertions.assertThat(searchTree.insertNode(new SearchNodeArbBalanceImpl(8))).isEqualTo(-1);
		Assertions.assertThat(searchTree.insertNode(new SearchNodeArbBalanceImpl(7))).isEqualTo(-2);
		Assertions.assertThat(searchTree.insertNode(new SearchNodeArbBalanceImpl(6))).isEqualTo(-3);
		Assertions.assertThat(searchTree.insertNode(new SearchNodeArbBalanceImpl(5))).isEqualTo(-4);
		Assertions.assertThat(searchTree.insertNode(new SearchNodeArbBalanceImpl(4))).isEqualTo(-5);
		Assertions.assertThat(searchTree.insertNode(new SearchNodeArbBalanceImpl(3))).isEqualTo(-6);
		Assertions.assertThat(searchTree.insertNode(new SearchNodeArbBalanceImpl(2))).isEqualTo(-7);
	}

}
