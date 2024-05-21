package FastAndSlow;

import java.util.List;

public class PalindromeLinklist {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));
    }

    private static boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
        ListNode middle = getMiddle(head);
        ListNode secondHalfStart = reverseLinkList(middle.next);
        boolean result =  compareLinkList(head,secondHalfStart);
        middle.next=reverseLinkList(secondHalfStart);
        return result;
    }

    private static boolean compareLinkList(ListNode head, ListNode reverseHead) {
        while(reverseHead!=null){
            if(reverseHead.value!=head.value){
                return false;
            }
            reverseHead=reverseHead.next;
            head=head.next;
        }
        return true;
    }

    private static ListNode reverseLinkList(ListNode head) {
        ListNode curr = head;
        ListNode pre =null;
        while (curr!=null){
            ListNode next = curr.next;
            curr.next= pre;
            pre = curr;
            curr=next;
        }
        return pre;
    }

    private static ListNode getMiddle(ListNode head) {
        ListNode slow= head ;
        ListNode fast= head ;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast= fast.next.next;
        }
        return slow;
    }
}
