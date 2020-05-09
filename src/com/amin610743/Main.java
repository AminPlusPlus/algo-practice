package com.amin610743;


import com.amin610743.graph.Graph;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode("C");
        graph.addNode("A");
        graph.addNode("S");
        graph.addNode("B");
        graph.addNode("D");

        graph.addEdge("C","A");
        graph.addEdge("A","B");

        graph.addEdge("S","B");
        graph.addEdge("S","D");
        graph.addEdge("C","S");

        graph.print();


        //System.out.println(graph.topSort("S"));;
        graph.depthFirstSearch("C");
        System.out.println("\n");
        graph.breathSearchFirstIterative("C");




    }
}
