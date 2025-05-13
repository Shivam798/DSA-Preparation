package tree.BFS;

import java.util.*;

public class LevelOrderSuccessor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left=new TreeNode(7);
        root.right=new TreeNode(1);
        root.left.left=new TreeNode(9);
        root.left.right=new TreeNode(2);
        root.right.left=new TreeNode(10);
        root.right.right=new TreeNode(5);
        int key=5;
        TreeNode successor = helper(root,key);
        if (successor != null) {
            System.out.println("Level order successor is: " + successor.val);
        } else {
            System.out.println("Level order successor not found");
        }
    }
    private static TreeNode helper(TreeNode root , int key){
        if(root==null)return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curnode= q.poll();
            if(curnode.left!=null) q.add(curnode.left);
            if(curnode.right!=null) q.add(curnode.right);
            if(curnode.val==key) break;
        }
        return !q.isEmpty()?q.peek():null;
    }
}
