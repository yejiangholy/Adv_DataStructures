package com.company;

public class Main {

    public static void main(String[] args) {


        Trie prefixTree  = new Trie();

        prefixTree.insert("dog");
        prefixTree.insert("dot");
        prefixTree.insert("duck");
        prefixTree.insert("zebra");
        prefixTree.insert("zoo");
        prefixTree.insert("start");
        prefixTree.insert("a");

        String prefixOfDog = prefixTree.getPrefix("dog");
        String prefixOfZoo = prefixTree.getPrefix("zoo");
        boolean zebra = prefixTree.search("zebra");
        boolean a = prefixTree.searchWithPoint(".");
        boolean dt = prefixTree.searchWithPoint("z..ra");  // !!! nice


        System.out.println(zebra);
        System.out.println(dt);
        System.out.println(prefixOfDog);
        System.out.println(prefixOfZoo);
    }
}
