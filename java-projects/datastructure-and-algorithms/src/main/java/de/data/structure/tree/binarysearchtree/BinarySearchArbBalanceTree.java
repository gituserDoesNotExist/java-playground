package de.data.structure.tree.binarysearchtree;

public class BinarySearchArbBalanceTree {

	private SearchNodeArbBalanceImpl rootNode;

	public BinarySearchArbBalanceTree(int initValue) {
		rootNode = new SearchNodeArbBalanceImpl(initValue);
	}

	public int insertNode(SearchNodeArbBalanceImpl node) {
		return rootNode.insertNode(node, 0);
	}

	public boolean search(int value) {
		return rootNode.search(value);
	}

	public SearchNodeArbBalanceImpl getRootNode() {
		return rootNode;
	}

}
