package Brilley.BinaryTree;

import java.util.Arrays;

import static Brilley.BinaryTree.BinaryHeap.downAdjust;
import static Brilley.BinaryTree.BinaryHeap.upAdjust;

/**
 * @author Brilley
 * @date 2022/4/4
 */
public class MyPriorityQueue {
    private int[] array;
    private int size;
    public MyPriorityQueue(){
        array=new int[32];
    }

    public void enQueue(int key){
        if(size>=array.length){
            resize();
        }
        array[size++]=key;
        upAdjust(array);
    }

    public int deQueue() throws Exception{
        if(size<0){
            throw new Exception("the queue is empty!");
        }
        int head=array[0];
        array[0]=array[size-1];
        size--;
        downAdjust(array,0,size);
        return head;
    }

    private void resize(){
        int newSize=this.size*2;
        this.array= Arrays.copyOf(this.array,newSize);
    }

}
