package Brilley.Chapter04;

import java.util.Arrays;

public class MyIntArrList {
    private static final int DEFAULT_CAPACITY=10;
    private int[] elementData;
    private int size;

    public MyIntArrList()
    {
        elementData=new int[0];
    }

    public MyIntArrList(int intiLen)
    {

    }

    public boolean add(int data){
        ensureCapacityInternal(size+1);
        elementData[size++]=data;
        return true;
    }

    public int delete(int index) throws Exception {
        checkRange(index);
        int data=elementData[index];
        remove(index);
        return data;
    }

    public void remove(int index){
        int numMoved=size-index-1;
        if(numMoved>0)
        {
            System.arraycopy(elementData,index+1,elementData,index,numMoved);
        }
        //elementData[--size]=-1;
        size--;
    }

    public int get(int index) throws Exception {
        checkRange(index);
        return elementData[index];
    }

    public int count(){
        return size;
    }

    public void print(){
        System.out.print("[");
        for(int i=0;i<size-1;i++)
        {
            System.out.print(elementData[i]+",");
        }
        System.out.println(elementData[size-1]+"]");
    }

    public void checkRange(int index) throws Exception
    {
        if(index<0 || index>=size)
            throw new Exception("wrong index!");
    }

    private void ensureCapacityInternal(int minCapacity){
        if(elementData==null)
        {
            minCapacity=Math.max(DEFAULT_CAPACITY,minCapacity);
        }

        ensureExplicitCapacity(minCapacity);
    }

    private void ensureExplicitCapacity(int minCapacity){
        if(minCapacity-elementData.length>0)
            grow(minCapacity);
    }

    private void grow(int minCapacity){
        int oldCapacity=elementData.length;
        int newCapacity=oldCapacity+(oldCapacity >> 1);
        if(newCapacity-minCapacity<0)
            newCapacity=minCapacity;
        elementData= Arrays.copyOf(elementData,newCapacity);
    }
}
