package InPlaceReverse;
class Node{
    int value;
    Node next;
    public Node(int value){
        this.value = value;
        next=null;
    }
}

public class ReverseLinkedList {
    public static void main(String[] args) {
        Node head =new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        Node dummy = helper(head);
        while (dummy!=null){
            System.out.println(dummy.value);
            dummy=dummy.next;
        }
    }
    private static Node helper(Node head){
        Node curr =head ;
        Node pre=null;
        while(curr!=null ){
            Node next= curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        return pre;
    }

}
