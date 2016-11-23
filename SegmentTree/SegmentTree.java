package com.company;

/**
 * Created by YeJiang on 11/4/16.
 */
public class SegmentTree {
   private  int[] segmentTree;
    private int[]  input;

    public SegmentTree(int[] input)
    {
        int size = NextPowerOf2(input.length);
        segmentTree = new int[size*2 -1];
        this.input = input;

        for(int i=0; i < segmentTree.length; i++){        // range query in a array
            segmentTree[i] = Integer.MAX_VALUE;
        }

        constructMinSegmentTree(segmentTree,input,0,input.length-1,0);

    }

    private void constructMinSegmentTree(int segmentTree[], int input[], int low, int high,int pos){  //--> O(n)
        if(low == high){
            segmentTree[pos] = input[low];
            return;
        }
        int mid = (low+high)/2;
        constructMinSegmentTree(segmentTree,input,low,mid,2*pos+1);
        constructMinSegmentTree(segmentTree,input,mid+1,high,2*pos+2);
        segmentTree[pos] = Math.min(segmentTree[2*pos+1],segmentTree[2*pos+2]);
    }

    public int rangeMinQuery(int[] segmentTree, int low, int high, int len)
    {
        return RangeMinQuery(segmentTree,0,len-1,low,high,0);
    }

    public int RangeMinQuery(int segmentTree[],int low,int high,int qlow,int qhigh,int pos){     //--> O(log(n))

        if(qlow <= low && qhigh>=high){  // total overlap
            return segmentTree[pos];
        }
        if(qlow>high || qhigh<low){      // no overlap
            return Integer.MAX_VALUE;
        }

        int mid = (low+high)/2 ;         // partial overlap return small children
        return Math.min(RangeMinQuery(segmentTree,low,mid,qlow,qhigh,2*pos+1),RangeMinQuery(segmentTree,mid+1,high,qlow,qhigh,2*pos+2));
    }

    public void updateValue(int i, int newValue)
    {
        if(i<0 || i>input.length-1)return;
        int diff = newValue - input[i];
        input[i] = newValue;

        UpdateValue(0,input.length-1,i,diff,0);
    }


    private void UpdateValue(int ns, int ne, int i, int diff, int index)
    {
        if(i<ns || i>ne)return;

        if(ns == ne){
            segmentTree[index] += diff;
            return;
        }
        int mid = ns+(ne-ns)/2;
        UpdateValue(ns,mid,i,diff,index*2+1);
        UpdateValue(mid+1,ne,i,diff,index*2+2);
        segmentTree[index] = Math.min(segmentTree[index*2+1],segmentTree[index*2+2]);

    }
    private int NextPowerOf2(int n)
    {
        if(n==0)return 1;

        if(n>0  &&  (n & (n-1))==0)return n;

        while((n & (n-1)) > 0){
            n = n & (n-1);
        }
        return n<<1;
    }
}
