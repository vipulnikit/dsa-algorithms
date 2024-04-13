// Given a linked list check if cycle exits. If yes, print the start of cycle and break it.

public class FloydCycleDetection {
    // TC: O(n) | SC:O(1)
    void breakLoop(ListNode A) {
        if (A == null || A.next == null)
            return;
        ListNode slow = A.next, fast = A.next.next;
        while (slow != fast && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow != fast)   // if cycle doesn't exist, return.
            return;
        slow = A;
        ListNode prevFast = fast;
        while (slow != fast) {
            prevFast = fast;
            slow = slow.next;
            fast = fast.next;
        }
        System.out.println("Start of cycle: " + fast.data);
        prevFast.next = null;   // breaking cycle
    }
}
