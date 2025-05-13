package tree.BFS;
import java.util.*;

public class LevelAvg {
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
    public static List<List<Double>> helper(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        List<List<Double>> res = new ArrayList<>();
        while(!q.isEmpty()){
            int length = q.size();
            int summ=0;
            for(int i =0;i<length;i++){
                TreeNode curNode = q.poll();
                summ+=curNode.val;
                if(curNode.left!=null){
                    q.add(curNode.left);
                }
                if(curNode.right!=null){
                    q.add(curNode.right);
                }
            }
            Double avg=(double)summ/length;
            List<Double> temp = new ArrayList<>();
            temp.add(avg);
            res.add(temp);
        }
        return res;
    }
}
