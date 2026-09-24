/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Queue;

/**
 *
 * @author Admin
 */
public class myQueue {

    private Node first;
    private Node last;

    public myQueue() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void clear() {
        first = null;
        last = null;
    }

    public void enqueue(Object value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
    }

    public Object peek() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        return first.info;
    }

    public Object dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        Node tmp = first;
        first = first.next;
        tmp.next = null;
        if (first == null) {
            last = null;
        }
        return tmp.info;
    }

    public void traverse() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            Node current = first;
            while (current != null) {
                System.out.println(current);
                current = current.next;
            }
        }
        System.out.println();
    }
}
