package placement.prep;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfNodesAtKthLevel {
    static class Node {
        int data;
        Node left;
        Node right;

        Node (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;
        public static Node buildTree (int[] nodes) {
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

    public static int sumAtLevel (Node root, int level) {
        if (root == null) return 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int counter = 0;
        int sum = 0;
        int flag = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                Node currNode = q.remove();
                size--;
                if (counter == level) {
                    flag = 1;
                    sum += currNode.data;
                } else {
                    if (currNode.left != null) q.add(currNode.left);
                    if (currNode.right != null) q.add(currNode.right);
                }
            }
            counter++;
            if (flag == 1) break;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nodes = new int[]{1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = BinaryTree.buildTree(nodes);
        System.out.println("Sum at level 2: " + sumAtLevel(root,1));
    }
}
