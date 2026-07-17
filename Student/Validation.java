package Student;

public class Validation {
    public static String validID(String id){
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be empty.");
        }
        return id.trim();
    }

    public static String validName(String name){
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be empty.");
        }
        return name.trim();
    }

    public static int validSemester(String semesterStr){
        if (semesterStr == null || semesterStr.trim().isEmpty()) {
            throw new IllegalArgumentException("Semester cannot be empty.");
        }
        try {
            int semester = Integer.parseInt(semesterStr.trim());
            if (semester <= 0) {
                throw new IllegalArgumentException("Semester must be a positive integer.");
            }
            return semester;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Semester must be a valid integer.");
        }
    }

    public static String validCourse(String course){
        if (course == null || course.trim().isEmpty()) {
            throw new IllegalArgumentException("Course name cannot be empty.");
        }
        course= course.trim().toLowerCase();
        if (!course.equals(".net") && !course.equals("java") && !course.equals("c/c++")) {
            throw new IllegalArgumentException("Invalid course name. Allowed values: .net, java, c/c++.");
        }
        if (course.equals(".net")) {
            return ".net";
        } else if (course.equals("java")) {
            return "java";
        } else {
            return "c/c++";
        }
    }
}
