package DFS;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val=val;
    }
}
public class PathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left= new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left= new TreeNode(10);
        root.right.right= new TreeNode(5);
        System.out.println(helper(root,16));
    }

    private static boolean helper(TreeNode root,int summ){
        if(root==null){
            return false;
        }
        if(root.val==summ && root.left==null && root.right==null){
            return true;
        }
        return helper(root.left,summ-root.val) || helper(root.right,summ-root.val);
    }
}
