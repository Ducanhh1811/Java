package DoublyLinkedList;

/**
 *
 * @author Admin
 */
public class Test {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        // Check adding elements at the beginning of the list.
        list.addFirst(new Student(001, "Duc Anh", 4.0));
        list.addFirst(new Student(002, "Mai Hai", 3.6));
        list.addFirst(new Student(003, "Duy Hung", 3.6));

        System.out.println("List from head after addFirst:");
        list.traverseFromHead();

        // Check adding an element at the end of the list.
        list.addLast(new Student(004, "Thanh Son", 3.2));
        System.out.println("List from tail after addLast:");
        list.traverseFromTail();

        // A duplicate roll number should not be added.
        list.addLast(new Student(004, "Duplicate Student", 2.0));
        System.out.println("Search roll number 004 after duplicate add:");
        System.out.println(list.search(004));

        // Check searching by roll number and by name.
        System.out.println("Search roll number 002:");
        System.out.println(list.search(002));
        System.out.println("Search name 'mai hai':");
        for(Student student : list.search("mai hai")){
            System.out.println(student);
        }

        // Check removing the first element.
        list.removeFirst();
        System.out.println("List after removeFirst:");
        list.traverseFromHead();

        // Check removing the last element.
        list.removeLast();
        System.out.println("List after removeLast:");
        list.traverseFromHead();

        // Remove the remaining elements and check the empty-list behavior.
        list.removeFirst();
        list.removeLast();
        list.removeFirst();
        System.out.println("Is list empty: " + list.isEmpty());
        list.traverseFromHead();
    }
}
