package tree.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {
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
    private static Integer helper(TreeNode root ){
        Queue<TreeNode> q= new LinkedList();
        q.add(root);
        int maxDepth=0;
        while(!q.isEmpty()){
            int length = q.size();
            maxDepth+=1;
            for(int i =0;i<length;i++){
                TreeNode curnode = q.poll();
                if(curnode.left!=null){
                    q.add(curnode.left);
                }
                if(curnode.right!=null){
                    q.add(curnode.right);
                }
            }
        }
        return maxDepth;
    }
}
