package Queue;

public class Node {
    Object info;
    Node next;

    public Node() {
        this.info = null;
        this.next = null;
    }

    public Node(Object info) {
        this.info = info;
        this.next = null;
    }

    public Node(Object info, Node next) {
        this.info = info;
        this.next = next;
    }

    @Override
    public String toString() {
        return info + ", ";
    }
}