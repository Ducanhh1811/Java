/**
 * Student class - Model for storing student information
 * Follows OOP principles with encapsulation
 */
public class Student {
    private String id;
    private String name;
    private double gpa;
    private String major;

    // Constructor
    public Student(String id, String name, double gpa, String major) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
        this.major = major;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    public String getMajor() {
        return major;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    // toString method for display
    @Override
    public String toString() {
        return id + " | " + name + " | " + gpa + " | " + major;
    }

    // Method to format for file storage
    public String toFileFormat() {
        return id + "," + name + "," + gpa + "," + major;
    }

    // Method to create Student from file format
    public static Student fromFileFormat(String line) {
        String[] parts = line.split(",");
        if (parts.length == 4) {
            return new Student(parts[0], parts[1], Double.parseDouble(parts[2]), parts[3]);
        }
        return null;
    }
}
