package DoublyLinkedList;

/**
 *
 * @author Admin
 */
public class Student {
    private int rollNumber;
    private String name;
    private double GPA;
    
    public Student(){
    }

    public Student(int rollNumber, String name, double GPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.GPA = GPA;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return rollNumber + ", " + name + ", " + GPA;
    }
    
}
