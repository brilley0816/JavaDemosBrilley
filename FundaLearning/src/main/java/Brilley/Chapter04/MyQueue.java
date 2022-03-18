package Brilley.Chapter04;

import Brilley.Chapter03.MyArray;

import java.io.IOException;

/**
 * @author Brilley
 * @date 2022/3/15
 */
public class MyQueue {
    private int[] array;
    private int rear;
    private int front;

    public MyQueue(int capacity){
        this.array=new int[capacity];
        this.rear=0;
        this.front=0;
    }

    //insert a data
    public void enQueue(int data) throws Exception
    {
        if((rear+1)==front)
        {
            throw new Exception("error!");
        }
        array[rear]=data;
        rear=(++rear)%array.length;
    }

    //quit a data
    public int quitQueue() throws Exception
    {
        if(rear==front)
        {
            throw new Exception("empty!");
        }
        int data= array[front];
        front=(++front)%array.length;
        return data;
    }

    public void output()
    {
        for(int i=front;i!=rear;i=(++i)%array.length)
        {
            System.out.println(array[i]);
        }
    }
}
