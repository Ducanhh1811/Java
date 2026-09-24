package Stack;

public class Node {
    Object info;
    Node next;
    
    public Node(){
        this.info = null;
        this.next = null;
    }
    
    public Node(Object x, Node y){
        this.info = x;
        this.next = y;
    }
    
    public Node(Object x){
        this.info = x;
        this.next = null;
    }

    @Override
    public String toString() {
        return info + ", ";
    }
}
