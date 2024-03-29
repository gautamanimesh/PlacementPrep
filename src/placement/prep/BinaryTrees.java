package placement.prep;


import java.util.LinkedList;
import java.util.Queue;

public class BinaryTrees {
    // Time Complexity: O(n) | where, n is the number of nodes.
    static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    static class BinaryTree {
        static int idx = -1;
        public static Node buildTree (int[] nodes) { // nodes has values in preorder
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static void preorder (Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder (Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static void postorder (Node root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void levelOrder (Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    public static int countNodes (Node root) {
        if (root == null) return 0;
        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);

        return leftNodes + rightNodes + 1;
    }

    public static int sumOfNodes (Node root) {
        if (root == null) return 0;
        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);

        return leftSum + rightSum + root.data;
    }

    public static int heightOfTree (Node root) {
        if (root == null) return 0;
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    static class TreeInfo {
        int ht;
        int diam;

        TreeInfo (int ht, int diam) {
            this.ht = ht;
            this.diam = diam;
        }
    }

    public static TreeInfo diameterOfTree(Node root) {
        if (root == null) return new TreeInfo(0,0);

        TreeInfo left = diameterOfTree(root.left);
        TreeInfo right = diameterOfTree(root.right);

        int myHeight = Math.max(left.ht, right.ht) + 1;

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht + right.ht + 1;

        int myDiam = Math.max(Math.max(diam1, diam2), diam3);
        return new TreeInfo(myHeight, myDiam);
    }

    public static void printLeafNodes (Node root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) System.out.print(root.data + " ");
        if (root.left != null) printLeafNodes(root.left);
        if (root.right != null) printLeafNodes(root.right);
    }

    public static void main(String[] args) {
        int[] nodes = new int[]{1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = BinaryTree.buildTree(nodes);
        System.out.print("Preorder: ");
        preorder(root);
        System.out.println("");
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println("");
        System.out.print("Postorder: ");
        postorder(root);
        System.out.println("");
        System.out.println("LevelOrder: ");
        levelOrder(root);
        System.out.print("Count: " + countNodes(root));
        System.out.println("");
        System.out.print("Sum: " + sumOfNodes(root));
        System.out.println("");
        System.out.print("Height: " + heightOfTree(root));
        System.out.println("");
        System.out.print("Diameter: " + diameterOfTree(root).diam);
        System.out.println("");
        System.out.print("Leaf Nodes: ");
        printLeafNodes(root);
    }
}
