package com.company;

public class Main {

    public static void main(String[] args) {

        int[] input = {1,2,2,2,2,2,3};
        BITree tree = new BITree(input);
        // sum should = 1+ 2*5 + 3 = 14
        int sum = tree.getSum(input.length-1);

        // update first 2 be 5
        tree.updateBITree(3,1);


        // sum2 should be 17
        int sum2 = tree.getSum(input.length-1);


        System.out.println(sum);
        System.out.println(sum2);


    }
}
