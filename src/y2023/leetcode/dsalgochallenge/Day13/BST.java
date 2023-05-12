package y2023.leetcode.dsalgochallenge.Day13;

import java.util.*;
import static java.util.Collections.list;

public class BST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        BST obj = new BST();
        ///     obj.searchBST(root, 2);
        //  obj.insertIntoBST(root, 8);
        //   obj.isValidBST(root);
        System.out.println(obj.inorder(root));
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (temp.val == val) {
                return temp;
            }
            if (temp.val < val) {
                if (temp.right != null) stack.push(temp.right);
            } else {
                if (temp.left != null) stack.push(temp.left);
            }
        }
        return null;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode node = root;
        while (node != null) {
            if (val <= node.val && node.left == null) {
                node.left = new TreeNode(val);
                return root;
            } else if (val >= node.val && node.right == null) {
                node.right = new TreeNode(val);
                return root;
            } else {
                if (val >= node.val) {
                    node = node.right;
                } else {
                    node = node.left;
                }
            }
        }
        return root;
    }

    Stack<TreeNode> stack = new Stack<>();
    Stack<Integer> upperLimit = new Stack<>();
    Stack<Integer> lowerLimit = new Stack<>();

    void update(TreeNode root, Integer low, Integer high) {
        stack.add(root);
        upperLimit.add(high);
        lowerLimit.add(low);
    }

    public boolean isValidBST(TreeNode root) {
        Integer low = null, high = null, nodeval;
        update(root, low, high);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            low = lowerLimit.pop();
            high = upperLimit.pop();

            if (node == null) {
                continue;
            }
            nodeval = node.val;
            if (low != null && nodeval >= high) {
                return false;
            }
            if (high != null && nodeval <= low) {
                return false;
            }
            update(node.right, nodeval, high);
            update(node.left, low, nodeval);
        }
        return true;
    }

    List<Integer> inorder(TreeNode root) {
        if (root == null) {
            return null;
        }
        Integer prev = null;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            ans.add(node.val);
            if (prev != null && prev >= node.val) {
                prev = node.val;
                node = node.right;
            }
        }
        return ans;
    }

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            set.add(temp.val);
            if (set.contains(k - temp.val)) {
                return true;
            }
            if (temp.left != null) {
                stack.add(temp.left);
            }
            if (temp.right != null) {
                stack.add(temp.right);
            }
        }
        return false;
    }

    List<Integer> listArray = new ArrayList<>();

    public boolean findTarget2(TreeNode root, int k) {
        inorder(root);
        int low = 0, high = listArray.size() - 1;

        while (low <= high) {
            int sum = listArray.get(low) + listArray.get(high);
            if (sum == k) {
                return true;
            } else if (sum > k) {
                high--;
            } else {
                low++;
            }
        }


        return false;
    }
}