package com.amin610743;


import com.amin610743.graph.Graph;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("D");
        graph.addNode("C");

        graph.addEdge("A","B");
        graph.addEdge("A","D");

        graph.addEdge("B","C");
        graph.addEdge("B","D");

        graph.print();


        System.out.println(graph.topSort("A"));;
        //graph.depthSearchIterative("X");
        //graph.breathSearchFirst("MUM");




    }
}
