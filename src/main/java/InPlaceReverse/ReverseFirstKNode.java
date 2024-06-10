package InPlaceReverse;

import static InPlaceReverse.ReverseFromAtoB.printList;

public class ReverseFirstKNode {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        int a=1;
        int b=3;//b is K here
        Node head1=helper(head,a,b);
        printList(head1);
    }
    private static Node helper(Node head ,int a,int b){
        Node current = head;
        Node previous = null;
        int i=0;
        while(current!=null && i<a-1){
            previous=current;
            current=current.next;
            i+=1;
        }
        Node LastNodeFromFirstPart=previous;
        Node LastNdoeOfSubList= current;
        i=0;
        while(current!=null && i<b-a+1){
            Node next=current.next;
            current.next=previous;
            previous=current;
            current=next;
            i+=1;
        }
        if(LastNodeFromFirstPart!=null){
            LastNodeFromFirstPart.next=previous;
        }else{
            head= previous;
        }
        LastNdoeOfSubList.next=current;
        return head;
    }
}
