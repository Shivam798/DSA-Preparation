package tree.BFS;

import java.util.*;

public class Zigzag {
    public static void main(String[] args) {
        TreeNode root =new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
        List<List<Integer>> res = helper(root);
        System.out.println(res);
    }
    private static List<List<Integer>> helper (TreeNode root){
        List<List<Integer>> res= new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        boolean flag =true;
        while(!q.isEmpty()){
            int length = q.size();
            LinkedList<Integer> temp = new LinkedList<>();
            for(int i =0 ;i<length;i++){
                TreeNode curNode = q.poll();
                if(flag){
                    temp.addLast(curNode.val);
                }else{
                    temp.addFirst(curNode.val);
                }
                if(curNode.left!=null){
                    q.add(curNode.left);
                }
                if(curNode.right!=null){
                    q.add(curNode.right);
                }
            }
            res.add(temp);
            flag=!flag;
        }
        return res;
    }
}
