package com.company;

/**
 * Created by YeJiang on 11/5/16.
 */
public class SegmentTree {

    private int[] segmentTree;
    private int[] arr;
    private int n;

    public SegmentTree(int[] arr, int n)
    {
        int height = (int)(Math.ceil(Math.log(n)/Math.log(2)));
        int size = 2*(int)(Math.pow(2,height)) - 1;

        this.arr = arr;
        this.n = n;

        segmentTree = new int[size];
        ConstructST(0,n-1,0);
    }

    public int getMid(int i,int j )
    {
        return i+(j-i)/2 ;
    }

    private int ConstructST( int start,int end,int index)           // --> 1. construct tree  log(n)
    {
        if(start == end){
            segmentTree[index] = arr[start];
            return arr[start];                 // the purpose of construct is let tree[index] have a value
        }

        int mid = getMid(start,end);
        segmentTree[index]  = ConstructST(start,mid,2*index+1) + ConstructST(mid+1,end,2*index+2) ;
        return segmentTree[index] ;
    }

    public int getSum(int left, int right)
    {
        if(left<0 || right>n-1 || left>right)return -1;

        return GetSum(0,n-1,left,right,0);
    }
    // ns = Node Start, qs = Query Start
    private int GetSum(int ns, int ne, int qs, int qe, int index)  //-->2. get Range Sum log(n)
    {
        if(qs<=ns && ne<=qe)return segmentTree[index];
        if(qs>ne || qe<ns) return 0;

        int mid = getMid(ns,ne);
        return GetSum(ns,mid,qs,qe,index*2+1) + GetSum(mid+1,ne,qs,qe,index*2+2);
    }

    public void updateValue(int i, int newVale)
    {
        if(i<0 || i>n-1)return;

        int diff = newVale - arr[i];
        arr[i] = newVale;

        UpdateValue(0,n-1,i,diff,0);
    }

    private void UpdateValue(int ns, int ne, int i, int diff , int index)
    {
        if(i<ns || i>ne)return;

        segmentTree[index] = segmentTree[index] + diff;    // update this node

        if(ns != ne){                                      // if we haven't update until leaf node
            int mid = getMid(ns,ne);
            UpdateValue(ns,mid,i,diff,index*2+1);
            UpdateValue(mid+1,ne,i,diff,index*2+2);
        }
    }
}
