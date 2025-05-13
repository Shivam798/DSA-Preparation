package tree.DFS;

import java.util.*;


public class AllPathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left= new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.right= new TreeNode(2);
        root.left.left.left= new TreeNode(7);
        root.right.left= new TreeNode(13);
        root.right.right= new TreeNode(4);
        System.out.println(helper(root,22));
    }
    private static List<List<Integer>> helper (TreeNode root , int summ){
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        hfunc(root,summ,temp,res);
        return res;

    }

    private static void hfunc(TreeNode root, int summ, List<Integer> temp, List<List<Integer>> res) {

        if(root==null){
            return ;
        }
        temp.add(root.val);
        if(root.val==summ & root.left==null && root.right==null){
            res.add(new ArrayList<>(temp));
        }
        hfunc(root.left,summ-root.val,temp,res);
        hfunc(root.right,summ-root.val,temp,res);
        temp.remove(temp.size()-1);
    }
}
