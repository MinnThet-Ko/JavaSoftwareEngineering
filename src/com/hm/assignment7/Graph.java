package com.hm.assignment7;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Graph {
	private List<Node> nodeList;
	private List<Edge> edgeList;
	private List<Node> chosenNodes;
	
	public Graph() {
		this.nodeList =  new ArrayList<>();
		this.edgeList =  new ArrayList<>();
		this.chosenNodes = new ArrayList<>();
	}
	
	public void addNode(Node node) {
		this.nodeList.add(node);
	}
	
	public void addEdge(Edge edge) {
		this.edgeList.add(edge);
	}
	
	public List<Edge> getAdjacentEdges(String nodeName) {
		return this.edgeList.stream().filter(edge -> edge.getStartNode().getNodeName().equals(nodeName) && edge.getEndNode().isVisited() == false )
		.collect(Collectors.toList());
	}
	
	public Node getNodeByName(String nodeName) {
		return this.nodeList.stream().filter(node -> node.getNodeName().equals(nodeName)).collect(Collectors.toList()).get(0);
	}
	
	public void getShortestPath(String start, String end) {
		Node startingNode = getNodeByName(start);
		List<Edge> adjacentEdges = getAdjacentEdges(start);
		if(adjacentEdges.isEmpty()) {
			this.chosenNodes.add(startingNode);
			return;
		}
		Node chosenNode =  null;
		Edge chosenEdge = null;
		for(Edge edge: adjacentEdges) {
			Node endNode = edge.getEndNode();
			endNode.setDistanceFromPreviousNode(edge.getWeight());
			endNode.setPreviousNode(startingNode);
			if(chosenEdge == null) {
				chosenNode = endNode;
				chosenEdge = edge;
			} else if(edge.getWeight() < chosenEdge.getWeight()) {
				chosenNode = endNode;
				chosenEdge = edge;
			}
		}
		this.chosenNodes.add(startingNode);
		int index = this.nodeList.indexOf(startingNode);
		this.nodeList.get(index).setVisited(true);
		getShortestPath(chosenNode.getNodeName(), end);
		
	}
	
	
	public void showChosenNodes() {
		double total = 0;
		System.out.println("Path: ");
		for(Node node: this.chosenNodes) {
			total += node.getDistanceFromPreviousNode();
			System.out.println(node.getNodeName());
		}
		System.out.println("Total weight: "+total);
	}
	
}
