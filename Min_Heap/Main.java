package com.company;

public class Main {


    // function to return k'th largest element from input stream


    // find the Kth largest in O(1) and insert in log(K) time
    public void KthLargest(int k )
    {
        int count = 0;
        int x;

        int[] arr = new int[k];
        MinHeap mh = new MinHeap(k);

        if(count < k-1){
            mh.insert(x);
            count++;
        }

        else{

            if(count == k-1)    // build a min heap when input size == k
            {
                mh.insert(x);
                mh.minHeap();
            }
        }

        if(x> mh.peek()){      // insert a big element
            mh.pop();
            mh.insert(x);
        }



    }


    public static void main(String[] args) {
	// write your code here


    }
}
