package DoublyLinkedList;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class DoublyLinkedList {
    Node head, tail;
    
    public DoublyLinkedList() {
        head = tail = null;
    }
    
    public boolean isEmpty(){
        return (head == null);
    }
    
    public void traverseFromHead(){
        if(isEmpty()){
            System.out.println("Empty list.");
        }else{
            System.out.println("-------------------------------");
            Node tmp = head;
            while(tmp != null){
                System.out.println(tmp);
                tmp = tmp.next;
            }
        }   
    }
    
    public void traverseFromTail(){
        if(isEmpty()){
            System.out.println("Empty list.");
        }else{
            System.out.println("---------------------------------");
            Node tmp = tail;
            while(tmp != null){
                System.out.println(tmp);
                tmp = tmp.prev;
            }
        }
    }
    
    // If same roll number --> no add
    public void addFirst(Student s){
        if(s == null || search(s.getRollNumber()) != null){
            return;
        }
        Node newNode = new Node(s);
        newNode.next = head;
        if(head == null){
            tail = newNode;
        }else{
            head.prev = newNode;
        }
        head = newNode;
    }
    
    public void addLast(Student s){
        if(s == null || search(s.getRollNumber()) != null){
            return;
        }
        Node newNode = new Node(s);
        newNode.prev = tail;
        if(tail == null){
            head = newNode;
        }else{
            tail.next = newNode;
        }
        tail = newNode;
    }
    
    public void removeFirst(){
        if(isEmpty()){
            return;
        }
        head = head.next;
        if(head == null){
            tail = null;
        }else{
            head.prev = null;
        }
    }
    
    public void removeLast(){
        if(isEmpty()){
            return;
        }
        tail = tail.prev;
        if(tail == null){
            head = null;
        }else{
            tail.next = null;
        }
    }

    public void reverse(){
        Node current = head;
        while(current != null){
            Node next = current.next;
            current.next = current.prev;
            current.prev = next;
            current = next;
        }

        Node oldHead = head;
        head = tail;
        tail = oldHead;
    }
    
    public Student search(int rollNumber){
        Node current = head;
        while(current != null){
            if(current.info.getRollNumber() == rollNumber){
                return current.info;
            }
            current = current.next;
        }
        return null;
    }
    
    public ArrayList<Student> search(String name){
        ArrayList<Student> result = new ArrayList<>();
        if(name == null){
            return result;
        }
        Node current = head;
        while(current != null){
            if(name.equalsIgnoreCase(current.info.getName())){
                result.add(current.info);
            }
            current = current.next;
        }
        return result;
    }
}
