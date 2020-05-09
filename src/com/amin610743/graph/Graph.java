package com.amin610743.graph;
import java.util.*;

/**
 * @Author Aminjoni Abdullozoda
 */

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

    /**
     *
     * @param from
     * @param to
     */
    public void removeEdge(String from , String to) {
        GraphNode fromNode = nodes.get(from);
        GraphNode toNode = nodes.get(to);

        if (fromNode == null || toNode == null)
            return;

        adjacencyList.get(fromNode).remove(toNode);

    }

    /**
     *
     * @param root
     */
    public void depthSearchIterative(String root) {

        //Null Check
        GraphNode currentNode =  nodes.get(root);
        if (currentNode == null)
            return;

        //node stack holding vertex
        Stack<GraphNode> nodeStack = new Stack<>();
        Set<GraphNode> visitedNode = new HashSet<>();

        nodeStack.push(currentNode);

        while(!nodeStack.isEmpty()) {
            GraphNode tempNode = nodeStack.pop();

            if (visitedNode.contains(tempNode))
                continue;

            visitedNode.add(tempNode);
            System.out.println(tempNode);

            for (GraphNode n : adjacencyList.get(tempNode))
                if(!visitedNode.contains(n))
                    nodeStack.push(n);

        }
    }

    /**
     *
     * @param root
     */
    public void depthFirstSearch(String root){
        GraphNode graphNode = nodes.get(root);
        if (graphNode == null)
            return;

        depthFirstSearch(graphNode,new HashSet<>());
    }

    /**
     *
     * @param root
     * @param visited
     */
    private void depthFirstSearch(GraphNode root,Set<GraphNode> visited){
        System.out.println(root);
        visited.add(root);

        for (var n : adjacencyList.get(root))
            if(!visited.contains(n))
                depthFirstSearch(n,visited);
    }

    /**
     *
     * @param root
     * @return
     */
    public List<String> topSort(String root) {
        GraphNode node = nodes.get(root);

        Stack<GraphNode> sortNode = new Stack<>();

        if (node == null)
            throw new IllegalArgumentException();

        topSort(node,new HashSet<>(),sortNode);

        List<String> sortedString = new ArrayList<>();
        while (!sortNode.isEmpty()){
            sortedString.add(sortNode.pop().getLabel());
        }
        return sortedString;
    }

    private void topSort(GraphNode root, Set<GraphNode> visited,
                         Stack<GraphNode> sortNode) {
        visited.add(root);

        for (GraphNode node : adjacencyList.get(root)) {
            if (!visited.contains(node))
                topSort(node,visited,sortNode);
        }

        //adding node
        sortNode.push(root);
    }

    /**
     *
     * @param s
     * @return
     */
    public void breathSearchFirstIterative(String s) {

        GraphNode node = nodes.get(s);
        if (node == null)
            return;

        Set<GraphNode> visited = new HashSet<>();
        Queue<GraphNode> onLine =  new LinkedList<>();
        onLine.add(node);

        while (!onLine.isEmpty()){

            GraphNode tempNode = onLine.remove();

            if (visited.contains(tempNode))
                continue;

            visited.add(tempNode);
            System.out.println(tempNode);

            for (GraphNode n : adjacencyList.get(tempNode)) {
                if (!visited.contains(n))
                onLine.add(n);
            }
        }


    }

    public void breathSearchFirst(String root) {
        GraphNode graphNode = nodes.get(root);
        if (graphNode == null)
            return;

        breathSearchFirst(graphNode,new HashSet<>());
    }
    private void breathSearchFirst(GraphNode node,Set<GraphNode> visited) {
        System.out.println(node);
        visited.add(node);

        for (GraphNode n : adjacencyList.get(node)) {
            System.out.println(n);
            visited.add(n);
        }
    }


    public Boolean hasCycle (){
        Set<GraphNode> allNodes = new HashSet<>();
        allNodes.addAll(nodes.values());
        Set<GraphNode> visiting = new HashSet<>();
        Set<GraphNode> visited = new HashSet<>();

        while(!allNodes.isEmpty())
        {
            return  hasCycle(allNodes.iterator().next(),
                    allNodes,
                    visiting,
                    visited);
        }
        return false;
    }
    private Boolean hasCycle(GraphNode node,Set<GraphNode> all,
                             Set<GraphNode> visiting, Set<GraphNode> visited)
    {
        all.remove(node);
        visiting.add(node);

        for (var n : adjacencyList.get(node)){
            if (visited.contains(n))
                continue;
            if (visiting.contains(n))
                return true;
           return  (hasCycle(n,all,visiting,visited)) ? true : false;
        }
        visiting.remove(node);
        visited.add(node);
        return false;

    }


   public void print() {
        for (GraphNode source : adjacencyList.keySet()) {
            List<GraphNode> targetNodes = adjacencyList.get(source);
            if (!targetNodes.isEmpty())
                System.out.println(source + " has connections to : " + targetNodes);
        }
   }
}
