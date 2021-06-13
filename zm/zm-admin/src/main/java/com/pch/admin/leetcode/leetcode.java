package com.pch.admin.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

public class leetcode {



    /**
     * 找到数组中比左边都小，比右边都大的数字
     */
    @Test
    public void test() {
        Integer[] arr = new Integer[]{9, 8, 7, 3, 4, 2, 1};
        List<Integer> list = Lists.newArrayList(9, 8, 7, 3, 4, 2, 1);


        for (int i = 0; i < arr.length - 1; i++) {

            int target = arr[i];

            for (int j = i + 1; j < arr.length - 1; j++) {
                if (target <= arr[j]) {
                    list.remove(arr[i]);
                }
            }
            for (int j = 0; j < i; j++) {
                if (target >= arr[j]) {
                    list.remove(arr[i]);
                }
            }
        }
        System.out.println(JSONObject.toJSONString(list));
    }

    @Test
    public void test2() {
        // 3-2-5-6-8-1-0

        int n = 2;
        ListNode node6 = new ListNode(0, null);
        ListNode node5 = new ListNode(0, node6);
        ListNode node4 = new ListNode(0, node5);
        ListNode node3 = new ListNode(0, node4);
        ListNode node2 = new ListNode(0, node3);
        ListNode node1 = new ListNode(0, node2);
        ListNode root = new ListNode(0, node1);

        ListNode head = root;
        ListNode curr = root;

        int i = 1;

        while (curr != null) {
            i++;
            curr = curr.next;
            if (i == n) {
                break;
            }
        }

        while (curr.next != null) {
            head = head.next;
        }
    }

    /**
     * 冒泡排序
     */
    @Test
    public void test3() {
        int[] arr = new int[]{9, 3, 1, 2, 5, 4, 7};

        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tem = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tem;
                }
            }
        }

        System.out.println(JSONObject.toJSONString(arr));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9, 8, 7, 3, 4, 2, 1};
        test4(arr,0,arr.length-1);



        System.out.println(JSONObject.toJSONString(arr));
    }

    /**
     * 快排
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void test4(int[] arr, int left, int right) {
        if (left >= right){
            return;
        }

        int i = left;
        int j = right;
        int key = arr[left];

        while (i<j){
            while (arr[j]>=key && i<j){
                j--;
            }
            while (arr[i]<=key && i<j){
                i++;
            }

            if (i<j){
                int tem = arr[i];
                arr[i] = arr[j];
                arr[j] = tem;
            }
        }
        arr[left] = arr[i];
        arr[i] = key;

        test4(arr,left,i-1);
        test4(arr,i+1,right);
    }

}

class ListNode {

    int val;

    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


}
