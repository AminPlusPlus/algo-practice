package com.amin610743.graph;

import org.w3c.dom.Node;

import java.util.*;

public class Graph {

    private Map<GraphNode,List<GraphNode>> adjacencyList =  new HashMap<>();
    private Map<String,GraphNode> nodes = new HashMap<>();

    /**
     *
     * @param label
     */
    public void addNode(String label) {
        GraphNode newNode = new GraphNode(label);
        nodes.putIfAbsent(label,newNode);
        adjacencyList.putIfAbsent(newNode,new ArrayList<>());
    }

    /**
     *
     * @param from
     * @param to
     */
    public void addEdge (String from ,String to) {

        GraphNode fromNode = nodes.get(from);
        GraphNode toNode = nodes.get(to);

        if (fromNode == null || toNode == null)
            throw new IllegalArgumentException();

        adjacencyList.get(fromNode).add(toNode);

    }

    /**
     *
     * @param label
     * @return
     */
    public void removeNode (String label) {
        GraphNode tempNode = nodes.get(label);
        if (tempNode == null)
            return;

        for (GraphNode node : adjacencyList.keySet())
             adjacencyList.get(node).remove(tempNode);


        nodes.remove(tempNode);
        adjacencyList.remove(tempNode);

    }

    public void removeEdge(String from , String to) {
        GraphNode fromNode = nodes.get(from);
        GraphNode toNode = nodes.get(to);

        if (fromNode == null || toNode == null)
            return;

        adjacencyList.get(fromNode).remove(toNode);

    }




   public void print() {
        for (GraphNode source : adjacencyList.keySet()) {
            List<GraphNode> targetNodes = adjacencyList.get(source);
            if (!targetNodes.isEmpty())
                System.out.println(source + " has connections to : " + targetNodes);
        }
   }
}
