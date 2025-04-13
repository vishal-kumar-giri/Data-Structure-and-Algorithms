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
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node dummy = new Node(0); // Corrected spelling
            Node current = dummy; // To keep track of the current node in the dummy level
            
            while (size-- > 0) {
                Node node = queue.remove();
                current.next = node; // Connect the current node to the next node
                current = current.next; // Move to the next node in the dummy level
                
                if (node.left != null) queue.add(node.left); // Corrected to node.left
                if (node.right != null) queue.add(node.right); // Corrected to node.right
            }
        }
        return root; // Moved outside the while loop
    }
}
