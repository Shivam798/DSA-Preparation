package tree.BFS;
import java.util.*;

public class ReverseOrder {
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
    private static List<List<Integer>> helper(TreeNode root ){
        LinkedList<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int length = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<length;i++){
                TreeNode curNode = q.poll();
                if(curNode.left!=null){
                    TreeNode left = curNode.left;
                    q.add(left);
                }
                if(curNode.right!=null){
                    TreeNode right = curNode.right;
                    q.add(right);
                }
                temp.add(curNode.val);
            }
            res.addFirst(temp);
        }
        return res;
    }
}
