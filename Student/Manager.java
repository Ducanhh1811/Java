package Student;

import java.util.ArrayList;
import java.util.List;

public class Manager { 
    private List<Student> students;

    public Manager(){
        students = new ArrayList<>();
    }

    public void addStudent(Student st){
        students.add(st);
    }

    public List<Student> getStudents(){
        return students;
    }

    public int findStudentIndexById(String id){
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).getId().equalsIgnoreCase(id)){
                return i;
            }
        }
        return -1;
    }

    public boolean updateStudent(String id, String name, String courseName, int semester){
        int index = findStudentIndexById(id);
        if(index >= 0){
            Student s = students.get(index);
            s.setName(name);
            s.setCourse(courseName);
            s.setSemester(semester);
            return true;
        }
        return false;
    }

    public boolean removeStudent(String id){
        int index = findStudentIndexById(id);
        if(index >= 0){
            students.remove(index);
            return true;
        }
        return false;
    }

    public Student findStudentByIdS(String id){
        int index = findStudentIndexById(id);
        if(index >= 0){
            return students.get(index);
        }
        return null;
    }
}
