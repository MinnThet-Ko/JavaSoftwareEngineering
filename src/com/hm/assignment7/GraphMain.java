package com.hm.assignment7;

public class GraphMain {

	public static void main(String[] args) {
		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		Node e = new Node("E");
		
		
		Edge edge1 = new Edge(a, b, 4);
		Edge edge2 = new Edge(a, c, 2);
		Edge edge3 = new Edge(b, c, 5);
		Edge edge4 = new Edge(b, d, 10);
		Edge edge5 = new Edge(c, e, 3);
		Edge edge6 = new Edge(e, d, 4);
		
		Graph graph = new Graph();
		
		graph.addNode(a);
		graph.addNode(b);
		graph.addNode(c);
		graph.addNode(d);
		graph.addNode(e);
		
		graph.addEdge(edge1);
		graph.addEdge(edge2);
		graph.addEdge(edge3);
		graph.addEdge(edge4);
		graph.addEdge(edge5);
		graph.addEdge(edge6);
		
		graph.getShortestPath("A", "D");
		graph.showChosenNodes();
		
		
	}

}
