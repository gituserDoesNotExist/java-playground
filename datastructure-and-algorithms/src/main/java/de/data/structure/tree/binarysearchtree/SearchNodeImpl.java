package de.data.structure.tree.binarysearchtree;

import static java.util.Objects.isNull;

public class SearchNodeImpl {

	private int value;
	private int balanceFactor;
	private SearchNodeImpl leftChild, rightChild;

	public SearchNodeImpl(int value) {
		this.value = value;
		this.balanceFactor = 0;
		this.leftChild = this.rightChild = null;
	}

	public boolean insertNode(SearchNodeImpl node) {
		if (isSmallerOrEqual(node) && leftChildNotNull()) {
			boolean imbalance = this.getLeftChild().insertNode(node);
			if (imbalance) {
				if (getLeftChild().getBalanceFactor() < -1 || getLeftChild().getBalanceFactor() > 1) {
					this.rebalance(getLeftChild());
				} else {
					setBalanceFactor(getBalanceFactor() - 1);
				}
			}
		} else if (isSmallerOrEqual(node) && leftChildNull()) {
			this.setLeftChild(node);
			setBalanceFactorLeft();
		} else if (isGreater(node) && rightChildNotNull()) {
			boolean imbalance = this.getRightChild().insertNode(node);
			if (imbalance) {
				if (getRightChild().getBalanceFactor() < -1 || getRightChild().getBalanceFactor() > 1) {
					this.rebalance(getLeftChild());
				} else {
					setBalanceFactor(getBalanceFactor() + 1);
				}

			}
		} else if (isGreater(node) && rightChildNull()) {
			this.setRightChild(node);
			setBalanceFactorRight();
		}
		return this.getBalanceFactor() != 0;
	}

	private void rebalance(SearchNodeImpl node) {
		if (node.getBalanceFactor() == -2 && node.getLeftChild().getBalanceFactor() == -1) {
			rotateRight(node);
		} else if (node.getBalanceFactor() == -2 && node.getLeftChild().getBalanceFactor() == 1) {
			rotateLeftAndThenRotateRight(node);
		} else if (node.getBalanceFactor() == 2 && node.getRightChild().getBalanceFactor() == 1) {
			rotateLeft(node);
		} else if (node.getBalanceFactor() == 2 && node.getRightChild().getBalanceFactor() == -1) {
			rotateRightAndThenRotateLeft(node);
		}
	}

	public boolean search(int value) {
		if (value < this.getValue() && leftChildNotNull()) {
			this.getLeftChild().search(value);
		}
		if (value > this.getValue() && rightChildNotNull()) {
			this.getRightChild().search(value);
		}
		return value == this.getValue();
	}

	private void rotateLeft(SearchNodeImpl node) {
		SearchNodeImpl right = node.getRightChild();
		node.setRightChild(right.getLeftChild());
		right.setLeftChild(node);
		if (node == this.getLeftChild()) {
			this.setLeftChild(right);
		} else {
			this.setRightChild(right);
		}
		node.setBalanceFactor(0);
		right.setBalanceFactor(0);
	}

	private void rotateRightAndThenRotateLeft(SearchNodeImpl node) {
		node.getRightChild().getLeftChild().setBalanceFactor(1);
		node.rotateRight(node.getRightChild());
		node.getRightChild().setBalanceFactor(1);
		this.rotateLeft(node);
		rotateLeft(node);
	}

	private void rotateRight(SearchNodeImpl node) {
		SearchNodeImpl left = node.getLeftChild();
		node.setLeftChild(left.getRightChild());
		left.setRightChild(node);
		if (this.getLeftChild() == node) {
			this.setLeftChild(left);
		} else {
			this.setRightChild(left);
		}
		node.setBalanceFactor(0);
		left.setBalanceFactor(0);
	}

	private void rotateLeftAndThenRotateRight(SearchNodeImpl node) {
		node.getLeftChild().getRightChild().setBalanceFactor(-1);
		node.rotateLeft(node.getLeftChild());
		node.getLeftChild().setBalanceFactor(-1);
		this.rotateLeft(node);
		rotateRight(node);
	}

	private void setBalanceFactorRight() {
		if (leftChildNull()) {
			this.setBalanceFactor(1);
		} else {
			this.setBalanceFactor(0);
		}
	}

	private void setBalanceFactorLeft() {
		if (rightChildNull()) {
			this.setBalanceFactor(-1);
		} else {
			this.setBalanceFactor(0);
		}
	}

	private boolean leftChildNull() {
		return isNull(this.getLeftChild());
	}

	private boolean leftChildNotNull() {
		return !leftChildNull();
	}

	private boolean rightChildNull() {
		return isNull(this.getRightChild());
	}

	private boolean rightChildNotNull() {
		return !rightChildNull();
	}

	private boolean isSmallerOrEqual(SearchNodeImpl node) {
		return node.getValue() <= this.getValue();
	}

	private boolean isGreater(SearchNodeImpl node) {
		return node.getValue() > this.getValue();
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public SearchNodeImpl getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(SearchNodeImpl leftChild) {
		this.leftChild = leftChild;
	}

	public SearchNodeImpl getRightChild() {
		return rightChild;
	}

	public void setRightChild(SearchNodeImpl rightChild) {
		this.rightChild = rightChild;
	}

	public int getBalanceFactor() {
		return balanceFactor;
	}

	public void setBalanceFactor(int balanceFactor) {
		this.balanceFactor = balanceFactor;
	}

}
