package FastAndSlow;

import java.util.List;

public class RearrangeLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next=new ListNode(2);
        head.next.next= new ListNode(3);
        head.next.next.next= new ListNode(4);
        head.next.next.next.next= new ListNode(5);
        head.next.next.next.next.next= new ListNode(6);
        rearrangeList(head);
        while(head!=null){
            System.out.print(head.value+" ");
            head= head.next;
        }
    }
    private static void rearrangeList(ListNode head){
        if (head == null || head.next == null) return;
        ListNode middle = getMiddleNode(head);
        ListNode secondHalfHead = reveresedHalfHead(middle.next);
        middle.next=null;
        mixLinkedList(secondHalfHead,head);
    }

    private static void mixLinkedList(ListNode h2, ListNode h1) {
        while(h2!=null){
            ListNode next1 = h1.next;
            ListNode next2 = h2.next;
            h1.next=h2;
            h2.next=next1;
            h1=next1;
            h2=next2;
        }
    }

    private static ListNode reveresedHalfHead(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr!=null){
            ListNode next = curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        return pre;
    }

    private static ListNode getMiddleNode(ListNode head) {
        ListNode slow= head;
        ListNode fast= head;
        while(fast!=null && fast.next!=null){
           slow=slow.next;
           fast=fast.next.next;
        }

        return slow;
    }
}
