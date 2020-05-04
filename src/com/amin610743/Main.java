package com.amin610743;

import com.amin610743.graph.Graph;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode("MUM");
        graph.addNode("Walmart");
        graph.addNode("GoldenDome");
        graph.addEdge("MUM","Walmart");
        graph.addEdge("MUM","GoldenDome");
        graph.removeNode("MUM");

        graph.addEdge("GoldenDome","Walmart");

        graph.print();
    }
}
