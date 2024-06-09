package InPlaceReverse;

public class ReverseFromAtoB {
    public static void main(String[] args) {
        Node head= new Node(1);
        head.next= new Node(2);
        head.next.next= new Node(3);
        head.next.next.next= new Node(4);
        head.next.next.next.next= new Node(5);
        int start=2;
        int end= 4;
        Node newHead = helper(head,start,end);
        printList(newHead);
    }

    private static Node helper(Node head,int a,int b){
        if(a==b){
            return head;
        }
        Node curr = head ;
        Node previous =null;
        int i=0;
        while(curr!=null && i<a-1){
            previous=curr;
            curr=curr.next;
            i++;
        }
        Node lastNodeFrom =previous;
        Node reverseStartNode=curr;
        i=0;
        while(curr!=null && i<b-a+1){
            Node next=curr.next;
            curr.next=previous;
            previous=curr;
            curr=next;
            i++;
        }
        if(lastNodeFrom!=null){
            lastNodeFrom.next=previous;
        }
        else {
            head=previous;
        }
        reverseStartNode.next=curr;
        return head;
    }

    private static void printList(Node head){
        while(head!=null){
            System.out.println(head.value);
            head=head.next;
        }
    }
}
