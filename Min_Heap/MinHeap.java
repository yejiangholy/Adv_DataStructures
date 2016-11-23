package com.company;

/**
 * Created by YeJiang on 11/16/16.
 */
public class MinHeap {

    private int[] Heap;
    private int size;
    private int maxSize;

    private static final int Front = 1;

    public MinHeap(int maxsize)
    {
        this.maxSize = maxsize;
        size = 0;
        Heap = new int[maxSize + 1];
        Heap[0] = Integer.MIN_VALUE;

    }

    private int parent(int pos)
    {
        return pos/2;
    }

    private int leftChild(int pos)
    {
        return 2*pos;
    }

    private int rightChild(int pos)
    {
        return 2*pos + 1;
    }

    private boolean isLeaf(int pos)
    {
        if(pos >= (size/2) && pos<=size)return true;

        return false;
    }

    private void swap (int i, int j)
    {
        int temp = Heap[i];
        Heap[i] = Heap[j];
        Heap[j] = temp;
    }

    private void minHeapify(int pos) // if it is a leaf && > leftChild || rightChild, we swap and recursive call
    {
        if(! isLeaf(pos)){

            if(Heap[pos]>Heap[leftChild(pos)]){

                swap(pos,leftChild((pos)));
                minHeapify(leftChild(pos));
            }
            else if (Heap[pos]>Heap[rightChild(pos)]){

                swap(pos,rightChild(pos));
                minHeapify(rightChild(pos));

            }

        }
    }

    public void insert ( int ele)       // insert --> keep swap with its parents
    {
        Heap[++size] = ele;
        int cur= size;

        while(Heap[cur] < Heap[parent(cur)] && cur >0){

            swap(cur,parent(cur));
            cur = parent(cur);

        }

    }

    public void minHeap(){   // minHeap --> run heapify from size/2 to 1

        for(int pos = size/2; pos>=1 ; pos--)
        {
            minHeapify(pos);
        }

    }

    // return the min in ths MinHeap
    public int pop()  // swap with Front with last element in heap then run heapify on Front
    {
        int pop = Heap[Front];
        Heap[Front] = Heap[size--];

        minHeapify(Front);

        return pop;

    }

    public int peek()
    {
        return Heap[Front];
    }


}
