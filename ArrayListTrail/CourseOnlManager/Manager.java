package CourseOnlManager;

import java.util.ArrayList;

public class Manager {
    private ArrayList<CourseOnl> courseOnls;

    public Manager(){
        courseOnls = new ArrayList<>();
    }

    public ArrayList<CourseOnl> getCourseOnl(){
        return courseOnls;
    }

    public void add(CourseOnl c){
        if(c == null){
            throw new IllegalArgumentException("Course Online cannot be null.");
        }
        for (CourseOnl courseOnl : courseOnls) {
            if(courseOnl.getId().equalsIgnoreCase(c.getId())){
                throw new IllegalArgumentException("Employee ID already exist.");
            }
        }
        courseOnls.add(c);
    }

    // Tìm địa chỉ
    public int findIndex(String input){
        for(int i = 0; i < courseOnls.size(); i++){
            if(courseOnls.get(i).getId().equalsIgnoreCase(input) 
                || courseOnls.get(i).getName().equalsIgnoreCase(input)){
                    return i;
            }
        }
        return -1;
    }

    public CourseOnl findCourseOnl(String input){
        int index = findIndex(input);
        if(index >= 0){
            return courseOnls.get(index);
        }
        return null;
    }

    public void display(){
        if(courseOnls.isEmpty()){
            System.out.println("No Course Online.");
            return;
        }
        System.out.printf("%-10s %-20s %-20s %-15s %-10s%n",
                        "Id", "Name", "Instructor", "Price", "Enrolled Students");
        System.out.println("----------------------------------------------------------------------------------------");
        for (CourseOnl c : courseOnls) {
            System.out.printf("%-10s %-20s %-20s %-15s %-10s%n",
                            c.getId(), c.getName(), c.getInstructor(), c.getPrice(), c.getEnrolledStudents()
            );
        }
    }

    public boolean update(String id, String name, String instructor, double price, int enrolledStudents){
        int index = findIndex(id);
        if(index >= 0){
            CourseOnl c = courseOnls.get(index);
            c.setName(name);
            c.setInstructor(instructor);
            c.setPrice(price);
            c.setEnrolledStudents(enrolledStudents);
            return true;
        }
        return false;
    }

    public boolean delete(String input){
        int index = findIndex(input);
        if(index >= 0){
            courseOnls.remove(index);
            return true;
        }
        return false;
    }
}
