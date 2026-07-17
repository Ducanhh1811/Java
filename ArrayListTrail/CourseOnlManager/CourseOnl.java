package CourseOnlManager;

public class CourseOnl {
    private String id;
    private String name;
    private String instructor;
    private double price;
    private int enrolledStudents;

    public CourseOnl() {
    }

    public CourseOnl(String id, String name, String instructor, double price, int enrolledStudents) {
        setEnrolledStudents(enrolledStudents);
        setId(id);
        setInstructor(instructor);
        setName(name);
        setPrice(price);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(id.isEmpty() || id == null){
            throw new IllegalArgumentException("Id cannot be empty.");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        if(instructor == null || instructor.isEmpty()){
            throw new IllegalArgumentException("Instructor cannot be empty.");
        }
        this.instructor = instructor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price <= 0){
            throw new IllegalArgumentException("Price must be greater than 0");
        }
        this.price = price;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(int enrolledStudents) {
        if(enrolledStudents < 0){
            throw new IllegalArgumentException("Enrolled Students must be > 0");
        }
        this.enrolledStudents = enrolledStudents;
    }

    @Override
    public String toString() {
        return "CourseOnl [id = " + id + ", name = " + name + ", instructor = " + instructor + ", price = " + price
                + ", enrolledStudents = " + enrolledStudents + "]";
    }

}
