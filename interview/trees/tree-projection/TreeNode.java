package com.trees;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

	private int nodeId;

	public TreeNode(int nodeId) {
		super();
		this.nodeId = nodeId;
	}

	List<TreeNode> children;

	public List<TreeNode> getChildren() {
		if(children == null)
			children = new ArrayList<TreeNode>();
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}

	public int getNodeId() {
		return nodeId;
	}

	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}

}
