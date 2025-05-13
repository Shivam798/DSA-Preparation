package tree.BFS;

import java.util.*;

public class RightView {
    public static void main(String[] args) {
        TreeNode root =new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
        System.out.println(helper(root));
    }
    private static List<Integer> helper(TreeNode root){
        if(root==null){
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> res= new ArrayList<>();
        while(!q.isEmpty()){
            int length = q.size();
            for(int i=0;i<length;i++){
                TreeNode curNode = q.poll();
                //for left view change this condition to i==0
                if(i==length-1){
                    res.add(curNode.val);
                }
                if(curNode.left!=null) q.add(curNode.left);
                if(curNode.right!=null) q.add(curNode.right);
            }
        }
        return res;
    }
}
