package DoublyLinkedList;

/**
 *
 * @author Admin
 */
public class Node {
    Student info;
    Node next, prev;

    public Node() {
        info = null;
        prev = next = null;
    }

    public Node(Student info, Node next, Node prev) {
        this.info = info;
        this.next = next;
        this.prev = prev;
    }

    public Node(Student info){
        this.info = info;
        this.next = null;
        this.prev = null;
    }

    @Override
    public String toString() {
        return info.toString();
    }
    
    
}
