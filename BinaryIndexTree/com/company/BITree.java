package com.company;

/**
 * Created by YeJiang on 10/21/16.
 *///Binary Index Tree -- > if we need previous sum also support update value
public class BITree {
    int[] BITree;
    int TreeLength;

    public BITree(int[] input)
    {                                                  // create tree ->O(n*log(n))
        int length = input.length;
        this.BITree = new int[length+1];
        this.TreeLength = BITree.length;


        for(int i=1;i<TreeLength;i++){
            this.updateBITree(input[i-1],i);
        }

    }
    public void updateBITree(int val, int index ){      // update -> O(log(n))

           //index = index +1;     --> why update do not need to add 1 in index?

          while(index<TreeLength){
              BITree[index] += val;
              index += index&(-index);
          }

    }

    public int getSum(int index)                       // sum until index -> O(log(n))
    {
        index = index + 1;
        int sum = 0;
        while(index > 0){
            sum += BITree[index];
            index -= index&(-index);
        }
         return sum;
    }

}
