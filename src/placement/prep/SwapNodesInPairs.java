package placement.prep;


public class SwapNodesInPairs {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode (int val) {
            this.val = val;
        }
    }

    private static ListNode swapPairs(ListNode head) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode node = fakeHead;

        while (node.next != null && node.next.next != null) {
            ListNode first = node;
            ListNode second = node.next;
            ListNode third = node.next.next;
            first.next = third;
            second.next = third.next;
            third.next = second;
            node = second;
        }
        return fakeHead.next;
    }

    private static void printList(ListNode head) {
        if (head == null) return;

        ListNode node = head;

        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        printList(l1);
        ListNode newHead = swapPairs(l1);
        printList(newHead);
    }
}
