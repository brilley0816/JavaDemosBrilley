package Brilley.Chapter03;

import sun.java2d.pipe.SpanIterator;

import java.util.Arrays;

/**
 * @author Brilley
 * @date 2022/3/14
 */
public class MyArray {
    private int size;
    private int[] array;

    public MyArray(int capacity)
    {
        this.array=new int[capacity];
        this.size=0;
    }

    public boolean insert(int pos,int data) throws Exception
    {
        if(pos<0 || pos>size){
            throw new IndexOutOfBoundsException("error");
        }
        if(size>=array.length){
            System.out.println("resize...");
            resize();
        }
        for(int i=size;i>pos;i--)
        {
            array[i]=array[i-1];
        }
        array[pos]=data;
        size++;
        return true;
    }

    public void print()
    {
        System.out.print("[");
        for(int i=0;i<size-1;i++)
        {
            System.out.print(array[i]+", ");
        }
        System.out.print(array[size-1]);
        System.out.print("]");
        System.out.println();
    }

    private void resize()
    {
        int[] arraycopy=new int[array.length*2];
        for(int i=0;i<size;i++)
        {
            arraycopy[i]=array[i];
        }
        array=arraycopy;
        System.out.println(array.length);
    }

    public int length()
    {
        return size;
    }

    public int get(int pos)
    {
        if(pos<0 || pos>size){
            throw new IndexOutOfBoundsException("error");
        }
        return array[pos];
    }

    public boolean delete(int pos)
    {
        if(pos<0 || pos>size){
            throw new IndexOutOfBoundsException("error");
        }
        for(int i=pos;i<size-1;i++)
        {
            array[i]=array[i+1];
        }
        size--;
        return true;
    }
}
