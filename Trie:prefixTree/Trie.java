package com.company;

import com.sun.org.apache.xml.internal.utils.StringBufferPool;

/**
 * Created by YeJiang on 10/21/16.
 */
public class Trie {

    class TrieNode{
        TrieNode[] arr;
        boolean isEnd;
        int freq;

        public TrieNode(){
            this.arr = new TrieNode[26];
            this.freq = 1;
            }
    }

    private TrieNode root;

    public Trie(){
        root =new TrieNode();
    }

    public void insert(String word)
    {
        TrieNode p = root;
        for(int i=0;i<word.length();i++)
        {
            char c = word.charAt(i);
            int index = c -'a';
            if(p.arr[index]==null){
                TrieNode temp = new TrieNode();
                p.arr[index] = temp;
                p = temp;
            }else {
                TrieNode node = p.arr[index];
                node.freq = node.freq+1;
                p = node;
            }
        }
        p.isEnd = true;
    }

    public String getPrefix(String word)   // only one general Trie now
    {
        StringBuilder sb = new StringBuilder();
        buildString(root,word,sb,0);

        return sb.toString();
    }

    public void buildString(TrieNode node, String s,StringBuilder sb,int index)
    {
        // assume this String is in our TrieTree
        if(index>=s.length())return;
        char c = s.charAt(index);
        sb.append(c);
        TrieNode next = node.arr[c-'a'];
        if(next.freq==1)return;
        else {
            buildString(next, s, sb, ++index);
        }

    }


    public boolean search(String word){

        TrieNode node = searchNode(word);

        return(node!=null && node.isEnd);


    }
    public boolean searchWithPoint(String word){
        return match(word,0,root);
    }

    private boolean match(String s, int i, TrieNode node)
    {
        if(node == null)return false;
        if(i == s.length())return (node==null)? false:node.isEnd;
        char cur = s.charAt(i);
        if(cur != '.')return (node.arr[cur-'a'] != null)&&match(s,i+1,node.arr[cur-'a']);
        else{
            for(TrieNode n: node.arr){
                if(n != null){                //if one of them at end will return true
                    if(match(s,i+1,n))return true;
                }
            }
        }
        return false;
    }

    public boolean startWith(String word)
    {
        TrieNode node = searchNode(word);

        return(node!=null);

    }

    private TrieNode searchNode(String s)
    {
        TrieNode p = root;

        for(int i=0;i<s.length();i++)
        {
            int index = s.charAt(i) - 'a';
            if(p.arr[index] == null)return null;
            else{
                p = p.arr[index];
            }
        }
        if (p == root) return null;

        return p;
    }

}
