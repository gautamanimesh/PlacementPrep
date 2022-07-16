package placement.prep;

public class RemoveNthFromLast {

    private static class Node {
        int data;
        Node next;

        Node (int data) {
            this.data = data;
        }
    }

    private static Node removeNthFromLast (Node head, int n) {
        if (head.next == null) {
            return null;
        }

        int size = 0;
        Node currNode = head;
        while (currNode != null) {
            currNode = currNode.next;
            size++;
        }

        if (n == size) {
            return head.next;
        }

        if (n == 0) return head;

        int prevNodeIndex = size - n;
        Node prevNode = head;
        int i = 1;
        while (i < prevNodeIndex) {
            prevNode = prevNode.next;
            i++;
        }
        prevNode.next = prevNode.next.next;
        return head;
    }

    private static void printList (Node head) {
        if (head == null) return;
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.println();
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

        printList(n1);
        Node head = removeNthFromLast(n1,2);
        printList(head);
    }
}
