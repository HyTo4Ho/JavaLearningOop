package ru.academits.java.suslov.tree;

class TreeNode<T> {
    private TreeNode<T> left;
    private TreeNode<T> right;
    private T data;

    TreeNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T value) {
        this.data = value;
    }


    public TreeNode<T> getLeft() {
        return left;
    }


    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }


    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }
}
