package Brilley.Chapter04;

/**
 * @author Brilley
 * @date 2022/3/18
 */
public class CircleQueue {
    String[] elementDatas;
    int num;
    int head=0;
    int tail=0;

    public CircleQueue(int initCapacity){
        elementDatas=new String[initCapacity];
        num=initCapacity;
    }

    public boolean enQueue(String str){
        if((tail%num)+1==head)
            return false;
        elementDatas[tail]=str;
        tail=(++tail)%num;
        return true;
    }

    public String quitQueue()
    {
        if(tail==head)
            return null;
        String str=elementDatas[head];
        head=(++head)%num;
        return str;
    }

    public void print()
    {
        if(head==tail)
            System.out.println("empty!");
        for(int i=head;i!=tail;)
        {
            System.out.println("index: "+i+", elementData: "+elementDatas[i]);
            i=(++i)%num;
        }
    }
}
