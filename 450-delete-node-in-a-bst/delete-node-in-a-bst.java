class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (root.val == key) {
            return helper(root);
        }

        TreeNode dummyNode = root;

        while (root != null) {
            if (root.val > key) {
                if (root.left != null && root.left.val == key) {
                    root.left = helper(root.left);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                if (root.right != null && root.right.val == key) {
                    root.right = helper(root.right);
                    break;
                } else {
                    root = root.right;
                }
            }
        }

        return dummyNode;
    }

    public static TreeNode helper(TreeNode root) {
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        } else {
            TreeNode right = root.right;
            TreeNode lastRight = lastRight(root.left);

            lastRight.right = right;

            return root.left;
        }
    }

    public static TreeNode lastRight(TreeNode root) {
        if (root.right == null) {
            return root;
        }

        return lastRight(root.right);
    }
}