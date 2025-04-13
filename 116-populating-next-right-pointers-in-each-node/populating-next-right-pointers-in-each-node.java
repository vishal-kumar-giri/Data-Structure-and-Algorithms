/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Node current = root;
        while (current != null && current.left != null) {
            Node n = current;
            while (n != null) {
                n.left.next = n.right; // Connect left child to right child
                if (n.next != null) {
                    n.right.next = n.next.left; // Connect right child to the next left child
                }
                n = n.next; // Move to the next node in the current level
            }
            current = current.left; // Move down to the next level
        }
        return root; 
    }
}
