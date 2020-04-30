package com.amin610743.tree;

public class BinaryTree implements  Tree {

    private TreeNode root;
    private int count = 0;

    @Override
    public TreeNode add(Integer val)  {
        count++;
        TreeNode newNode = new TreeNode(null, val,null);

        //if root note is empty
        if (root  == null) {
            root = newNode;
            return newNode;
        }

        //recursively traverse
        TreeNode currentNode = traverse(root,val);
        if (val>currentNode.value)
            currentNode.right = newNode;
        else
            currentNode.left = newNode;

        return newNode;
    }

    private TreeNode traverse(TreeNode node, Integer val) {
        TreeNode tNode = node;
        if (val > node.value) {
            if (tNode.right == null)
                return tNode;

            tNode = node.right;
        }
        else {
            if (tNode.left == null)
                return tNode;

            tNode = node.left;
        }

        return traverse(tNode,val);
    }


    @Override
    public Integer size() {
        return count;
    }

    @Override
    public boolean contain(Integer value) {
        return false;
    }

    @Override
    public TreeNode remove(Integer val) {
        return null;
    }

    public void  printTree () {
        printInOrder(root);
    }

   private void printInOrder(TreeNode node){
        if (node == null)
            return;

        printInOrder(node.left);
        System.out.println(node.value);
        printInOrder(node.right);

   }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(2);
        binaryTree.add(3);
        binaryTree.add(1);

        binaryTree.printTree();
        System.out.println("Size : " + binaryTree.size());
    }
}
