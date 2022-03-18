package Brilley.Chapter04;

public class MyLinkedList<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    private static class Node<E>{
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next){
            this.next=next;
            this.item=element;
            this.prev=prev;
        }
    }

    public MyLinkedList()
    {
//        first=new Node<>(null,null,null);
//        last=new Node<>(null,null,null);
//        first.next=last;
//        last.prev=first;
        this.size=0;
    }

    public boolean add(E e){
        linkLast(e);
        return true;
    }

    public void linkLast(E e){
        final Node<E> l=last;
        final Node<E> newNode=new Node<>(l,e,null);
        last=newNode;
        if(l==null)
            first=newNode;
        else
            l.next=newNode;
        size++;
    }

    public void print(){
        //System.out.println(first.item);
        Node<E> ff=first;
        for(;ff!= null;ff=ff.next)
        {
            System.out.println(ff.item);
            System.out.println(ff);
        }

    }
}
