package com.example.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> list = new ArrayList();
        List<Integer> tmp = new ArrayList<>();
        tmp.add(root.val);
        list.add(tmp);
        parseNode(root.left, root.right, list);
        return list;
    }

    private void parseNode(TreeNode left, TreeNode right, List<List<Integer>> list) {
        if (left == null && right == null) {
            return;
        }
        //此种方案在一层中有多个节点的时候 会出问题，他本质上是处理一个节点的递归，  当到第三层以后 会有四个节点，这四个节点其实为一层
        List<Integer> tmp = new ArrayList<>();
        if (left != null) {
            tmp.add(left.val);
        }
        if (right != null) {
            tmp.add(right.val);
        }
        list.add(tmp);
        //怎么把一层中的多个节点拼接到一起呢 ？

        if (left != null) {
            parseNode(left.left, left.right, list);
        }
        if (right != null) {
            parseNode(right.left, right.right, list);
        }
    }

    /**
     * 使用队列的方式将数据循环遍历一遍
     * 当我遍历当前层节点的时候 需要记录一个数量【下一层需要遍历几次】
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderQueue(TreeNode root) {
        List<List<Integer>> list = new ArrayList();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int currentSize = queue.size();
            for (int i = 1; i <= currentSize; ++i) {
                TreeNode curNode = queue.poll();
                tmp.add(curNode.val);
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            list.add(tmp);
        }

        return list;
    }

    @Test
    public void testQueue() {
        Queue<TreeNode> queue = new LinkedList<>();
        System.out.println("over");
    }
}
