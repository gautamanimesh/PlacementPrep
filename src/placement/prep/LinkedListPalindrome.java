package placement.prep;

public class LinkedListPalindrome {

    private static class Node {
        int data;
        Node next;

        Node (int data) {
            this.data = data;
        }
    }

    private static boolean isPalindrome (Node head) {
        if (head == null || head.next == null) return true;

        Node middleNode = findMiddle(head); // 1st half's end!
        Node secondHalfStart = reverseList(middleNode.next);

        Node firstHalfStart = head;
        while (secondHalfStart != null) {
            if (firstHalfStart.data != secondHalfStart.data) {
                return false;
            }
            firstHalfStart = firstHalfStart.next;
            secondHalfStart = secondHalfStart.next;
        }
        return true;
    }

    private static Node findMiddle (Node node) {
        // this approach finds out the first middle. (in some situations, there can be 2 middle elements.)
        Node slow = node;
        Node fast = node;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static Node reverseList (Node head) {
        if (head == null || head.next == null) return head;
        Node p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(2);
        Node n5 = new Node(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        System.out.println(isPalindrome(n1));
    }
}
