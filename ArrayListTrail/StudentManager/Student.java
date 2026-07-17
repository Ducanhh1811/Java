package StudentManager;

public class Student {
    private String id;
    private String name;
    private float gpa;

    public Student() {
    }

    public Student(String id, String name, float gpa) {
        setGpa(gpa);
        setId(id);
        setName(name);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(id == null || id.isEmpty()){
            throw new IllegalArgumentException("ID cannot be empty.");
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

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        if(gpa < 0 || gpa > 4){
            throw new IllegalArgumentException("GPA must be between (0, 4)");
        }
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", gpa=" + gpa + "]";
    }

}
