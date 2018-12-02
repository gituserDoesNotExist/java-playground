package de.data.structure.tree.binarysearchtree;

public class BinarySearchTree {

	private SearchNodeImpl rootNode;
	private int nodes;

	public BinarySearchTree(int initValue) {
		rootNode = new SearchNodeImpl(initValue);
		nodes = 1;
	}

	public void insertNode(SearchNodeImpl node) {
		nodes++;
		rootNode.insertNode(node);
		if (nodes == 3 && rootNode.getBalanceFactor() == -2 && rootNode.getLeftChild().getBalanceFactor() == -1) {
			rotateRight(rootNode);
		} else if (nodes == 3 && rootNode.getBalanceFactor() == -2 && rootNode.getLeftChild().getBalanceFactor() == +1) {
			rotateLeftAndThenRotateRight(rootNode);
		} else if (nodes == 3 && rootNode.getBalanceFactor() == 2 && rootNode.getRightChild().getBalanceFactor() == +1) {
			rotateLeft(rootNode);
		} else if (nodes == 3 && rootNode.getBalanceFactor() == 2 && rootNode.getRightChild().getBalanceFactor() == -1) {
			rotateRightAndThenLeft(rootNode);
		}
	}

	private void rotateRightAndThenLeft(SearchNodeImpl node) {
		SearchNodeImpl right = node.getRightChild();
		SearchNodeImpl rightLeft = right.getLeftChild();
		node.setRightChild(rightLeft);
		rightLeft.setRightChild(right);
		rotateLeft(node);
	}

	private void rotateLeftAndThenRotateRight(SearchNodeImpl node) {
		SearchNodeImpl left = node.getLeftChild();
		SearchNodeImpl leftRight = left.getRightChild();
		node.setLeftChild(leftRight);
		leftRight.setLeftChild(left);
		rotateRight(node);
	}

	private void rotateLeft(SearchNodeImpl node) {
		node.setBalanceFactor(0);
		SearchNodeImpl right = node.getRightChild();
		right.setBalanceFactor(0);
		node.setRightChild(right.getLeftChild());
		right.setLeftChild(node);
		rootNode = right;
	}

	private void rotateRight(SearchNodeImpl node) {
		SearchNodeImpl left = node.getLeftChild();
		node.setLeftChild(left.getRightChild());
		left.setRightChild(node);
		left.setBalanceFactor(0);
		node.setBalanceFactor(0);
		rootNode = left;
	}

	public boolean search(int value) {
		return rootNode.search(value);
	}

	public SearchNodeImpl getRootNode() {
		return rootNode;
	}

	public int getRootNodeBalanceFactor() {
		return rootNode.getBalanceFactor();
	}

}
