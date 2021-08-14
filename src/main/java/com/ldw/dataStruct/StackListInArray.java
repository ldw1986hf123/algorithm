package com.ldw.dataStruct;

/**
 * 用数组实现栈
 */
public class StackListInArray {
    private int max;
    private int[] myList;

    private StackListInArray(int max) {
        this.max = max;
        myList = new int[max];
    }

    public void push(int element) {
        int size=myList.length-1;
        if (myList.length > max) {
            //需要扩容
        } else {
            myList[size] = element;
        }
        size++;
    }

    public int pop() {
        int size=myList.length-1;
        int element = myList[size];
        size--;
        return element;
    }


    public static void main(String[] args) {
        StackListInArray stack=new StackListInArray(10);
        stack.push(0);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(1);


        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
