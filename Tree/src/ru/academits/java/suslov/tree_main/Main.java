package ru.academits.java.suslov.tree_main;

import ru.academits.java.suslov.tree.Tree;

public class Main {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();

        tree.add(1);
        tree.add(10);
        tree.add(100);
        tree.add(1000);
        tree.add(10000);
        tree.add(100000);
        tree.add(1000000);
        tree.add(10000000);

        System.out.printf("Размер дерева: %d%n", tree.size());

        tree.remove(10000000);

        System.out.printf("Размер дерева: %d%n", tree.size());
    }
}
