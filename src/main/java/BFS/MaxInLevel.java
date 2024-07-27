package BFS;

import java.util.*;

public class MaxInLevel {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left=new TreeNode(7);
        root.right=new TreeNode(1);
        root.left.left=new TreeNode(9);
        root.left.right=new TreeNode(2);
        root.right.left=new TreeNode(10);
        root.right.right=new TreeNode(5);
        System.out.println(helper(root));
    }
    public static List<List<Integer>> helper(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        List<List<Integer>> res = new ArrayList<>();

        while(!q.isEmpty()){
            int length = q.size();
            int maxvalue=0;
            List<Integer> temp = new ArrayList<>();
            for(int i =0;i<length;i++){
                TreeNode curNode = q.poll();
                maxvalue = Math.max(maxvalue,curNode.val);
                if(curNode.left!=null){
                    q.add(curNode.left);
                }
                if(curNode.right!=null){
                    q.add(curNode.right);
                }
            }
            res.add(Arrays.asList(maxvalue));
        }
        return res;
    }
}
