package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
      int[] arr = {1,3,5,7,9,11};
        int n = arr.length;
        SegmentTree tree = new SegmentTree(arr, n);

        int sum = tree.getSum(0, n-1);
        System.out.println(sum);    // 36

        tree.updateValue(0,2);
        int sum2 = tree.getSum(0,n-1);
        System.out.println(sum2); // 37

    }
}
