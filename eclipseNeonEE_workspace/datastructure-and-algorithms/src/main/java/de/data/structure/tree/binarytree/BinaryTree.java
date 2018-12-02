package de.data.structure.tree.binarytree;

public class BinaryTree {

	private NodeImpl root;

	public BinaryTree(NodeImpl node) {
		this.root = node;
	}

	public NodeImpl getRoot() {
		return root;
	}

	public void setRoot(NodeImpl root) {
		this.root = root;
	}

}
