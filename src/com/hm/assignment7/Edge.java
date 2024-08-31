package com.hm.assignment7;

public class Edge {
	private Node startNode;
	private Node endNode;
	private int weight;
	
	public Edge(Node startNode, Node endNode, int weight) {
		this.startNode = startNode;
		this.endNode = endNode;
		this.weight = weight;
	}

	public Node getStartNode() {
		return startNode;
	}

	public Node getEndNode() {
		return endNode;
	}

	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	

}
