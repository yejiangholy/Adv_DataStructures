package com.company;

public class Main {

    public static void main(String[] args) {

        String s = "01234567";
        System.out.println("we have String s = " + s);
        System.out.println("length = " + s.length());
        System.out.println("s.substring(0,3) = "+ s.substring(0,3));
        System.out.println("s.substring(1) = "+ s.substring(1));
        System.out.println("s.substring(0,2) = "+ s.substring(0,2));
        System.out.println("s.substring(1,2) = "+ s.substring(1,2));
        System.out.println("s.substring(3,7) = "+ s.substring(3,7));
        System.out.println("s.substring(0,s.length()-1) = "+ s.substring(0,s.length()-1));
        System.out.println("s.substring(0,s.length()) = "+ s.substring(0,s.length()));
        System.out.println("for single parameter s.substring(n) --> cut previous n char of string");
        System.out.println("for two parameter s.substring(i,j) --> we need string from charAt(i) to charAt(j-1), which will give us a length (j-i) substring");



    }
}
