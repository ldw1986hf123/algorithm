package com.ldw.algorithm;


/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class ListNodeSolution {

    public static void main(String[] args) {
        ListNodeSolution solution = new ListNodeSolution();
        ListNode head = solution.initList();
//        solution.printList(head);
        solution.reverseList(head);
    }

    /**
     * 输入一个链表，反转链表后，输出新链表的表头。
     * 递推法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        ListNode pre = null;
        ListNode next = null;
        while (current!= null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        //最终pre是变成了头结点
        printList(pre);
        return current;
    }

    public ListNode initList() {
        ListNode head = new ListNode(0);
        ListNode currenctNode = null;
        for (int i = 1; i < 5; i++) {
            ListNode node = new ListNode(i);
            if (i == 1) {
                head.next = node;
            } else {
                currenctNode.next = node;
            }
            currenctNode = node;
        }
        return head;
    }

    private void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}