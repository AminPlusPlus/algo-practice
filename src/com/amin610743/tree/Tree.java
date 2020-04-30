package com.amin610743.tree;

public interface Tree {
    TreeNode add(Integer val);
    Integer size();
    boolean contain(Integer value);
    TreeNode remove (Integer val);
}
