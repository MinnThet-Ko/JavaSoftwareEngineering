package com.hm.assignment7;

public class Node {
	
	private String nodeName;
	private Node previousNode;
	private double distanceFromPreviousNode;
	private boolean visited;
	
	public Node(String nodeName) {
		this.nodeName = nodeName;
		this.visited = false;
		this.previousNode = null;
		this.distanceFromPreviousNode = 0;
	}
	
	public String getNodeName() {
		return this.nodeName;
	}
	
	public boolean isVisited() {
		return this.visited;
	}
	
	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public Node getPreviousNode() {
		return previousNode;
	}

	public void setPreviousNode(Node previousNode) {
		this.previousNode = previousNode;
	}

	public double getDistanceFromPreviousNode() {
		return distanceFromPreviousNode;
	}

	public void setDistanceFromPreviousNode(double distanceFromPreviousNode) {
		this.distanceFromPreviousNode = distanceFromPreviousNode;
	}

}
