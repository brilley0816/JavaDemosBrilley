package Brilley.Chapter04;

/**
 * @author Brilley
 * @date 2022/3/17
 */
public class MySinglyLinkedList {
    private int size;
    private ListNode head;
    private static class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val)
        {
            this.val=val;
        }
        ListNode(int val,ListNode next)
        {
            this.val=val;
            this.next=next;
        }

    }

    public void add(int data)
    {
        ListNode newNode=new ListNode(data,null);
        if(head==null)
            head=newNode;
        else{
            ListNode current;
            current=head;
            while(current.next!=null)
                current=current.next;
            current.next=newNode;
        }
    }

    public void print()
    {
        ListNode current;
        current=head;
        while (current!=null)
        {
            System.out.println(current.val);
            current=current.next;
        }
    }

    public void reverseList()
    {
        ListNode current=head;
        ListNode last=null;
        while (current!=null)
        {
            ListNode nextNode=current.next;
            current.next=last;
            last=current;
            current=nextNode;
        }
        head=last;
    }

    public void mergerTwoSortedList(ListNode list1, ListNode list2)
    {
        ListNode result=null;
        result=mergerTwoList(list1,list2);
    }

    private ListNode mergerTwoList(ListNode list1,ListNode list2)
    {
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        return (list1.val>list2.val)? mergerTwoList(list1,list2.next):mergerTwoList(list1.next,list2);
    }

    public ListNode deleteDuplicates(ListNode head) {
        //method create a new list
        if(head==null)
            return head;

        ListNode newList=new ListNode(head.val);
        ListNode current=newList;
        while(head.next!=null)
        {
            head=head.next;
            if(head.val==current.val)
                continue;
            ListNode newNode=new ListNode(head.val,null);
            current.next=newNode;
            current=current.next;
        }
        return newList;

        //method 2
//        if(head==null)
//            return head;
//        ListNode index=head;
//        ListNode nextNode;
//        while(index.next!=null)
//        {
//            nextNode=index.next;
//            if(nextNode.val==index.val)
//            {
//                index.next=nextNode.next;
//                continue;
//            }
//            index=index.next;
//        }
//        return head;


    }

    public ListNode removeElements(ListNode head, int val) {

        if(head==null)
            return head;
        while(head.val==val)
        {
            head=head.next;
            if(head==null)
                return head;
        }
        ListNode nextNode=head.next;
        ListNode current=head;
        while(nextNode!=null)
        {
            if(nextNode.val==val)
            {
                current.next=nextNode.next;
                nextNode=nextNode.next;
                continue;
            }
            current=nextNode;
            nextNode=nextNode.next;
        }
        return head;
    }

}
