package Student;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Report {
    private String studentName;
    private String courseName;
    private int totalSemester;

    public Report(String studentName, String courseName, int totalSemester) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.totalSemester = totalSemester;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getTotalSemester() {
        return totalSemester;
    }

    public void setTotalSemester(int totalSemester) {
        this.totalSemester = totalSemester;
    }

    @Override
    public String toString() {
        return String.format("%-10s | %-15s | %d", studentName, courseName, totalSemester);
    }

    public static void generateAndDisplayReport(Manager manager) {
        if (manager.getStudents().isEmpty()) {
            System.out.println("No Student available.");
            return;
        }

        Map<String, Integer> reportData = new LinkedHashMap<>();
        for (Student s : manager.getStudents()) {
            String key = s.getName() + "|" + s.getCourse();
            reportData.put(key, reportData.getOrDefault(key, 0) + s.getSemester());
        }

        System.out.println("\n--- Report ---");
        System.out.format("%-10s | %-15s | %-15s%n", "Name", "CourseName", "TotalSemester");

        for (Map.Entry<String, Integer> entry : reportData.entrySet()) {
            String[] parts = entry.getKey().split("\\|");
            String name = parts[0];
            String course = parts[1];
            Report report = new Report(name, course, entry.getValue());
            System.out.println(report);
        }
    }

    public static void showAllStudents(Manager manager) {
        List<Student> s = manager.getStudents();
        if (s.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("\n--- All Students ---");
        System.out.format("%-25s | %-10s | %-10s | %-10s%n", "ID", "Name", "Course", "Semester");
        for (Student student : s) {
            System.out.format("%-5s | %-10s | %-10s | %-10s%n", student.getId(), student.getName(), student.getCourse(),
                    student.getSemester());
        }
    }
}
