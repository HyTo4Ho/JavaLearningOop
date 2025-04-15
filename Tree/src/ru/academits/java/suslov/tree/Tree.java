package ru.academits.java.suslov.tree;

import java.util.Comparator;

public class Tree<T> {
    private TreeNode<T> root;
    private int count;

    public Tree() {
    }

    public int size() {
        return count;
    }

    public void add(T value) {
        count++;

        if (root == null) {
            root = new TreeNode<>(value);

            return;
        }

        TreeNode<T> currentNode = root;

        while (true) {
            if (compare(value, currentNode.getData()) < 0) {
                if (currentNode.getLeft() == null) {
                    currentNode.setLeft(new TreeNode<>(value));

                    return;
                }
            } else {
                if (currentNode.getRight() == null) {
                    currentNode.setRight(new TreeNode<>(value));

                    return;
                }

                currentNode = currentNode.getRight();
            }
        }
    }

    public void remove(T value) {
        if (count == 1) {
            root = null;
            count--;
            return;
        }

        TreeNode<T> currentNode = root;
        TreeNode<T> parentNode = null;

        while (currentNode != null) {
            int compareResult = compare(value, currentNode.getData());

            if (compareResult == 0) {
                break;
            }

            parentNode = currentNode;
            currentNode = compareResult < 0 ? currentNode.getLeft() : currentNode.getRight();
        }

        if (currentNode == null) {
            return;
        }

        if (currentNode.getLeft() == null && currentNode.getRight() == null) {
            if (currentNode == parentNode.getLeft()) {
                parentNode.setLeft(null);
            } else {
                parentNode.setRight(null);
            }
        } else if (currentNode.getLeft() == null || currentNode.getRight() == null) {
            TreeNode<T> childNode;

            if (currentNode.getLeft() == null) {
                childNode = currentNode.getRight();
            } else {
                childNode = currentNode.getLeft();
            }

            if (parentNode == null) {
                root = childNode;
            } else if (parentNode.getLeft() == currentNode) {
                parentNode.setLeft(childNode);
            } else {
                parentNode.setRight(childNode);
            }
        } else {
            TreeNode<T> heirParent = currentNode;
            TreeNode<T> heir = currentNode.getRight();

            while (heir.getLeft() != null) {
                heirParent = heir;
                heir = heir.getLeft();
            }

            if (heirParent.getLeft() == heir) {
                heirParent.setLeft(heir.getRight());
            } else {
                heirParent.setRight(heir.getRight());
            }

            heir.setLeft(currentNode.getLeft());
            heir.setRight(currentNode.getRight());

            if (parentNode == null) {
                root = heir;
            } else if (parentNode.getLeft() == currentNode) {
                parentNode.setLeft(heir);
            } else {
                parentNode.setRight(heir);
            }
        }

        count--;
    }

    private Comparator<? super T> comparator;

    private int compare(T value1, T value2) {
        if (value1 == null && value2 == null) {
            return 0;
        } else if (value1 == null) {
            return -1;
        } else if (value2 == null) {
            return 1;
        }

        if (comparator != null) {
            return comparator.compare(value1, value2);
        }

        return ((Comparable<T>) value1).compareTo(value2);
    }
}
