package FastAndSlow;
class ListNode {
    int value;
    ListNode next;
    ListNode(int value){
        this.value=value;
        next=null;
    }
}

public class CycleInLinkedList
{
    public static void main(String[] args) {
       ListNode head = new ListNode(1);
       head.next=new ListNode(2);
       head.next.next=new ListNode(3);
       head.next.next.next=new ListNode(4);
       head.next.next.next.next=new ListNode(5);
       head.next.next.next.next.next=new ListNode(6);
       head.next.next.next.next.next.next=head.next.next;
       detectAndRemoveCycle(head);

    }
    public static boolean hasCycle(ListNode head){
        boolean res =false;
        ListNode slow= head;
        ListNode fast= head;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                res=true;
                break;
            }
        }
        return res;
    }

    public static int cycleLength(ListNode head) {
        int l =0;
        ListNode slow= head;
        ListNode fast= head;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                slow= slow.next;
                while(slow!=fast){
                    slow=slow.next;
                    l+=1;
                }
                break;
            }
        }
        return l != 0 ? l + 1 : 0;
    }

    public static ListNode findCycleStart(ListNode head) {
        ListNode slow= head;
        ListNode fast= head;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                slow= head;
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                break;
            }
        }
        return slow;
    }

    public static void detectAndRemoveCycle(ListNode head) {
        ListNode slow= head;
        ListNode fast= head;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                slow= head;
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                break;
            }
        }
        while(fast.next!=slow){
            fast=fast.next;
        }
        fast.next=null;
    while (null != head){
            System.out.println(head.value);
            head=head.next;
        }
    }

}
