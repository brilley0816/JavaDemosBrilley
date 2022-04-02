package Brilley.BinaryTree;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.LinkedList;

public class BinaryTree {
    private static class TreeNode{
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data){
            this.data=data;
        }
    }

    //输入形式 在代码的main函数中，通过{3,2,9,null,null,10,null,null,8,null,4}这样一个线性序列，构建成的二叉树如下。
    //魏梦舒. 漫画算法：小灰的算法之旅 (Kindle位置1169). 电子工业出版社. Kindle 版本.
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList){
        TreeNode node=null;
        if(inputList==null || inputList.isEmpty()){
            return null;
        }
        Integer data=inputList.removeFirst();
        if(data!=null){
            node=new TreeNode(data);
            node.leftChild=createBinaryTree(inputList);
            node.rightChild=createBinaryTree(inputList);
        }
        return node;
    }

    public static void preOrderTraverse(TreeNode node){
        if(node==null){
            return;
        }
        System.out.println(node.data);
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    }

    public static void inOrderTraverse(TreeNode node){
        if(node==null){
            return;
        }
        inOrderTraverse(node.leftChild);
        System.out.println(node.data);
        inOrderTraverse(node.rightChild);
    }

    public static void postOrderTraverse(TreeNode node){
        if(node==null){
            return;
        }
        postOrderTraverse(node.leftChild);
        postOrderTraverse(node.rightChild);
        System.out.println(node.data);
    }

    public static void test1(){
        LinkedList<Integer> inputList=new LinkedList<>(Arrays.asList(new Integer[]{3,2,9,null,null,10,null,null,8,null,4}));
        TreeNode treeNode=createBinaryTree(inputList);
        System.out.println("preOrderTraverse");
        preOrderTraverse(treeNode);
        System.out.println("inOrderTraverse");
        inOrderTraverse(treeNode);
        System.out.println("postOrderTraverse");
        postOrderTraverse(treeNode);
    }
}
