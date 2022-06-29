package placement.prep;

public class LinkedListReversal {
    static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static void printLinkedList (Node node) {
        Node temp = node;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.getNext();
        }
    }

    public static Node reverseLinkedList (Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node p = reverseLinkedList(node.next);
        node.next.next = node;
        node.next = null;
        return p;
    }

    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);

        printLinkedList(n1);
        Node reversed = reverseLinkedList(n1);
        System.out.println("");
        printLinkedList(reversed);
    }
}
