package y2023.leetcode.dsalgochallenge_level1.Day10;

import java.util.*;

public class PreorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        PreorderTraversal obj = new PreorderTraversal();
        obj.inorder(root);
        obj.maxDepthUsingIteration2(root);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int counter = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int noOfNodes = queue.size();
        while (!queue.isEmpty()) {
            for (int i = 0; i < noOfNodes; i++) {
                TreeNode temp = queue.remove();
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            counter++;
        }

        return counter;
    }


    void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);

    }

    List<Integer> preorderItr(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            ans.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }

        return ans;
    }

    List<Integer> inorderItr(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            ans.add(cur.val);
            cur = cur.right;

        }

        return ans;
    }

    List<Integer> postorderItr(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        stack.push(root);
        TreeNode prev = new TreeNode(-1);

        while (!stack.isEmpty()) {
            TreeNode temp = stack.peek();
            if (temp.right == null && temp.left == null || temp.right == prev || temp.left == prev) {
                prev = stack.pop();
                ans.add(temp.val);
                continue;
            }
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }

        return ans;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return ans;
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            ans.add(new ArrayList<>());
            int noOfNodes = queue.size();
            for (int i = 0; i < noOfNodes; i++) {
                TreeNode temp = queue.remove();
                ans.get(level).add(temp.val);
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            level++;
        }

        return ans;
    }

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> levelOrderUsingRecursion(TreeNode root) {
        if (root == null) return ans;
        levelrec(root, 0);
        return ans;
    }

    public int maxDepthUsingIteration2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> depths = new LinkedList<>();
        if (root == null) return 0;

        stack.add(root);
        depths.add(1);

        int depth = 0, current_depth = 0;
        while (!stack.isEmpty()) {
            root = stack.pollLast();
            current_depth = depths.pollLast();
            if (root != null) {
                depth = Math.max(depth, current_depth);
                stack.add(root.left);
                stack.add(root.right);
                depths.add(current_depth + 1);
                depths.add(current_depth + 1);
            }
        }
        return depth;
    }

    void levelrec(TreeNode node, int level) {
        if (level == ans.size()) {
            ans.add(new ArrayList<>());
        }
        ans.get(level).add(node.val);
        if (node.left != null) {
            levelrec(node.left, level + 1);
        }

        if (node.right != null) {
            levelrec(node.right, level + 1);
        }

    }


    public List<Integer> preorderTraversal(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.poll();

        while (!queue.isEmpty()) {
            System.out.println(root.val);
            if (root.left != null) {

                root = root.left;
            }

            if (root.right != null) {
                System.out.println(root.right);
                root = root.right;
            }

        }
        return null;
    }
}
