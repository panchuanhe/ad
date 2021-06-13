package com.pch.admin;

import com.google.common.util.concurrent.RateLimiter;
import lombok.ToString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {
    //令牌桶模式
    private RateLimiter rateLimiter = RateLimiter.create(5);

    private void test1() {
        if (rateLimiter.tryAcquire(1)) {
            System.out.println("我没被限流，执行业务方法");
        } else {
            System.out.println("我被限流了");
        }
    }

    @Test
    public void test2() {
        //新建二叉树
        TreeNode node1 = new TreeNode(1, null, null);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(2, node1, node3);
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode root = new TreeNode(5, node2, node6);
        int i = test4(root);
        System.out.println(i);
    }

    //二叉树深度，多少层
    private int test4(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = test4(root.left);
        int right = test4(root.right);

        return left > right ? left + 1 : right + 1;
    }

    //最长路径
    private TreeNode test5(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int i = inStart;
        while (i <= inEnd) {
            if (preOrder[preStart] == inOrder[i]) {
                break;
            }
            i++;
        }
        if (i > inEnd) return null;
        int offset = i - inStart;
        TreeNode root = new TreeNode(preOrder[0], null, null);

        root.left = test5(preOrder, preStart + 1, preStart + offset, inOrder, inStart, i - 1);
        root.right = test5(preOrder, preStart + offset + 1, preEnd, inOrder, i + 1, inEnd);
        return root;
    }

    @Test
    public void test6() {
        int[] preOrder = new int[]{3, 9, 20, 15, 7};
        int[] inOrder = new int[]{9, 3, 15, 20, 7};
        TreeNode treeNode = test5(preOrder, 0, preOrder.length - 1,
                inOrder, 0, inOrder.length - 1);

        System.out.println(treeNode.toString());

    }


    public TreeNode test7(TreeNode l1, TreeNode l2) {
        if (l1 == null) return l1;
        if (l2 == null) return l2;

        TreeNode res = l1.val < l2.val ? l1 : l2;
        res.next = test7(res.next, l1.val >= l2.val ? l1 : l2);
        return res;
    }


    public static void main(String[] args) {
        System.out.println(321 % 10);
    }


    @ToString
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode next;

        TreeNode(int x, TreeNode left, TreeNode right) {
            this.val = x;
            this.left = left;
            this.right = right;
        }
    }
}
