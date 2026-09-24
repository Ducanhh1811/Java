package Stack;

import java.util.EmptyStackException;

/**
 *
 * @author Admin
 */
public class MyStack {

    private Node top;
    private int size;

    public MyStack() {
        top = null;
        size = 0;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void clear() {
        while(!isEmpty()){
            pop();
        }
    }

    public void push(Object value) {
        Node newNode = new Node(value, top);
        top = newNode;
        size++;
    }

    public Object pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            Node tmp = top;
            top = top.next;
            tmp.next = null;
            return tmp.info;
        }
    }

    public Object top() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return top.info;
    }

    public void traverse() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        }else{
            System.out.println("Traverse from top to bottom");
            Node tmp = top;
            while(tmp != null){
                System.out.println(tmp);
                tmp = tmp.next;
            }
        }
        System.out.println();
    }
}
