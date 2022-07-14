package placement.prep;

import java.util.ArrayList;

public class BinarySearchTree {
    /*
     * Time Complexity: O(H) // H is height of the tree.
     * Generally, in case of Binary Trees, H is log(n).
     * Left SubTree nodes are lesser than root node.
     * Right SubTree nodes are greater than root node.
     * Left & Right SubTrees are also BST with no duplicates.
     * In-order traversal of BST gives a sorted sequence. // IMP
     * BST makes search efficient.
     * Recursion solves most problems.
     */
    private static class Node {
         int data;
         Node left;
         Node right;

         public Node(int data) {
             this.data = data;
         }
     }

    private static Node insert (Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            root.left = insert(root.left,val);
        } else {
            root.right = insert(root.right,val);
        }
        return root;
    }

    private static void inorder (Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    private static boolean search (Node root, int val) {  // O(H)
         if (root == null) return false;
         if (root.data == val) return true;

         if (root.data > val) {
             return search(root.left, val);
         }
         return search(root.right, val);
    }

    /*
     * Case 1: No Child (Leaf Node) :: Delete node directly.
     * Case 2: One Child :: Delete node and replace with child node.
     * Case 3: Two Children
     :: Replace with in-order successor and delete the original in-order successor.
     * In-order successor always has either 0 or 1 child.
     */
    private static Node deleteNode (Node root, int val) {
       if (root.data > val) {
           root.left = deleteNode(root.left, val);
       } else if (root.data < val) {
           root.right = deleteNode(root.right, val);
       } else { // root.data == val
           // case 1: No children.
           if (root.left == null && root.right == null) {
               return null;
           }

           // case 2: Exactly one child.
           if (root.left == null) {
               return root.right;
           } else if (root.right == null) {
               return root.left;
           }

           // case 3: Two Children.
           Node inorderSuccessor = inorderSuccessor(root.right);
           root.data = inorderSuccessor.data;
           root.right = deleteNode(root.right, inorderSuccessor.data);
       }
       return root;
    }

    private static Node inorderSuccessor (Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    private static void printRange (Node root, int X, int Y) {
        if (root == null) return;

        // case 1: X <= root.data <= Y
        if (root.data >= X && root.data <= Y) {
            printRange(root.left, X, Y);
            System.out.print(root.data + " ");
            printRange(root.right, X, Y);
        }
        // case 2: root.data >= Y
        else if (root.data >= Y) {
            printRange(root.left, X, Y);
        }
        // case 3: root.data <= X
        else {
            printRange(root.right, X, Y);
        }
    }

    private static void printRootToLeaf (Node root, ArrayList<Integer> path) {
        if (root == null) return;
        path.add(root.data);

        // leaf nodes:
        if (root.left == null && root.right == null) {
            printPath(path);
        }
        // non-leaf nodes:
        else {
            printRootToLeaf(root.left, path);
            printRootToLeaf(root.right, path);
        }
        path.remove(path.size()-1);
    }

    private static void printPath (ArrayList<Integer> path) {
        for (int element: path) {
            System.out.print(element + "->");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] values = new int[]{8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        // Insert into BST:
        for (int node: values) {
            root = insert(root, node);
        }
        inorder(root);
        System.out.println();

        // Search in BST:
        // System.out.println(search(root, 8));

        // Delete in BST:
        // deleteNode(root, 4);
        // inorder(root);
        // System.out.println();
        // deleteNode(root, 5);
        // inorder(root);

        // search in range: [6,10] :: X = 6, Y = 10
        // printRange(root, 3, 12);

        // Root To Leaf Paths:
        // printRootToLeaf(root,new ArrayList<>());
    }
}
