package tree.BFS;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val=val;
    }
}

public class SimpleBFS {
    public static void main(String[] args) {
        TreeNode root =new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
        helper(root);
    }

    public static void helper(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            TreeNode curnode = q.poll();
            System.out.println(curnode.val);
            if(curnode.left!=null){
                q.add(curnode.left);
            }
            if(curnode.right!=null){
                q.add(curnode.right);
            }
        }
    }
}
