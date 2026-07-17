package Student;

public class Student {
    private String id;
    private String name;
    private String courseName;
    private int semester;

    public Student(){}

    public Student(String id, String name, String courseName, int semester) {
        setId(id);
        setName(name);
        setCourse(courseName);
        setSemester(semester);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(id == null || id.isEmpty()){
            throw new IllegalArgumentException("ID cannot be empty!");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty!");
        }
        this.name = name;
    }

    public String getCourse() {
        return courseName;
    }

    public void setCourse(String courseName) {
        if(courseName == null || courseName.trim().isEmpty()){
            throw new IllegalArgumentException("Course name cannot be empty!");
        }
        courseName = courseName.trim().toLowerCase();
        if(!courseName.equals(".net") && !courseName.equals("java") && !courseName.equals("c/c++")){
            throw new IllegalArgumentException("Invalid course name. Allowed values: .net, java, c/c++");
        }
        if(courseName.equals(".net")){
            this.courseName = ".net";
        }else if(courseName.equals("java")){
            this.courseName = "java";
        }else{
            this.courseName = "c/c++";
        }
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        if(semester <= 0){
            throw new IllegalArgumentException("Semester must be greater than 0!");
        }
        this.semester = semester;
    }
}
