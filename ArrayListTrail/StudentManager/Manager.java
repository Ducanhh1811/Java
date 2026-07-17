package StudentManager;

import java.util.ArrayList;

public class Manager {
    private ArrayList<Student> students;

    public Manager(){
        students = new ArrayList<>();
    }

    public ArrayList<Student> getStudent(){
        return students;
    }

    public void addStuden(Student s){
        for (Student extstingStudent : students) {
            if(extstingStudent.getName().equalsIgnoreCase(s.getName())){
                throw new IllegalArgumentException("Student name already exist.");
            }
        }
        students.add(s);
    }

    public void display(){
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public int findStudent(String id){
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).getId().equalsIgnoreCase(id)){
                return i;
            }
        }
        return -1;
    }

    public Student searchStudentByID(String id){
        int index = findStudent(id);
        if(index >= 0){
            return students.get(index);
        }
        return null;
    }

    public boolean update(String id, String name, float gpa){
        int index = findStudent(id);
        if(index >= 0){
            Student s = students.get(index);
            s.setName(name);
            s.setGpa(gpa);
            return true;
        }
        return false;
    }

    public boolean delete(String id){
        int index = findStudent(id);
        if(index >= 0){
            students.remove(index);
            return true;
        }
        return false;
    }
}
