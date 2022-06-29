package placement.prep;

public class MergeSortedLinkedLists {
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

    public static Node mergeLists (Node A, Node B) {
        if (A == null) return B;
        if (B == null) return A;

        if (A.data <= B.data) {
            A.next = mergeLists(A.next, B);
            return A;
        } else {
            B.next = mergeLists(A, B.next);
            return B;
        }
    }

    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(3);
        Node n3 = new Node(5);
        Node n4 = new Node(7);
        Node n5 = new Node(9);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);

        Node N1 = new Node(2);
        Node N2 = new Node(4);
        Node N3 = new Node(6);
        Node N4 = new Node(8);
        Node N5 = new Node(10);

        N1.setNext(N2);
        N2.setNext(N3);
        N3.setNext(N4);
        N4.setNext(N5);

        printLinkedList(n1);
        System.out.println("");
        printLinkedList(N1);
        System.out.println("");
        Node mergedList = mergeLists(n1, N1);
        printLinkedList(mergedList);
    }
}
