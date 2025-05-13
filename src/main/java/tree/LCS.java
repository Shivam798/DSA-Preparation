package tree;

public class LCS {
    public static void main(String[] args) {
        // Constructing the BST
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        // Define nodes to find LCA
        TreeNode p = root.left;             // Node with value 2
        TreeNode q = root.left.right;       // Node with value 4

        // Find LCA
        TreeNode lca = lowestCommonAncestor(root, p, q);

        // Output
        if (lca != null) {
            System.out.println("LCA of " + p.val + " and " + q.val + " is: " + lca.val);
        } else {
            System.out.println("LCA not found.");
        }
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        // If both p and q are less than root → go left
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        // If both p and q are greater than root → go right
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        // If they split at root (one left, one right), root is LCA
        return root;
    }
}
