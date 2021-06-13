package com.pch.admin.iteration;

import lombok.Data;

@Data
public class TreeNode {

    private Integer val;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(Integer val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        //造一棵树
        TreeNode treeNode6 = new TreeNode(6, null, null);
        TreeNode treeNode7 = new TreeNode(7, null, null);
        TreeNode treeNode5 = new TreeNode(5, treeNode6, treeNode7);
        TreeNode treeNode4 = new TreeNode(4, null, null);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode5);
        TreeNode treeNode3 = new TreeNode(3, null, null);
        TreeNode root = new TreeNode(1, treeNode2, treeNode3);


        //前序遍历
        gzy(root);
        //中序遍历
//        zgy(root);
//        zyg(root);
     /*   List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        //打乱数组
        Collections.shuffle(list);
        System.out.println(JSONObject.toJSONString(list));*/

    }

    /**
     * 根左右
     */
    private static void gzy(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        gzy(node.left);
        gzy(node.right);
    }

    /**
     * 左根右
     */
    private static void zgy(TreeNode node) {
        if (node == null) {
            return;
        }
        zgy(node.left);
        System.out.println(node.val);
        zgy(node.right);
    }

    /**
     * 左右根
     */
    private static void zyg(TreeNode node) {
        if (node == null) {
            return;
        }
        zyg(node.left);
        zyg(node.right);
        System.out.println(node.val);
    }
}
