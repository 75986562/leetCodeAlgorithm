package com.zh.leetcode.code;


import com.alibaba.fastjson.JSONObject;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 */
public class Q111 {


    public static void main(String[] args) {
//        3,9,20,null,null,15,7
        TreeNode t7 = new TreeNode(7);
        TreeNode t15 = new TreeNode(15);
        TreeNode t20 = new TreeNode(20, t15, t7);
        TreeNode t9 = new TreeNode(9);
        TreeNode root = new TreeNode(3, t9, t20);
        System.out.println(minDepth(root));
    }

    public static int minDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }

//    public static TreeNode fillTreeNode(Integer [] a){
//        TreeNode root = new TreeNode();
//        root.val=a[0];
//        for (int i = 1; i < a.length; i++) {
//            TreeNode root2 = root;
//            TreeNode temp = new TreeNode();
//            temp.val = a[i];
//            if(i%2 == 1){
//                root2.left=temp;
//            }else {
//                root2.right=temp;
//            }
//            root = root2;
//        }
//        System.out.println(root.toString());
//        return root;
//    }


    public static class TreeNode {
        Integer val;
        TreeNode left;
        TreeNode right;

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }

        TreeNode() {
        }

        TreeNode(Integer val) {
            this.val = val;
        }

        TreeNode(Integer val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
