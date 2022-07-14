package placement.prep;

public class LinkedListCycleDetection {
    // Floyd's Algorithm :: slow and fast pointers!

    private static class Node {
        int data;
        Node next;

        Node (int data) {
            this.data = data;
        }
    }

    private static boolean hasCycle (Node head) {
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n2.next = n2;

        System.out.println(hasCycle(n1));
    }
}
