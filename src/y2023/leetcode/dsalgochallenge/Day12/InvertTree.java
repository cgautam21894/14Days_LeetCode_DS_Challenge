package y2023.leetcode.dsalgochallenge.Day12;


import java.util.*;

public class InvertTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        InvertTree obj = new InvertTree();
        //   obj.invertTreeRecustion(root);
        System.out.println("path sum: " + obj.hasPathSumRecursion(root, 21));
    }

    public TreeNode invertTreeRecustion(TreeNode root) {
        if (root == null) return root;
        invertTreeRecustion(root.left);
        invertTreeRecustion(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }

    public boolean hasPathSumRecursion(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return hasPathSumRecursion1(root, targetSum, 0);
    }

    boolean flag = false;

    boolean hasPathSumRecursion1(TreeNode node, int targetSum, int cur_sum) {
        if (node == null) {
            return false;
        }
        cur_sum += node.val;
        if (node.left == null && node.right == null && targetSum == cur_sum) {
            return true;
        }
        return hasPathSumRecursion1(node.left, targetSum, cur_sum) || hasPathSumRecursion1(node.right, targetSum, cur_sum);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(root);
        int sum = targetSum - root.val;
        stack2.push(sum);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            int cur_sum = stack2.pop();
            if (node.left == null && node.right == null && cur_sum == 0) return true;
            if (node.left != null) {
                stack1.push(node.left);
                stack2.push(cur_sum - node.left.val);
            }
            if (node.right != null) {
                stack1.push(node.right);
                stack2.push(cur_sum - node.right.val);
            }

        }
        return false;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }

        }

        return root;
    }
}
