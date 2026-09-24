package CSD201.SinglyLinkedList;

public class Node {
    int info;
    Node next;

    public Node(int info){
        this.info = info;
        this.next = null;
    }

    public Node(int info, Node next){
        this.info = info;
        this.next = next;
    }

    @Override 
    public String toString(){
        return info + " ";
    }
}
