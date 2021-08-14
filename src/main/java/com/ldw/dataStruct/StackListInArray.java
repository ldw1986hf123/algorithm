package com.ldw.dataStruct;

/**
 * 用数组实现栈
 */
public class StackListInArray {
    private int size;
    private Integer[] myList = new Integer[10];

    public void push(int element) {
        if (myList.length < size) {
            //需要扩容
        } else {
            myList[size] = element;
        }
        size++;
    }

    public int pop() throws Exception {
        int element;
        if (size > 0) {
            element = myList[size - 1];
            size--;
        }
        else {
            throw new Exception();
        }
        return element;
    }


    public static void main(String[] args) throws Exception {
        StackListInArray stack = new StackListInArray();
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
