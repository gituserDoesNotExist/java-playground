package de.data.structure.tree.binarytree;

import static java.util.Objects.isNull;

public class NodeImpl {

	private String value;
	private NodeImpl leftChild, rightChild;

	public NodeImpl(String value) {
		this.value = value;
		this.leftChild = this.rightChild = null;
	}

	public void insertLeft(NodeImpl node) {
		if (isNull(getLeftChild())) {
			setLeftChild(node);
		} else {
			node.setLeftChild(getLeftChild());
			setLeftChild(node);
		}
	}

	public void insertRight(NodeImpl node) {
		if (isNull(getRightChild())) {
			setRightChild(node);
		} else {
			node.setRightChild(this.getRightChild());
			this.setRightChild(node);
		}
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public NodeImpl getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(NodeImpl leftNode) {
		this.leftChild = leftNode;
	}

	public NodeImpl getRightChild() {
		return rightChild;
	}

	public void setRightChild(NodeImpl rightNode) {
		this.rightChild = rightNode;
	}

}
