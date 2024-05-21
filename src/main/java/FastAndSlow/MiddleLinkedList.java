package FastAndSlow;


import java.sql.SQLOutput;

public class MiddleLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next= new ListNode(2);
        head.next.next= new ListNode(3);
        head.next.next.next= new ListNode(4);
        head.next.next.next.next= new ListNode(5);
        head.next.next.next.next.next= new ListNode(6);
        ListNode res= middleNode(head);
        System.out.println(res.value);
    }

    private static ListNode middleNode(ListNode head) {
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast= fast.next.next;
        }
        return slow;
    }
}
