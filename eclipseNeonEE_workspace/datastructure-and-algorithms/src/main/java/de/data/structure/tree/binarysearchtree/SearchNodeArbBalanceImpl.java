package de.data.structure.tree.binarysearchtree;

import static java.util.Objects.isNull;

public class SearchNodeArbBalanceImpl {

	private int value;
	private int balanceFactor;
	private SearchNodeArbBalanceImpl leftChild, rightChild;

	public SearchNodeArbBalanceImpl(int value) {
		this.value = value;
		this.balanceFactor = 0;
		this.leftChild = this.rightChild = null;
	}

	public int insertNode(SearchNodeArbBalanceImpl node, int balanceValue) {
		if (isSmallerOrEqual(node) && leftChildNotNull()) {
			int value = this.getLeftChild().insertNode(node, this.getBalanceFactor());
			balanceValue = balanceValue - Math.abs(value);
		} else if (isSmallerOrEqual(node) && leftChildNull()) {
			this.setLeftChild(node);
			setBalanceFactorLeft();
			return this.getBalanceFactor() + balanceValue;
		} else if (isGreater(node) && rightChildNotNull()) {
			int value = this.getRightChild().insertNode(node, this.getBalanceFactor());
			balanceValue = balanceValue + Math.abs(value);
		} else if (isGreater(node) && rightChildNull()) {
			this.setRightChild(node);
			setBalanceFactorRight();
			return this.getBalanceFactor() + balanceValue;
		}
		return balanceValue;
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

	private boolean isSmallerOrEqual(SearchNodeArbBalanceImpl node) {
		return node.getValue() <= this.getValue();
	}

	private boolean isGreater(SearchNodeArbBalanceImpl node) {
		return node.getValue() > this.getValue();
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public SearchNodeArbBalanceImpl getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(SearchNodeArbBalanceImpl leftChild) {
		this.leftChild = leftChild;
	}

	public SearchNodeArbBalanceImpl getRightChild() {
		return rightChild;
	}

	public void setRightChild(SearchNodeArbBalanceImpl rightChild) {
		this.rightChild = rightChild;
	}

	public int getBalanceFactor() {
		return balanceFactor;
	}

	public void setBalanceFactor(int balanceFactor) {
		this.balanceFactor = balanceFactor;
	}

}
