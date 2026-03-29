class Solution {
    public Node insertAtFront(Node head, int x) {
        Node newNode =new Node(x);
        newNode.next = head;
        return newNode;
        
    }
}