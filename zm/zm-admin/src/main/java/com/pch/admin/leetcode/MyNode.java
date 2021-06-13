package com.pch.admin.leetcode;

import lombok.Data;

@Data
public class MyNode {

    private Integer value;
    private MyNode next;

    public MyNode(Integer value, MyNode next) {
        this.value = value;
        this.next = next;
    }

    /**
     * 链表翻转
     *
     * @param head
     * @return
     */
    private static MyNode fz(MyNode head) {
        MyNode pre = null, next;
        MyNode curr = head;

        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }


    public static void main(String[] args) {
        MyNode node5 = new MyNode(5, null);
        MyNode node4 = new MyNode(4, node5);
        MyNode node3 = new MyNode(3, node4);
        MyNode node2 = new MyNode(2, node3);
        MyNode node1 = new MyNode(1, node2);

        MyNode curr = node1;
        while (curr != null) {
            System.out.println(curr.value);
            curr = curr.next;
        }

        System.out.println("链表翻转之后……");
        MyNode fz = fz(node1);
        curr = fz;
        while (curr != null) {
            System.out.println(curr.value);
            curr = curr.next;
        }


    }
}
