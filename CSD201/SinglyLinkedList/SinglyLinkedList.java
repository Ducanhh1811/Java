package CSD201.SinglyLinkedList;

public class SinglyLinkedList {
    Node head, tail;

    public SinglyLinkedList(){
        head = tail = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void traverse(){
        if(isEmpty()){
            System.out.println("Empty list.");
        }else{

        }
    }

    public void addFirst(){
        
    }

    public void reverse(){
        Node previous = null;
        Node current = head;
        tail = head;

        while(current != null){
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        head = previous;
    }
}
