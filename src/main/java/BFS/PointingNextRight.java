package BFS;
//Whole different concept than other BFS questions.
class Nodep{
    int val;
    Nodep left;
    Nodep right;
    Nodep next;
    public  Nodep(int val){
        this.val=val;
    }
}

public class PointingNextRight {
    public static void main(String[] args) {
        Nodep root= new Nodep(1);
        root.left=new Nodep(2);
        root.right = new Nodep(3);
        root.left.left = new Nodep(4);
        root.left.right = new Nodep(5);
        root.right.left = new Nodep(6);
        root.right.right = new Nodep(7);
        root = helper(root);
        System.out.println("Level 1: " + root.val + " -> " + (root.next != null ? root.next.val : "null"));
        System.out.println("Level 2: " + root.left.val + " -> " + root.left.next.val + " -> " + (root.left.next.next != null ? root.left.next.next.val : "null"));
        System.out.println("Level 3: " + root.left.left.val + " -> " + root.left.left.next.val + " -> " + root.left.left.next.next.val + " -> " + root.left.left.next.next.next.val + " -> " + (root.left.left.next.next.next.next != null ? root.left.left.next.next.next.next.val : "null"));
    }
    private static Nodep helper(Nodep root){
        if(root==null){
            return null;
        }
        Nodep leftmost = root;
        while(leftmost.left!=null){
            Nodep head= leftmost;
            while(head!=null){
                head.left.next=head.right;
                if(head.next!=null){
                    head.right.next=head.next.left;
                }
                head=head.next;
            }
            leftmost=leftmost.left;
        }
        return root;
    }
}
