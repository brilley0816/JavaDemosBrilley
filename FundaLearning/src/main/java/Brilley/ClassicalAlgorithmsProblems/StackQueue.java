package Brilley.ClassicalAlgorithmsProblems;

import java.util.Stack;

/**
 * @author Brilley
 * @date 2022/4/7
 */
public class StackQueue {
    private Stack<Integer> stackA=new Stack<Integer>();
    private Stack<Integer> stackB=new Stack<Integer>();

    public void enQueue(int value){
        stackA.push(value);
    }

    public Integer deQueue(){
        if(stackB.isEmpty())
        {
            if(stackA.isEmpty())
                return null;
            transfer();
        }
        return stackB.pop();
    }

    private void  transfer(){
        while(!stackA.isEmpty()){
            stackB.push(stackA.pop());
        }

    }
}
